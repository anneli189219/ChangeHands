package px_changehands.dao;

import px_changehands.entity.Admin;
import px_changehands.entity.AdminSession;

public interface AdminDao {
	
	//========================管理员模块===================
	/**
	 	管理员登录功能的实体?
	 * @param adminname 管理员帐号
	 * @param adminpassword 管理员密码
	 * @return 登录是否成功 true表示登录成功 false表示登录失败
	 */
	public boolean AdminLogin(String adminname, String adminpassword);
	/**
	 * 修改信息
	 * @param oldpassword 管理员密码
	 */
	public void AdminUpdata(String oldpassword, Admin admin);
	/**
	 * 获取ID
	 * @param username 管理员用户名
	 */
	public AdminSession GetAdmin(String adminname);
	
	
	
	}
