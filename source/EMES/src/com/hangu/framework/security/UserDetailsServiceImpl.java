package com.hangu.framework.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hangu.common.util.DateUtil;
import com.hangu.framework.system.service.RoleService;
import com.hangu.framework.system.service.UserService;
import com.hangu.framework.system.vo.RoleVo;
import com.hangu.framework.system.vo.UserVo;

/**
 * 扩展...
 * 
 * @author 曹保利
 * 
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		logger.debug("当前用户ID：" + username);

		UserService userService = (UserService) SpringContextHolder.getApplicationContext().getBean("userService");
		RoleService roleService = (RoleService) SpringContextHolder.getApplicationContext().getBean("roleService");

		UserVo userVo = userService.getUserByLoginId(username);
		if (userVo == null) {
			logger.debug("用户[" + username + "]不存在");
			throw new UsernameNotFoundException("用户" + username + " 不存在");
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		List<RoleVo> roleList = roleService.getRoleByUserId(userVo.getId());

		for (RoleVo roleVo : roleList) {
			authorities.add(new GrantedAuthorityImpl("ROLE_" + roleVo.getCode()));
			logger.debug("用户[" + userVo.getName() + "]拥有角色[" + roleVo.getName() + "（" + roleVo.getCode() + "）],即spring security中的access");
		}

		boolean enabled = Boolean.TRUE;
		boolean accountNonExpired = Boolean.TRUE;
		boolean credentialsNonExpired = Boolean.TRUE;
		boolean accountNonLocked = Boolean.TRUE;

		UserInfo userInfo = new UserInfo(userVo.getLoginId(), userVo.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		userInfo.setLoginTime(DateUtil.getDateNow());
		userInfo.setRealName(userVo.getName());
		userInfo.setUserId(userVo.getId());
		userInfo.setOrganId(userVo.getOrganizationId());

		return userInfo;
	}

}
