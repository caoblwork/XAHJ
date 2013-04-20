package com.hangu.framework.system.vo;

import java.util.ArrayList;
import java.util.List;

import com.hangu.framework.system.domain.Role;
import com.hangu.framework.vo.BaseVo;

/**
 * 用户VO对象
 * 
 * @author 辛 阳
 * 
 */
public class UserVo extends BaseVo {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 4584736887355772791L;
	/**
	 * 用户帐号
	 */
	private String loginId;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 用户性别
	 */
	private String sex;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 联系电话
	 */
	private String mobileNumber;
	/**
	 * 部门编号
	 */
	private String organizationId;
	/**
	 * 所属部门
	 */
	private String organizationName;
	/**
	 * 多对多的关联关系
	 */
	private List<Role> roles = new ArrayList<Role>();

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
