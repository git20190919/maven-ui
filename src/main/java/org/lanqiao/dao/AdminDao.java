package org.lanqiao.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.entity.Admin;

/**
 * @author Administrator
 *
 */

public interface AdminDao {
	/**
	 * 验证用户名和密码
	 * @param admin
	 * @return
	 */
	@Select("select * from tc_admin where acname = #{acname} and apwd = #{apwd}")
	Admin selectAdminByAcnameAndApwd(Admin admin);
	/**
	 * 修改密码
	 * @param admin
	 * @return
	 */
	@Update("update tc_admin set apwd = #{apwd} where id = #{id}")
	int updatePwd(Admin admin);
	@Update("update tc_admin set aname=#{aname},atel=#{atel},aemail=#{aemail},updateuser=#{updateuser},updatetime=#{updatetime} "
			+ "where id = #{id} ")
	int updateAdminInfo(Admin admin);
}
