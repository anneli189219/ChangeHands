package changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import changehands.dao.ShoppedDao;
import changehands.entity.ShoppedBean;

import changehands.tool.Tool;

public class ShoppedDaoImpl implements ShoppedDao {
	Tool tool = new Tool();

	// 数据库连接
	private Connection connection;
	private String dburl = "jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname = "root";
	private String dbupwd = "189219";

	public ShoppedDaoImpl() {
		// TODO Auto-generated constructor stub
		// 数据库操作初始化
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dburl, dbuname, dbupwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 创建连接
	}

	@Override
	public List<Map<String, Object>> getSaleSelect(int sid){
		String uSql = "select Shopped.sID,Shopped.pID,Product.TradeName,Product.Describes,Product.Price,Product.ShowPath,Shopped.Number,Shopped.ShopTime from Product inner JOIN Shopped ON(Product.pid = Shopped.pid) where Shopped.sID=? order by ShopTime desc";
		
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, sid);
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
	public List<Map<String, Object>> getSaleSet(int id){
		
		String uSql = "select Shopped.sID,Shopped.pID,Product.TradeName,Product.Describes,Product.Price,Product.ShowPath,Shopped.Number,Shopped.ShopTime from Product inner JOIN Shopped ON(Product.pid = Shopped.pid) where Product.ID=? order by ShopTime desc";

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
	public List<Map<String, Object>> getSaleSet(int id,String text){
		
		String uSql = "select Shopped.sID,Shopped.pID,Product.TradeName,Product.Describes,Product.Price,Product.ShowPath,Shopped.Number,Shopped.ShopTime from Product inner JOIN Shopped ON(Product.pid = Shopped.pid) where Product.ID=? and Product.Describes like ? order by ShopTime desc";

		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, id);
			pStatement.setString(2, "%"+text+"%");
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
	public List<Map<String, Object>> getShoppedSet_(int id) {

		String uSql = "select Shopped.sID,Shopped.pID,Product.TradeName,Product.Describes,Product.Price,Product.ShowPath,Shopped.Number,Shopped.ShopTime from Product left JOIN Shopped ON(Product.pid = Shopped.pid) where Shopped.ID=? order by ShopTime desc";

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
	public List<Map<String, Object>> getShoppedSet_(int id,String text){

		String uSql = "select Shopped.sID,Shopped.pID,Product.TradeName,Product.Describes,Product.Price,Product.ShowPath,Shopped.Number,Shopped.ShopTime from Product left JOIN Shopped ON(Product.pid = Shopped.pid) where Shopped.ID=? and Product.Describes like ? order by ShopTime desc";
		
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, id);
			pStatement.setString(2, "%"+text+"%");
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
	public ArrayList<ShoppedBean> getShoppedSet(int id) {
		// TODO Auto-generated method stub

		ArrayList<ShoppedBean> ShoppedList = new ArrayList<ShoppedBean>();
		ShoppedBean ShoppedBean = null;

		String uSql = "select * from Shopped where ID=? order by ShopTime desc";

		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, id);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();// 返回结果集

			while (rSet.next()) {
				ShoppedBean = new ShoppedBean();

				ShoppedBean.setID(rSet.getInt("ID"));
				ShoppedBean.setpID(rSet.getInt("pID"));
				ShoppedBean.setNumber(rSet.getInt("Number"));
				ShoppedBean.setShopTime(rSet.getString("ShopTime"));

				ShoppedList.add(ShoppedBean);
			}
			return ShoppedList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<ShoppedBean> getShoppedSet(String text) {
		// TODO Auto-generated method stub

		ArrayList<ShoppedBean> ShoppedList = new ArrayList<ShoppedBean>();
		ShoppedBean ShoppedBean = null;

		String uSql = "select * from Shopped where where text like ? order by ShopTime desc";

		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setString(1, text);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();// 返回结果集

			while (rSet.next()) {
				ShoppedBean = new ShoppedBean();

				ShoppedBean.setID(rSet.getInt("ID"));
				ShoppedBean.setpID(rSet.getInt("pID"));
				ShoppedBean.setNumber(rSet.getInt("Number"));
				ShoppedBean.setShopTime(rSet.getString("ShopTime"));

				ShoppedList.add(ShoppedBean);
			}
			return ShoppedList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void ShoppedUpdate(int sid, ShoppedBean Shopped) {
		// TODO Auto-generated method stub
		String uSql = "update Shopped set ID=?,pID=?,Number=?,ShopTime=? where sid=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);

			pStatement.setInt(1, Shopped.getID());
			pStatement.setInt(2, Shopped.getpID());
			pStatement.setInt(3, Shopped.getNumber());
			pStatement.setString(4, Shopped.getShopTime());
			pStatement.setInt(5, sid);

			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void ShoppedDel(int sid) {
		// TODO Auto-generated method stub
		String uSql = "delete from Shopped where sid=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, sid);
			pStatement.execute();// 不返回结果集
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void ShoppedInsert(ShoppedBean Shopped) {
		// TODO Auto-generated method stub
		String uSql = "insert into Shopped() values(?,?,?,?,?)";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			
			pStatement.setInt(1, Shopped.getID());
			pStatement.setInt(2, Shopped.getpID());
			pStatement.setInt(3, Shopped.getsID());
			pStatement.setInt(4, Shopped.getNumber());
			pStatement.setString(5, Shopped.getShopTime());
			
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getShoppedCount(int ID) {
		// TODO Auto-generated method stub
		
		String uSql = "select count(*) as count from Shopped where ID=?";
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
