package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.AdminDao;
import org.lanqiao.dao.PrivDao;
import org.lanqiao.dao.RoleDao;
import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;
import org.lanqiao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDao adminDao;
	@Autowired
	PrivDao privDao;
	@Autowired
	RoleDao roleDao;
	@Override
	public Admin checkUsernameAndPwd(Admin admin) {
		//查询用户名和密码到tc_admin表中
		Admin admin2 = adminDao.selectAdminByAcnameAndApwd(admin); 
		//假如登录成功，继续获取该管理员的所有权限由tc_priv表
		if(admin2 != null) {
			List<Priv> lp = privDao.selectPrivsByAid(admin2.getId());
			List<Role> lr = roleDao.selectRnameByAid(admin2.getId());
			admin2.setLp(lp);
			admin2.setLr(lr);
		}
		return admin2;
	}
	@Override
	public boolean updateApwd(Admin admin) {
		// TODO Auto-generated method stub
		int i = adminDao.updatePwd(admin);
		return i > 0?true:false;
	}
	@Override
	public boolean updateAdminInfo(Admin admin) {
		// TODO Auto-generated method stub
		int i = adminDao.updateAdminInfo(admin);
		return i > 0?true:false;
	}
}
