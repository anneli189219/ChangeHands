package px_changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import px_changehands.dao.AdminDao;
import px_changehands.entity.Admin;
import px_changehands.entity.AdminSession;

public class AdminDaoImpl implements AdminDao {
	private Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname="root";
	private String dbupwd="189219";
	public AdminDaoImpl() {
		// TODO Auto-generated constructor stub
		//数据库操作初始化
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(dburl,dbuname,dbupwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建连接
	}
	
	//====================管理员模块==========================
	@Override//判断登录
	public boolean AdminLogin(String adminname, String adminpassword) {
		// TODO Auto-generated method stub
		String AdminLoginsql = "select * from Admin where UserName=? and Password=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(AdminLoginsql);
			pStatement.setString(1, adminname);
			pStatement.setString(2, adminpassword);
			ResultSet rSet=pStatement.executeQuery();
			if (rSet.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override//修改信息
	public void AdminUpdata(String oldpassword, Admin admin) {
		// TODO Auto-generated method stub
		String AdminUpdatasql = "update Admin set Password=? where id=? and Password=?" ;
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(AdminUpdatasql);
			pStatement.setString(1, admin.getAdminpassword());
			pStatement.setInt(2, admin.getId());
			pStatement.setString(3, oldpassword);
			pStatement.execute();//ִ执行
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override//查询数据
	public AdminSession GetAdmin(String adminname) {
		// TODO Auto-generated method stub
		String GetAdminIDsql = "select * from Admin where UserName=?";
		
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GetAdminIDsql);
			pStatement.setString(1, adminname);
			ResultSet rSet=pStatement.executeQuery();
			if (rSet.next()) {
				AdminSession adminSession = new AdminSession(rSet.getInt("ID"), rSet.getString("UserName"));
				return adminSession;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
}
/*
	INSERT INTO Admin() VALUES(10086,'px','e10adc3949ba59abbe56e057f20f883e');
 	删除数据库
	drop database ChangeHands;
	删除表
	drop TABLE Admin;
	新建数据库
	CREATE database ChangeHands;
	选择数据库
	use ChangeHands;
	查询代码
	select * from Admin;
	新建表
 	CREATE TABLE Admin(
		ID INT NOT NULL PRIMARY KEY,
		UserName varchar(20) NOT NULL,
		Password varchar(32) NOT NULL
	)ENGINE=InnoDB DEFAULT CHARSET=utf8; 
	
	
*/

