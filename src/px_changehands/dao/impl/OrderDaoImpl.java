package px_changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import px_changehands.Service.ToolService;
import px_changehands.dao.OrderDao;
import px_changehands.entity.Order;

public class OrderDaoImpl implements OrderDao {
	private Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname="root";
	private String dbupwd="189219";
	public OrderDaoImpl() {
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
	public boolean OrderDelete(int oid) {
		// TODO Auto-generated method stub
		String OrderDeletesql = "delete from Shopped where sID=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(OrderDeletesql);
			pStatement.setInt(1, oid);
			return pStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public ArrayList<Order> OrderMap() {
		// TODO Auto-generated method stub
		String OrderMapsql = "select Shopped.sID,Shopped.ID,Shopped.pID,Product.ID,Product.TradeName,Product.Describes,Product.Price,Shopped.Number,Shopped.ShopTime from Product inner JOIN Shopped ON(Product.pid = Shopped.pid)";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(OrderMapsql);
			ResultSet rSet=pStatement.executeQuery();
			ToolService toolService = new ToolService();
			ArrayList<Order> arrayList = new ArrayList<Order>();
			while (rSet.next()) {
				Order order = new Order(rSet.getInt("Shopped.ID"),
						rSet.getInt("Product.ID"),
						rSet.getInt("Shopped.pID"),
						rSet.getInt("Shopped.sID"),
						rSet.getString("Product.TradeName"),
						rSet.getString("Product.Describes"),
						rSet.getInt("Shopped.Number"),
						toolService.OrderPrice(rSet.getInt("Shopped.Number"), rSet.getBigDecimal("Product.Price")),
						rSet.getString("Shopped.ShopTime"));
				arrayList.add(order);
			}
			return arrayList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String ordernumber() {
		// TODO Auto-generated method stub
		String ordernumbersql = "select count(*)as count from Shopped";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(ordernumbersql);
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
 * CREATE TABLE Shopped(
	ID int not null,
	pID int not null,
	sID int not null PRIMARY KEY,
	Number int not null,
	ShopTime DATETIME not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE Shopped
ADD FOREIGN KEY(ID) REFERENCES User(ID) ON DELETE CASCADE,
ADD FOREIGN KEY(pID) REFERENCES Product(pID) ON DELETE CASCADE;


INSERT INTO Shopped() VALUES(12,2,2,'2019-06-15 14:11:32');

DROP PROCEDURE test;

delimiter $$
create procedure test()
begin
declare i int;
        set i = 10;
while i <= 20 do
            INSERT INTO Shopped() VALUES(i,i,3,'2019-06-15 14:11:32');
            set i = i + 1;
        end while;
end
$$
delimiter ;
call test();
*/
