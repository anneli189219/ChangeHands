package changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import changehands.dao.ShoppingDao;
import changehands.entity.ShoppingBean;
import changehands.servlet.Shopping.shoppingHandle;
import changehands.tool.Tool;

public class ShoppingDaoImpl implements ShoppingDao {
	Tool tool = new Tool();
	//数据库连接
	private Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname="root";
	private String dbupwd="189219";
	
	public ShoppingDaoImpl() {
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
		//创建链接
	}
	
	@Override
	public void ShoppingInsert(ShoppingBean shoppingBean) {
		// TODO Auto-generated method stub
		String usersupdatesql="INSERT INTO Shopping() VALUES(?,?,?,?)";
        try {
			PreparedStatement pStatement=this.connection.prepareStatement(usersupdatesql);
			//填参数
			pStatement.setInt(1, shoppingBean.getID());
			pStatement.setInt(2, shoppingBean.getpID());
			pStatement.setInt(3, shoppingBean.getNumber());
			pStatement.setString(4, shoppingBean.getAddTime());
			pStatement.execute();//上传服务器
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public List<Map<String, Object>> ShoppingSelect(int id) {
		// TODO Auto-generated method stub
		String uSql = "select Product.TradeName,Product.Describes,Product.Price,Product.ShowPath,Shopping.Number,Shopping.AddTime,Shopping.pID from Product inner JOIN Shopping ON(Product.pID = Shopping.pID) where Shopping.ID=? order by Shopping.AddTime desc";
		
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, id);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();// 返回结果集
			
			return Tool.convertList(rSet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void ShoppingDel(int pid,int id) {
		// TODO Auto-generated method stub
		String usersupdatesql="delete from Shopping where pid=? and id=?";
        try {
			PreparedStatement pStatement=this.connection.prepareStatement(usersupdatesql);
			//填参数
			pStatement.setInt(1, pid);
			pStatement.setInt(2, id);
			pStatement.execute();//上传服务器
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Override
	public ShoppingBean getShoppingBean(int pID,int ID){
		String uSql = "select * from Shopping where pID=? and ID=?";
		ShoppingBean shoppingBean = new ShoppingBean();
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, pID);
			pStatement.setInt(2, ID);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();// 返回结果集
			while (rSet.next()) {
				shoppingBean = new ShoppingBean(rSet.getInt("ID"),rSet.getInt("pID"),rSet.getInt("Number"),rSet.getString("AddTime"));
				return shoppingBean;	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void ShoppingUpdate(int number,int pID, int ID) {
		// TODO Auto-generated method stub
		String usersupdatesql="update Shopping set number=? where pid=? and id=?";
        try {
			PreparedStatement pStatement=this.connection.prepareStatement(usersupdatesql);
			//填参数
			pStatement.setInt(1, number);
			pStatement.setInt(2, pID);
			pStatement.setInt(3, ID);
			pStatement.execute();//上传服务器
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getShoppingCount(int ID) {
		// TODO Auto-generated method stub
		String uSql = "select count(*) as count from Shopping where ID=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, ID);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();// 返回结果集
			while (rSet.next()) {
				return rSet.getInt("count");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}

}
