package com.hangu.framework.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 进行权限检查，决策管理。
 * 
 * @author 曹保利
 * 
 */
public class ExAccessDecisionManager implements AccessDecisionManager {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 核心方法：如果不存在对该资源的定义，直接放行； 否则，如果找到正确的角色，即认为拥有权限，并放行， 否则throw new AccessDeniedException("no right"); 这样，就会进入到的安全配置文件中 access-denied-page 配置节中配置的页面，即403.jsp页面。
	 */
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		
		if (configAttributes == null) {
			logger.debug("不存在对资源:" + object.toString() + "的定义");
			return;
		}
		logger.debug("正在访问的URL是：" + object.toString());
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			ConfigAttribute ca = ite.next();
			logger.debug("需要的角色是 :" + ca.getAttribute());
			String needRole = ((SecurityConfig) ca).getAttribute();
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				logger.debug("授权信息是：" + ga.getAuthority());
				if (needRole.equals(ga.getAuthority())) {
					logger.debug("判断到，needRole 是" + needRole + ",用户的角色是:" + ga.getAuthority() + "，授权数据相匹配");
					return;
				}
			}
		}
		throw new AccessDeniedException("没有权限");
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}
}
