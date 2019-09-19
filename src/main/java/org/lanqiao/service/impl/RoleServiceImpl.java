package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.PrivDao;
import org.lanqiao.dao.RoleDao;
import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;
import org.lanqiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao;
	@Autowired
	PrivDao privDao;
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		List<Role> lr = roleDao.selectAllRoles();//只有角色的id和name
		for(Role r : lr) {
			List<Priv> lp = privDao.selectPrivsByRid(r.getId());
			r.setLp(lp);//添加到集合中
		}
		//这样循环操作对数据库压力比较大，执行sql语句的次数比较多，思考如何只执行一次sql查询即可完成
		//SELECT r.*,p.* FROM tc_role r,tc_priv p,tc_role_priv rp WHERE r.id=rp.`rid` AND p.`id`=rp.`pid`
		//利用Map的key是唯一的特性，可以把值装入map中   Map<String,List<Priv>>; map<1,lp1> map(2,lp2)
		
		return lr;
	}
	@Override
	public List<Priv> getAllPrivs() {
		// TODO Auto-generated method stub
		return privDao.selectAllPrivs();
	}
	@Override
	public boolean addRole(Role role) {
		// TODO Auto-generated method stub
		int id = roleDao.insertRole(role);//获取返回自动生成的id值
		if(id != -1) {//表示获取id值成功
			role.setId(id);//添加到role对象中
			roleDao.insertRolePriv(role);//添加关联表中
		}
		return id!=-1?true:false;
	}
	@Override
	public boolean deleteRole(int rid) {
/*		Connection conn = JDBCUtil2.getConnection();
		JDBCUtil2.startTransaction();
		//int i = roleDao.deleteRole(rid,conn);
		int j = roleDao.deleteRolePriv(rid,conn);
		JDBCUtil2.endTransaction();
		return i+j>=2?true:false;*/
		return false;
	}
	@Override
	public boolean updateRole(Role role) {
		// TODO Auto-generated method stub
		int i = roleDao.updateRole(role);
		//int j = roleDao.deleteRolePriv(role.getId(),conn);
		int k = roleDao.insertRolePriv(role);
		
		return i+k>=3?true:false;
	}
	@Override
	public Role getRoleById(int rid) {
		Role role = roleDao.selectRoleById(rid);
		List<Priv> lp = privDao.selectPrivsByRid(rid);
		role.setLp(lp);
		return role;
	}
}
