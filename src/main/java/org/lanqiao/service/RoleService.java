package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;

public interface RoleService {
	/**
	 * 根据id查询角色信息
	 * @param rid
	 * @return
	 */
	Role getRoleById(int rid);
	/**
	 * 获取所有角色信息,包括角色id，角色名称，角色对应的所有权限
	 * @return
	 */
	List<Role> getAllRoles();
	/**
	 * 获取所有权限
	 * @return
	 */
	List<Priv> getAllPrivs();
	/**
	 * 添加角色包括角色名及该角色拥有的权限
	 * @param role
	 * @return
	 */
	boolean addRole(Role role);
	/**
	 * 删除角色
	 * @param rid
	 * @return
	 */
	boolean deleteRole(int rid);
	/**
	 * 修改角色信息
	 * @param role
	 * @return
	 */
	
	boolean updateRole(Role role);
}
