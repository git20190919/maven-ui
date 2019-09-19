package org.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.entity.Role;

public interface RoleDao {
	/**
	 * 根据rid查询role
	 * @param rid
	 * @return
	 */
	@Select("select * from tc_role where rid = #{rid}")
	Role selectRoleById(int rid);
	/**
	 * 根据管理员id查询对应的所有角色
	 * @param aid
	 * @return
	 */
	@Select("select * "
				   + "from tc_role "
				   + "where id in(select rid "
				   				+ "from tc_admin_role "
				   				+ "where aid = #{aid})")
	List<Role> selectRnameByAid(int aid);
	/**
	 * 查询所有角色信息
	 * @return
	 */
	@Select("select * from tc_role")
	List<Role> selectAllRoles();
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	@Insert("insert into tc_role(rname,by001) values(#{rname},#{by001})")
	int insertRole(Role role);
	/**
	 * 添加角色权限关联表
	 * @param role
	 * @return 注：int返回值，表示获取添加新纪录的自动生成的id值
	 */
	@Insert("insert into tc_role_priv(rid,pid) values(#{rid},#{pid})")
	int insertRolePriv(Role role);
	/**
	 * 删除角色
	 * @param rid
	 * @return
	 */
	@Delete("delete from tc_role where id=#{rid}")
	int deleteRole(int rid) throws Exception;
	/**
	 * 删除关联表
	 * @param rid
	 * @return
	 */
	@Delete("delete from tc_role_priv where rid=#{rid}")
	int deleteRolePriv(int rid);
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@Update("update tc_role set rname=#{rname},by001=#{by001} where id=#{id}")
	int updateRole(Role role);
	
	
	
}
