package com.hangu.framework.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.hangu.framework.system.service.ModelService;
import com.hangu.framework.system.service.ResourceService;
import com.hangu.framework.system.service.RoleService;
import com.hangu.framework.system.vo.ModelVo;
import com.hangu.framework.system.vo.ResourceVo;
import com.hangu.framework.system.vo.RoleVo;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 注意，我例子中使用的是AntUrlPathMatcher这个path matcher来检查URL是否与资源定义匹配， 事实上你还要用正则的方式来匹配，或者自己实现一个matcher。 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 说明：对于方法的spring注入，只能在方法和成员变量里注入， 如果一个类要进行实例化的时候，不能注入对象和操作对象， 所以在构造函数里不能进行操作注入的数据。
 * 
 * @author 曹保利
 * 
 */
public class InvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 访问地址匹配器
	 */
	private PathMatcher urlMatcher = new AntPathMatcher();

	/**
	 * 资源集合
	 */
	private static Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

	private ResourceService resourceService = SpringContextHolder.getBean("resourceService");

	private RoleService roleService = (RoleService) SpringContextHolder.getBean("roleService");

	private ModelService modelService = (ModelService) SpringContextHolder.getBean("modelService");

	@SuppressWarnings("unchecked")
	public InvocationSecurityMetadataSourceService() {

		// 装载URl资源
		List<RoleVo> roleList = (List<RoleVo>) roleService.getAll().getResultObject();
		for (RoleVo roleVo : roleList) {
			ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + roleVo.getCode());
			List<ModelVo> modelVos = modelService.getModelByRoleId(roleVo.getId());
			for (ModelVo modelVo : modelVos) {
				List<ResourceVo> resourceVos = resourceService.getResourcesByModelId(modelVo.getId());// model.getResources();
				for (ResourceVo resourceVo : resourceVos) {
					logger.debug("角色[" + roleVo.getName() + "]拥有的action有：" + resourceVo.getAddress());
					String[] urls = null;
					if (null != resourceVo.getAddress() && resourceVo.getAddress().indexOf(",") != -1) {
						urls = resourceVo.getAddress().split(",");
					} else {
						urls = new String[] { resourceVo.getAddress() };
					}
					for (int i = 0; i < urls.length; i++) {
						if (resourceMap.containsKey("/" + urls[i])) {
							Collection<ConfigAttribute> configAttributes = resourceMap.get("/" + urls[i]);
							configAttributes.add(configAttribute);
							resourceMap.put("/" + urls[i], configAttributes);
						} else {
							Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
							configAttributes.add(configAttribute);
							resourceMap.put("/" + urls[i], configAttributes);
						}
					}
				}

			}
		}

		/**
		 * 在资源表中的资源并且没有在权限系统中定义的，默认定义为ROLE_SYSTEM角色访问权限。 原因是没有在权限表中定义的资源默认是放行的，但在系统中资源表中的资源如果没有分配给某个角色意味着没有访问权限。
		 */
		List<ResourceVo> resvoList = (List<ResourceVo>) resourceService.getAll().getResultObject();
		for (ResourceVo resource : resvoList) {
			if (null != resource.getAddress()) {
				String url = "/" + resource.getAddress();
				if (!resourceMap.containsKey(url)) {
					ConfigAttribute configAttribute = new SecurityConfig("ROLE_SYSTEM");
					Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
					configAttributes.add(configAttribute);
					resourceMap.put(url, configAttributes);
				}
			}
		}
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl();
		logger.debug("当前处理的URL为：" + url);
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			// 判断当前迭代中的URL是否与需要验证的URL匹配，实际当中可能需要用正则表达式来判断，或者更复杂情况下自己实现匹配器（UrlMatcher）
			if (null != resURL && null != url && urlMatcher.match(url, resURL)) {
				Collection<ConfigAttribute> cas = resourceMap.get(resURL);
				for (ConfigAttribute ca : cas) {
					logger.debug(resURL + "需要的权限是：" + ca.getAttribute());
				}
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	/* Gettings && Settings */

	public void setUrlMatcher(PathMatcher urlMatcher) {
		this.urlMatcher = urlMatcher;
	}
}
