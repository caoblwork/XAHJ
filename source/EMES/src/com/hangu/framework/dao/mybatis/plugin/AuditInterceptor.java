package com.hangu.framework.dao.mybatis.plugin;

import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hangu.common.util.StringUtil;
import com.hangu.framework.dao.domain.Auditable;
import com.hangu.framework.security.SpringSecurityUtils;

/**
 * 通过该拦截器维护审计信息
 * 
 * @author 曹保利
 * 
 */

@Intercepts(value = { @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class AuditInterceptor implements Interceptor {

	private Logger logger = LoggerFactory.getLogger(AuditInterceptor.class);

	@SuppressWarnings("unused")
	private Properties properties;

	/**
	 * 拦截“insert、update”方法进行审计信息的维护
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		String sqlId = mappedStatement.getId();
		String dbAccessMethod = sqlId.substring(sqlId.lastIndexOf(".") + 1);
		if (dbAccessMethod.startsWith("insert")) {
			logger.info("intercept audit information that method name with insert! ");
			Object parameter = invocation.getArgs()[1];
			if (parameter instanceof Auditable) {
				Auditable auditable = (Auditable) parameter;

				auditable.setCreateBy(SpringSecurityUtils.getCurrentUserName());
				if(auditable.getCreateDate()==null){
					auditable.setCreateDate(new Date());
				}
				auditable.setUpdateBy(SpringSecurityUtils.getCurrentUserName());
				auditable.setUpdateDate(new Date());
				auditable.setVersion(0);
				if (!StringUtil.isValidString(auditable.getStatus())) {
					auditable.setStatus("0");
				}
			}

		} else if (dbAccessMethod.startsWith("update")) {
			Object parameter = invocation.getArgs()[1];
			if (parameter instanceof Auditable) {
				Auditable auditable = (Auditable) parameter;
				// 将当前登录用户的登录名设置给更新人
				auditable.setUpdateBy(SpringSecurityUtils.getCurrentUserName());
				auditable.setUpdateDate(new Date());
				// 版本+1
				Integer version = auditable.getVersion();
				if (null == version) {
					version = 0;
				}
				auditable.setVersion(version + 1);
				if (!StringUtil.isValidString(auditable.getStatus())) {
					auditable.setStatus("0");
				}
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
