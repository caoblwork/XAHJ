package com.hangu.framework.system.service;

import java.util.List;

import com.hangu.framework.service.EntityService;
import com.hangu.framework.system.domain.User;
import com.hangu.framework.system.vo.UserVo;

public interface UserService extends EntityService<UserVo, User> {

	List<UserVo> getUserByOrganId(String id);

	UserVo getUserByLoginId(String loginId);

	/**
	 * @author 曹保利
	 *         <ol>
	 *         该方法的说明
	 *         <li>为userTask设置多个task的参与人</li>
	 *         <li>
	 *         返回的结果是一个list<String>的id列表集合。<font
	 *         color="red">（<b>API说明CandidateUsers属性必须是collection
	 *         (String)类型的参数）</font> </b></li>
	 *         </ol>
	 * 
	 * @param roleName
	 * @return
	 */
	public List<String> getCandidateUsersByRoles(String roleName);
}
