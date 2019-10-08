package px_changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import px_changehands.Service.ToolService;
import px_changehands.dao.GoodsDao;
import px_changehands.entity.Product;

public class GoodsDaoImpl implements GoodsDao {
	ToolService toolService = new ToolService();
	private Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname="root";
	private String dbupwd="189219";
	public GoodsDaoImpl() {
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

	@Override//查询全部商品
	public ArrayList<Product> GoodsSelect() {
		// TODO Auto-generated method stub
		String GoodsSelectsql = "select * from Product";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsSelectsql);
			ResultSet rSet=pStatement.executeQuery();
			ArrayList<Product>goodsarrayList = new ArrayList<Product>();
			ToolService toolService = new ToolService();
			while (rSet.next()) {
				Product product = new Product(rSet.getInt("ID"),
						rSet.getInt("pID"),
						rSet.getInt("fID"),
						rSet.getString("TradeName"),
						rSet.getString("ShowPath"),
						rSet.getString("Describes"),
						rSet.getBigDecimal("Price"),
						rSet.getInt("Number"),
						toolService.getsqltime(rSet.getString("AddTime")));
				product.setFlag(rSet.getBoolean("Flag"));
				product.setFidname(toolService.GoodsTransform(rSet.getInt("fID")));
				goodsarrayList.add(product);
			}
			return goodsarrayList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override//查询单个商品
	public Product GoodsSelectOne(int pid) {
		// TODO Auto-generated method stub
		String GoodsSelectOnesql = "select * from Product where pID=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsSelectOnesql);
			pStatement.setInt(1, pid);
			ResultSet rSet=pStatement.executeQuery();
			ToolService toolService = new ToolService();
			if (rSet.next()) {
				Product product = new Product(rSet.getInt("ID"),
						rSet.getInt("pID"),
						rSet.getInt("fID"),
						rSet.getString("TradeName"),
						rSet.getString("ShowPath"),
						rSet.getString("Describes"),
						rSet.getBigDecimal("Price"),
						rSet.getInt("Number"),
						toolService.getsqltime(rSet.getString("AddTime")));
				return product;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override//删除商品
	public void GoodsDeleteOne(int pid) {
		// TODO Auto-generated method stub
		String GoodsDeletesql = "delete from Product where pid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsDeletesql);
			pStatement.setInt(1, pid);
			pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override//修改商品
	public void GoodsUpdate(int pid, Product product) {
		// TODO Auto-generated method stub
		String GoodsUpdatesql = "update Product set TradeName=?,Describes=?,Price=?,Number=?,fID=? where pid=?";
		//String GoodsUpdatesql="delete from Product where pid=?";
		
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsUpdatesql);
			pStatement.setString(1, product.getTradename());
			pStatement.setString(2, product.getDescribes());
			pStatement.setBigDecimal(3, product.getPrice());
			pStatement.setInt(4, product.getNumber());
			pStatement.setInt(5, product.getFid());
			pStatement.setInt(6, pid);
			
			pStatement.execute();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


	@Override//搜索商品
	public ArrayList<Product> GoodsSelectlike(String tradename) {
		// TODO Auto-generated method stub
		String GoodsSelectlikesql = "select * from Product where tradename like '%"+tradename+"%'";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsSelectlikesql);
			ResultSet rSet=pStatement.executeQuery();
			ArrayList<Product>goodslikearrayList = new ArrayList<Product>();
			ToolService toolService = new ToolService();
			while (rSet.next()) {
				Product product = new Product(rSet.getInt("ID"),
						rSet.getInt("pID"),
						rSet.getInt("fID"),
						rSet.getString("TradeName"),
						rSet.getString("ShowPath"),
						rSet.getString("Describes"),
						rSet.getBigDecimal("Price"),
						rSet.getInt("Number"),
						toolService.getsqltime(rSet.getString("AddTime")));
				product.setFidname(toolService.GoodsTransform(rSet.getInt("fID")));
				goodslikearrayList.add(product);
			}
			return goodslikearrayList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override//查询全部商品数量
	public String GoodsNumber() {
		// TODO Auto-generated method stub
		String GoodsNumbersql = "select count(*)as count from Product";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsNumbersql);
			ResultSet rSet=pStatement.executeQuery();
			rSet.next();
			return rSet.getString("count");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override//审核商品
	public void CheckGoods(int pid) {
		// TODO Auto-generated method stub
		String CheckGoodssql = "update Product set Flag=? where pid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(CheckGoodssql);
			pStatement.setBoolean(1, true);
			pStatement.setInt(2, pid);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override//删除用户全部商品
	public void GoodsDelete(int id) {
		// TODO Auto-generated method stub
		String GoodsDeletesql = "delete from Product where pid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsDeletesql);
			pStatement.setInt(1, id);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override//查询未审核商品
	public ArrayList<Product> Goodsok() {
		// TODO Auto-generated method stub
		String Goodsoksql = "select * from Product where Flag=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(Goodsoksql);
			pStatement.setBoolean(1, false);
			ResultSet rSet=pStatement.executeQuery();
			ArrayList<Product> arrayList = new ArrayList<Product>();
			while (rSet.next()) {
				Product product = new Product(rSet.getInt("ID"),
						rSet.getInt("pID"),
						rSet.getInt("fID"),
						rSet.getString("TradeName"),
						rSet.getString("ShowPath"),
						rSet.getString("Describes"),
						rSet.getBigDecimal("Price"),
						rSet.getInt("Number"),
						toolService.getsqltime(rSet.getString("AddTime")));
				product.setFidname(toolService.GoodsTransform(rSet.getInt("fID")));
				arrayList.add(product);
			}
			return arrayList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override//查询未审核数量
	public String GoodsokNumber() {
		// TODO Auto-generated method stub
		String GoodsokNumbersql = "select count(*)as count from Product where Flag=false";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsokNumbersql);
			ResultSet rSet=pStatement.executeQuery();
			rSet.next();
			return rSet.getString("count");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override//检索商品数量
	public String GoodsQueryNumber(String tradename) {
		// TODO Auto-generated method stub
		String GoodsQueryNumbersql = "select count(*)as count from Product  where tradename like '%"+tradename+"%'";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsQueryNumbersql);
			ResultSet rSet=pStatement.executeQuery();
			rSet.next();
			return rSet.getString("count");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "1";
	}

	@Override//下架商品
	public void LowerShelf(int pid) {
		// TODO Auto-generated method stub
		String LowerShelfsql = "update Product set Flag=? where pid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(LowerShelfsql);
			pStatement.setBoolean(1, false);
			pStatement.setInt(2, pid);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override//查询分类
	public ArrayList<Product> GoodsClass(int fid) {
		// TODO Auto-generated method stub
		String GoodsClasssql = "select * from Product where fid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsClasssql);
			pStatement.setInt(1, fid);
			ResultSet rSet=pStatement.executeQuery();
			ArrayList<Product> arrayList = new ArrayList<Product>();
			while (rSet.next()) {
				Product product = new Product(rSet.getInt("ID"),
						rSet.getInt("pID"),
						rSet.getInt("fID"),
						rSet.getString("TradeName"),
						rSet.getString("ShowPath"),
						rSet.getString("Describes"),
						rSet.getBigDecimal("Price"),
						rSet.getInt("Number"),
						toolService.getsqltime(rSet.getString("AddTime")));
				product.setFidname(toolService.GoodsTransform(rSet.getInt("fID")));
				arrayList.add(product);
			}
			return arrayList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override//查询分类数量
	public String GoodsClassNumber(int fid) {
		// TODO Auto-generated method stub
		String GoodsClassNumbersql = "select count(*)as count from Product  where fid like '%"+fid+"%'";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(GoodsClassNumbersql);
			ResultSet rSet=pStatement.executeQuery();
			rSet.next();
			return rSet.getString("count");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
/*
 * CREATE TABLE Product(
	ID INT NOT NULL,
	pID INT NOT NULL PRIMARY KEY,
	Flag bool NOT NULL,
	TradeName varchar(20) NOT NULL,
	Describes varchar(255) NOT NULL,
	Price decimal(10,2) NOT NULL,
	Number INT NOT NULL,
	ShowPath varchar(50),
	fID INT NOT NULL,
	AddTime Datetime NOT NULL
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	ALTER TABLE Product
	ADD FOREIGN KEY(ID)
	REFERENCES User(ID) ON DELETE CASCADE;
	
	
	DROP PROCEDURE test;
	
	delimiter $$
	create procedure test()
	begin
	declare i int;
	        set i = 0;
	while i <= 100 do
	            INSERT INTO Product() VALUES(i,i,false,'篮球','练习时长两年半',233.3,'100','null',1,'2019-06-15 14:11:32');
	            set i = i + 1;
	        end while;
	end
	$$
	delimiter ;
	call test();
*/
