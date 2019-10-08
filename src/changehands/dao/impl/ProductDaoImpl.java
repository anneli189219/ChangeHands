package changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import changehands.dao.ProductDao;
import changehands.entity.ProductBean;
import changehands.tool.Tool;

public class ProductDaoImpl implements ProductDao {
	Tool tool = new Tool();
	//数据库连接
	private Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname="root";
	private String dbupwd="189219";
	public ProductDaoImpl() {
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
	public ArrayList<ProductBean> getProductSet(int id) {
		// TODO Auto-generated method stub
		ArrayList<ProductBean> ProductList = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		
		String uSql="select * from Product where ID=? order by AddTime desc";
		
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(uSql);
			pStatement.setInt(1,id);
			pStatement.execute();
			ResultSet rSet=pStatement.executeQuery();//返回结果集
			
			while (rSet.next()) {
				productBean = new ProductBean();
				
				productBean.setID(rSet.getInt("ID"));
				productBean.setpID(rSet.getInt("pID"));
				productBean.setFlag(rSet.getBoolean("Flag"));
				productBean.setTradeName(rSet.getString("TradeName"));
				productBean.setDescribes(rSet.getString("Describes"));
				productBean.setPrice(rSet.getBigDecimal("Price"));
				productBean.setNumber(rSet.getInt("Number"));
				productBean.setShowPath(rSet.getString("ShowPath"));
				productBean.setfID(rSet.getInt("fID"));
				productBean.setAddTime(rSet.getString("AddTime"));
				
				ProductList.add(productBean);
			}
			return ProductList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<ProductBean> getProductSet(int id,String text) {
		// TODO Auto-generated method stub
		ArrayList<ProductBean> ProductList = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		
		String uSql="select * from Product where ID=? and Describes like ? order by AddTime desc";
		
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(uSql);
			pStatement.setInt(1,id);
			pStatement.setString(2,"%" + text + "%");
			pStatement.execute();
			ResultSet rSet=pStatement.executeQuery();//返回结果集
			
			while (rSet.next()) {
				productBean = new ProductBean();
				
				productBean.setID(rSet.getInt("ID"));
				productBean.setpID(rSet.getInt("pID"));
				productBean.setFlag(rSet.getBoolean("Flag"));
				productBean.setTradeName(rSet.getString("TradeName"));
				productBean.setDescribes(rSet.getString("Describes"));
				productBean.setPrice(rSet.getBigDecimal("Price"));
				productBean.setNumber(rSet.getInt("Number"));
				productBean.setShowPath(rSet.getString("ShowPath"));
				productBean.setfID(rSet.getInt("fID"));
				productBean.setAddTime(rSet.getString("AddTime"));
				
				ProductList.add(productBean);
			}
			return ProductList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ProductBean getProductSelect(int pid){
		String uSql="select * from Product where pID=?";
		ProductBean productBean = new ProductBean();
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(uSql);
			pStatement.setInt(1,pid);
			pStatement.execute();
			ResultSet rSet=pStatement.executeQuery();//返回结果集
			
			while (rSet.next()) {
				productBean.setID(rSet.getInt("ID"));
				productBean.setpID(rSet.getInt("pID"));
				productBean.setFlag(rSet.getBoolean("Flag"));
				productBean.setTradeName(rSet.getString("TradeName"));
				productBean.setDescribes(rSet.getString("Describes"));
				productBean.setPrice(rSet.getBigDecimal("Price"));
				productBean.setNumber(rSet.getInt("Number"));
				productBean.setShowPath(rSet.getString("ShowPath"));
				productBean.setfID(rSet.getInt("fID"));
				productBean.setAddTime(rSet.getString("AddTime"));
			}
			return productBean;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public void ProductUpdate(int id, ProductBean Product) {
		// TODO Auto-generated method stub
		String uSql="update Product set Flag=?,TradeName=?,Describes=?,Price=?,Number=?,ShowPath=?,fID=? where pid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(uSql);
			
			pStatement.setBoolean(1, Product.getFlag());
			pStatement.setString(2, Product.getTradeName());
			pStatement.setString(3, Product.getDescribes());
			pStatement.setBigDecimal(4, Product.getPrice());
			pStatement.setInt(5, Product.getNumber());
			pStatement.setString(6, Product.getShowPath());
			pStatement.setInt(7, Product.getfID());
			pStatement.setInt(8, id);
			
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public void ProductDel(int id) {
		// TODO Auto-generated method stub
		String uSql="delete from Product where pid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(uSql);
			pStatement.setInt(1,id);
			pStatement.execute();//不返回结果集	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void ProductInsert(ProductBean Product) {
		// TODO Auto-generated method stub
		String uSql="insert into Product() values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(uSql);
			
			pStatement.setInt(1,Product.getID());
			pStatement.setInt(2,tool.getRandom(6));
			pStatement.setBoolean(3,Product.getFlag());
			pStatement.setString(4,Product.getTradeName());
			pStatement.setString(5,Product.getDescribes());
			pStatement.setBigDecimal(6,Product.getPrice());
			pStatement.setInt(7,Product.getNumber());
			pStatement.setString(8,Product.getShowPath());
			pStatement.setInt(9,Product.getfID());
			pStatement.setString(10,tool.getNowTime());
			
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public HashMap<String, Object> ProductSelect(int currentpage, int numberpage, String selectname, int fID) {
		// TODO Auto-generated method stub
		// 本方法获取currentpage页面里的最多numberpage个数据
		int begin = (currentpage - 1) * numberpage;
		int size = numberpage;
		System.out.println("每页显示条数:" + numberpage + "/当前页数:" + currentpage);
		System.out.println("开始:" + begin + "/大小:" + size);
		// Select * from users limit begin,size;
		// 获取最大记录数
		int totals = 0;
		List<ProductBean> productBeans = new ArrayList<ProductBean>(size);
		String sql1 = "select count(*) as totals from product where (tradename like ? or describes like ?) and flag=true order by AddTime desc";
		String sql2 = "select * from product where (tradename like ? or describes like ?) and flag=true order by AddTime desc limit ?,?";
		
		if (fID!=-1) {
			sql1 = "select count(*) as totals from product where (tradename like ? or describes like ?) and fID=? and flag=true order by AddTime desc";
			sql2 = "select * from product where (tradename like ? or describes like ?) and fID=? and flag=true order by AddTime desc limit ?,?";
		}
		
		try {
			PreparedStatement pStatement1 = this.connection.prepareStatement(sql1);
			pStatement1.setString(1, "%" + selectname + "%");
			pStatement1.setString(2, "%" + selectname + "%");
			if (fID!=-1) {
				pStatement1.setInt(3, fID);
			}
			pStatement1.execute();
			ResultSet countset = pStatement1.executeQuery();
			while (countset.next()) {
				totals = countset.getInt("totals");
				System.out.println(totals);
			}
			PreparedStatement pStatement2 = this.connection.prepareStatement(sql2);
			if (fID!=-1) {
				pStatement2.setString(1, "%" + selectname + "%");
				pStatement2.setString(2, "%" + selectname + "%");
				pStatement2.setInt(3, fID);
				pStatement2.setInt(4, begin);
				pStatement2.setInt(5, size);
			}else {
				pStatement2.setString(1, "%" + selectname + "%");
				pStatement2.setString(2, "%" + selectname + "%");
				pStatement2.setInt(3, begin);
				pStatement2.setInt(4, size);
			}
			
			pStatement2.execute();
			ResultSet rSet = pStatement2.executeQuery();
			while (rSet.next()) {
				ProductBean productBean = new ProductBean(rSet.getInt("ID"), rSet.getInt("pID"),
						rSet.getBoolean("Flag"), rSet.getString("TradeName"), rSet.getString("Describes"),
						rSet.getBigDecimal("Price"), rSet.getInt("Number"), rSet.getString("ShowPath"),
						rSet.getInt("fID"), rSet.getString("AddTime"));
				productBeans.add(productBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 除了需要返回ArrayList<ProductBean>外还需要返回总记录数
		HashMap<String, Object> returnmap = new HashMap<String, Object>(2);
		returnmap.put("totals", totals);
		returnmap.put("productBeans", productBeans);
		return returnmap;
	}
	
	@Override
	public ProductBean ProductInfo(int pid, int id) {
		String sql = "select * from product where pid=? and id=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(sql);
			pStatement.setInt(1, pid);
			pStatement.setInt(2, id);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				ProductBean productBean = new ProductBean(rSet.getInt("ID"), rSet.getInt("pID"),
						rSet.getBoolean("Flag"), rSet.getString("TradeName"), rSet.getString("Describes"),
						rSet.getBigDecimal("Price"), rSet.getInt("Number"), rSet.getString("ShowPath"),
						rSet.getInt("fID"), rSet.getString("AddTime"));
				return productBean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getProductCount(int ID) {
		// TODO Auto-generated method stub
		String uSql = "select count(*) as count from Product where ID=? and Flag=true";
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
