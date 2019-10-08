package px_changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import px_changehands.Service.ToolService;
import px_changehands.dao.UsersDao;
import px_changehands.entity.Users;

public class UsersDaoImpl implements UsersDao {
	private Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname="root";
	private String dbupwd="189219";
	public UsersDaoImpl() {
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

	//====================操作用户==========================
		//====================================================	
		@Override//添加
		public void UsersAdd(Users users) {
			// TODO Auto-generated method stub
			String UsersAddsql = "INSERT INTO User() VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			try {
				ToolService toolService = new ToolService();
				PreparedStatement pStatement=this.connection.prepareStatement(UsersAddsql);
				int rand = toolService.Randomvalue();
				pStatement.setInt(1, rand);
				pStatement.setString(2, users.getUsername());
				pStatement.setString(3, users.getPassword());
				pStatement.setString(4, users.getRealname());
				pStatement.setString(5, users.getSex());
				pStatement.setInt(6, users.getAge());
				pStatement.setString(7, users.getEmail());
				pStatement.setString(8, users.getMobile());
				pStatement.setString(9, users.getAddress());
				pStatement.setString(10, users.getHeadpath());
				pStatement.setString(11, toolService.GetisTime());
				pStatement.execute();//执行
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		@Override//删除
		public void UsersDelete(int id) {
			// TODO Auto-generated method stub
			String UsersDeletesql = "delete from User where id=?";
			try {
				PreparedStatement pStatement=this.connection.prepareStatement(UsersDeletesql);
				pStatement.setInt(1, id);
				pStatement.execute();//执行
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		@Override//查询全部
		public ArrayList<Users> UsersSelect() {
			// TODO Auto-generated method stub
			String UsersSelectsql = "select * from User";
			try {
				PreparedStatement pStatement=this.connection.prepareStatement(UsersSelectsql);
				ResultSet rSet=pStatement.executeQuery();
				ArrayList<Users>arrayList = new ArrayList<Users>();
				ToolService toolService = new ToolService();
				while (rSet.next()) {
					Users users = new Users(rSet.getString("UserName"),
							rSet.getString("RealName"),
							rSet.getString("Sex"),
							rSet.getInt("Age"),
							rSet.getString("Email"),
							rSet.getString("Mobile"),
							rSet.getString("Address"));
					users.setId(rSet.getInt("ID"));
					users.setRegtime(toolService.getsqltime(rSet.getString("RegTime")));
					arrayList.add(users);
				}
				return arrayList;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
		
		@Override// 查询指定
		public Users UsersSelectOne(int id) {
			// TODO Auto-generated method stub
			String UsersSelectOnesql = "select * from User where id=?";
			try {
				PreparedStatement pStatement=this.connection.prepareStatement(UsersSelectOnesql);
				pStatement.setInt(1, id);
				ResultSet rSet=pStatement.executeQuery();
				if (rSet.next()) {
					Users users = new Users(rSet.getString("UserName"),
							rSet.getString("RealName"),
							rSet.getString("Sex"),
							rSet.getInt("Age"),
							rSet.getString("Email"),
							rSet.getString("Mobile"),
							rSet.getString("Address"));
					users.setHeadpath(rSet.getString("HeadPath"));
					return users;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}

		@Override//修改用户信息
		public void UsersUpdata(int id, Users users) {
			// TODO Auto-generated method stub
			String UsersUpdatasql = "update User set UserName=?,RealName=?,Sex=?,Age=?,Email=?,Mobile=?,Address=?,HeadPath=? where id=?";
			try {
				PreparedStatement pStatement=this.connection.prepareStatement(UsersUpdatasql);
				pStatement.setString(1, users.getUsername());
				pStatement.setString(2, users.getRealname());
				pStatement.setString(3, users.getSex());
				pStatement.setInt(4, users.getAge());
				pStatement.setString(5, users.getEmail());
				pStatement.setString(6, users.getMobile());
				pStatement.setString(7, users.getAddress());
				pStatement.setString(8, users.getHeadpath());
				pStatement.setInt(9, id);
				pStatement.execute();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		@Override//修改用户密码
		public void UsersUpdatapassword(int id, String Password) {
			// TODO Auto-generated method stub
			String UsersUpdatapasswordsql = "update User set Password=? where id=?";
			try {
				PreparedStatement pStatement=this.connection.prepareStatement(UsersUpdatapasswordsql);
				pStatement.setString(1, Password);
				pStatement.setInt(2, id);
				pStatement.execute();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		@Override//查询用户总数
		public String UsersNumber() {
			// TODO Auto-generated method stub
			String UsersNumbersql = "select count(*)as count from User";
			try {
				PreparedStatement pStatement=this.connection.prepareStatement(UsersNumbersql);
				ResultSet rSet=pStatement.executeQuery();
				rSet.next();
				return rSet.getString("count");
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}

		@Override//模糊查询
		public ArrayList<Users> UsersSelectlike(String usersname) {
			// TODO Auto-generated method stub
			String UsersSelectlikesql = "select * from user where username like '%"+usersname+"%'";
			try {
				PreparedStatement pStatement=this.connection.prepareStatement(UsersSelectlikesql);
				ResultSet rSet=pStatement.executeQuery();
				ArrayList<Users>arrayList = new ArrayList<Users>();
				ToolService toolService = new ToolService();
				while (rSet.next()) {
					Users users = new Users(rSet.getString("UserName"),
							rSet.getString("RealName"),
							rSet.getString("Sex"),
							rSet.getInt("Age"),
							rSet.getString("Email"),
							rSet.getString("Mobile"),
							rSet.getString("Address"));
					users.setId(rSet.getInt("ID"));
					users.setRegtime(toolService.getsqltime(rSet.getString("RegTime")));
					arrayList.add(users);
				}
				return arrayList;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}

		@Override//查询检索后用户数
		public String UsersQueryNumber(String usersname) {
			// TODO Auto-generated method stub
			String UsersQueryNumbersql = "select count(*)as count from User where username like '%"+usersname+"%'";
			try {
				PreparedStatement pStatement=this.connection.prepareStatement(UsersQueryNumbersql);
				ResultSet rSet=pStatement.executeQuery();
				rSet.next();
				return rSet.getString("count");
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "1";
		}

		@Override//查询重复ID
		public boolean RepeatQuery(int id) {
			// TODO Auto-generated method stub
			String RepeatQuerysql = "select * from user where id=?";
			try {
				PreparedStatement pStatement=this.connection.prepareStatement(RepeatQuerysql);
				pStatement.setInt(1, id);
				ResultSet rSet=pStatement.executeQuery();
				if (rSet.next()) {
					return false;
				}else {
					return true;
				}
			} catch (SQLException  e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return false;
		}

}
/*CREATE TABLE User(
	ID INT NOT NULL,
	UserName VARCHAR(20) NOT NULL,
	Password VARCHAR(32) NOT NULL,
	RealName VARCHAR(20),
	Sex VARCHAR(8),
	Age INT,
	Email VARCHAR(50),
	Mobile VARCHAR(50),
	Address VARCHAR(50),
	HeadPath VARCHAR(50),
	RegTime Datetime  NOT NULL,
	PRIMARY KEY(ID)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	DROP PROCEDURE test;

	delimiter $$
	create procedure test()
	begin
	declare i int;
	        set i = 0;
	while i <= 100 do
	            INSERT INTO user() VALUES(i,'ikun','202cb962ac59075b964b07152d234b70','蔡徐坤','女',18,'450709852@qq.com','15277513192','广西民族大学相思湖学院','','2019-06-15 14:11:32');
	            set i = i + 1;
	        end while;
	end
	$$
	delimiter ;
	call test();
*/
