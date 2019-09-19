package org.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.Priv;
public interface PrivDao {
	/**
	 * 通过管理员id获取该用户的所有权限
	 * @param aid
	 * @return
	 */
	@Select("select * "
				   + "from tc_priv "
				   + "where pid in(select pid "
				   				+ "from tc_role_priv "
				   				+ "where rid in(select rid "
				   								+ "from tc_admin_role "
				   								+ "where aid = #{aid}))")
	List<Priv> selectPrivsByAid(int aid);
	/**
	 * 通过角色id查询所有权限
	 * @param rid
	 * @return
	 */
	@Select("select * "
				   + "from tc_priv "
				   + "where pid in(select pid "
				   				+ "from tc_role_priv "
				   				+ "where rid = #{rid}) and state=0")
	List<Priv> selectPrivsByRid(int rid);
	
	/**
	 * 获取所有权限
	 * @return
	 */
	@Select("select * from tc_priv")
	List<Priv> selectAllPrivs();
}
