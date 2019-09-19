package org.lanqiao.service;

import org.lanqiao.entity.Admin;

public interface AdminService {
	/**
	 * 校验用户名密码
	 * 成功继续获取该用户权限
	 * 不成功方法返回null
	 * @param admin
	 * @return
	 */
	Admin checkUsernameAndPwd(Admin admin);
	/**
	 * 修改管理密码
	 * @param admin
	 * @return
	 */
	boolean updateApwd(Admin admin);
	/**
	 * 修改管理员自己的用户信息
	 * @param admin
	 * @return
	 */
	boolean updateAdminInfo(Admin admin);

}	
