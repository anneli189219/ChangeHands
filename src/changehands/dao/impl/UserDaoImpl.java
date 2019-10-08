package changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import changehands.dao.UserDao;
import changehands.entity.UserBean;
import changehands.tool.Tool;

public class UserDaoImpl implements UserDao {
	Tool tool = new Tool();
	//数据库连接
	private static Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname="root";
	private String dbupwd="189219";
	public UserDaoImpl() {
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
	
	@Override
	public boolean UserNameCheck(String UserName1,String UserName2){
		String uSql="select * from user where UserName=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(uSql);
			pStatement.setString(1,UserName2);
			pStatement.execute();
			ResultSet rSet=pStatement.executeQuery();//返回结果集
			while (rSet.next()) {
				if (UserName1.equals(UserName2))  {
					return false;
				}
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void UserInsert(UserBean User) {
		// TODO Auto-generated method stub
		
		String uSql="insert into user() values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement=connection.prepareStatement(uSql);
			
			pStatement.setInt(1, tool.getRandom(6));
			pStatement.setString(2, User.getUserName());
			pStatement.setString(3, User.getPassword());
			pStatement.setString(4, User.getRealName());
			pStatement.setString(5, User.getSex());
			pStatement.setInt(6, User.getAge());
			pStatement.setString(7, User.getEmail());
			pStatement.setString(8, User.getMobile());
			pStatement.setString(9, User.getAddress());
			pStatement.setString(10, User.getHeadPath());
			pStatement.setString(11, tool.getNowTime());
			
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@SuppressWarnings("static-access")
	@Override
	public UserBean UserSelect(int id) {
		// TODO Auto-generated method stub
		UserBean userBean = new UserBean();
		String uSql="select * from user where id=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(uSql);
			pStatement.setInt(1,id);
			pStatement.execute();
			ResultSet rSet=pStatement.executeQuery();//返回结果集

			while (rSet.next()) {
				userBean.setID(rSet.getInt("ID"));
				userBean.setUserName(rSet.getString("UserName"));
				userBean.setPassword(rSet.getString("Password"));
				userBean.setRealName(rSet.getString("RealName"));
				userBean.setSex(rSet.getString("Sex"));
				userBean.setAge(rSet.getInt("Age"));
				userBean.setEmail(rSet.getString("Email"));
				userBean.setMobile(rSet.getString("Mobile"));
				userBean.setAddress(rSet.getString("Address"));
				userBean.setHeadPath(rSet.getString("HeadPath"));
				userBean.setRegTime(tool.gainString(rSet.getString("RegTime")));
			}
			return userBean;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public boolean UserLogin(String UserName, String Password) {
		// TODO Auto-generated method stub
		String uSql="select * from User where UserName=? and Password=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(uSql);
			//填传值参数
			pStatement.setString(1, UserName);
			pStatement.setString(2, Password);
			//得到返回的结果集
			ResultSet rSet=pStatement.executeQuery();
			//如果有返回结果
			if(rSet.next()){
				//表示获取到符合条件的数据库表记录 即登录成功
				return true;
			}else{
				//登录失败
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int getUserID(String UserName){
		String uSql="select * from User where UserName=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(uSql);
			//填传值参数
			pStatement.setString(1, UserName);
			//得到返回的结果集
			ResultSet rSet=pStatement.executeQuery();
			//如果有返回结果
			if(rSet.next()){
				return rSet.getInt("ID");
			}else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public void UserUpdate(int id, UserBean User) {
		// TODO Auto-generated method stub
		//Tool tool = new Tool();
		String uSql="update user set UserName=?,Password=?,RealName=?,Sex=?,Age=?,Email=?,Mobile=?,Address=?,HeadPath=? where id=?";
        try {
			PreparedStatement pStatement=connection.prepareStatement(uSql);
			
			pStatement.setString(1, User.getUserName());
			pStatement.setString(2, User.getPassword());
			pStatement.setString(3, User.getRealName());
			pStatement.setString(4, String.valueOf(User.getSex()));
			pStatement.setInt(5, User.getAge());
			pStatement.setString(6, User.getEmail());
			pStatement.setString(7, User.getMobile());
			pStatement.setString(8, User.getAddress());
			pStatement.setString(9, User.getHeadPath());
			pStatement.setInt(10, id);
			
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void UserDel(int id) {
		// TODO Auto-generated method stub
		String uSql="delete from user where id=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(uSql);
			pStatement.setInt(1,id);
			pStatement.execute();//不返回结果集	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 得到查询id的用户名 静态方法
	 * @param id 查询用户的id
	 * @return 返回用户名
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static String getUserName_(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChangeHands","root","189219");
		
		String uSql="select UserName from User where id=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(uSql);
			//填传值参数
			pStatement.setInt(1, id);
			//得到返回的结果集
			ResultSet rSet=pStatement.executeQuery();
			//如果有返回结果
			if(rSet.next()){
				return rSet.getString("UserName");
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getUserName(int id) {
		// TODO Auto-generated method stub
		String uSql="select UserName from User where id=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(uSql);
			//填传值参数
			pStatement.setInt(1, id);
			//得到返回的结果集
			ResultSet rSet=pStatement.executeQuery();
			//如果有返回结果
			if(rSet.next()){
				return rSet.getString("UserName");
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到查询用户id的头像路径 静态方法
	 * @param id 查询用户的id
	 * @return 返回查询用户头像路径
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static String getUserPath(int id) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChangeHands","root","189219");
		
		String uSql="select HeadPath from User where id=?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(uSql);
			pStatement.setInt(1, id);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				return rSet.getString("HeadPath");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 查询注册的用户名是否重复
	 * @param username 用户名
	 * @return true重复 false不重复
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static boolean getUserNameFlag(String username) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChangeHands","root","189219");
		
		String uSql="select * from User where username=?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(uSql);
			pStatement.setString(1, username);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean getUserPasswordFlag(String username, String email){
		String uSql="select * from User where username=? and email=?";
		
		try {
			PreparedStatement pStatement = connection.prepareStatement(uSql);
			pStatement.setString(1, username);
			pStatement.setString(2, email);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
