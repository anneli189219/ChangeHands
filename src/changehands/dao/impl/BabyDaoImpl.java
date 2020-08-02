package changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import changehands.dao.BabyDao;
import changehands.entity.BabyBean;

import changehands.tool.Tool;

public class BabyDaoImpl implements BabyDao {
	Tool tool = new Tool();
	//数据库连接
	private Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname="root";
	private String dbupwd="189219";
	public BabyDaoImpl() {
		// TODO Auto-generated constructor stub
				//数据库操作初始化
				//加载驱动
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection=DriverManager.getConnection(dburl,dbuname,dbupwd);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				//创建连接
	}
	
	@Override
	public BabyBean BabySelect(int bID) {
		// TODO Auto-generated method stub
		String uSql="select * from Baby where bID=?";
		BabyBean babyBean = new BabyBean();//耦合高 代码复用程度低 用spring框架 利用java放射机制 可在这一步解耦合
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(uSql);//可以防sql注入
			pStatement.setInt(1,bID);
			pStatement.execute();
			ResultSet rSet=pStatement.executeQuery();//返回结果集
			
			while (rSet.next()) {
				babyBean = new BabyBean();
				
				babyBean.setID(rSet.getInt("ID"));
				babyBean.setpID(rSet.getInt("pID"));
				babyBean.setbID(rSet.getInt("bID"));
				babyBean.setAddTime(rSet.getString("AddTime"));
			}
			return babyBean;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public void BabyDel(int bID) {
		String uSql="delete from Baby where bID=?";

		try {
			PreparedStatement pStatement=this.connection.prepareStatement(uSql);
			pStatement.setInt(1,bID);
			pStatement.execute();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public void BaByAdd(BabyBean babyBean) {
		// TODO Auto-generated method stub
		String uSql="insert into BaBy() values(?,?,?,?)";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(uSql);
			
			pStatement.setInt(1,babyBean.getID());
			pStatement.setInt(2,babyBean.getpID());
			pStatement.setInt(3,tool.getRandom(6));
			pStatement.setString(4,babyBean.getAddTime());
			
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public HashMap<String, Object> BaBySelectList(int currentpage, int numberpage, int ID) {
		// TODO Auto-generated method stub
		int begin = (currentpage - 1) * numberpage;
		int size = numberpage;
		
		//最大数
		int totals = 0;
		
		String uSql1 = "select count(*) as totals from BaBy where ID=?";
		String uSql2 = "select BaBy.bID,BaBy.pID,Product.TradeName,Product.Describes,Product.Price,Product.ShowPath,BaBy.AddTime from Product inner JOIN BaBy ON(Product.pid = BaBy.pid) where BaBy.ID=? order by AddTime desc limit ?,?";
		
		try {
			PreparedStatement pStatement1 = this.connection.prepareStatement(uSql1);
			
			pStatement1.setInt(1, ID);
			
			pStatement1.execute();
			ResultSet countset = pStatement1.executeQuery();
			while (countset.next()) {
				totals = countset.getInt("totals");
			}
			/////////////////////////////////
			PreparedStatement pStatement2 = this.connection.prepareStatement(uSql2);
			
			pStatement2.setInt(1, ID);
			pStatement2.setInt(2, begin);
			pStatement2.setInt(3, size);
			pStatement2.execute();
			ResultSet rSet = pStatement2.executeQuery();// 返回结果集

			List<Map<String, Object>> BabyList = tool.convertList_(rSet);
			
			HashMap<String, Object> returnmap = new HashMap<String, Object>(2);
				
			returnmap.put("totals", totals);
			returnmap.put("BabyList", BabyList);
				
			return returnmap;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public int BabyCount(int ID) {
		// TODO Auto-generated method stub
		String uSql = "select count(*) as count from BaBy where ID=?";
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
