package px_changehands.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import px_changehands.Service.ToolService;
import px_changehands.dao.NewsDao;
import px_changehands.entity.News;

public class NewsDaoImpl implements NewsDao {
	private Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname="root";
	private String dbupwd="189219";
	public NewsDaoImpl() {
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
	public ArrayList<News> NewsList() {
		// TODO Auto-generated method stub
		String NewsListsql = "select * from GuestBook";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(NewsListsql);
			ResultSet rSet=pStatement.executeQuery();
			ArrayList<News>newslist = new ArrayList<News>();
			ToolService toolService = new ToolService();
			while (rSet.next()) {
				News news = new News(rSet.getInt("setID"),
						rSet.getInt("gID"),
						rSet.getInt("pID"),
						rSet.getString("Message"),
						toolService.getsqltime(rSet.getString("ReleaseTime")),
						toolService.getsqltime(rSet.getString("ModifyTime")));
				newslist.add(news);
			}
			return newslist;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void NewsDelete(int id) {
		// TODO Auto-generated method stub
		String NewsDeletesql = "delete from GuestBook where setid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(NewsDeletesql);
			pStatement.setInt(1, id);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<News> NewsQuery(int pid) {
		// TODO Auto-generated method stub
		String NewsQuerysql = "select * from GuestBook where pID like '%"+pid+"%'";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(NewsQuerysql);
			ResultSet rSet=pStatement.executeQuery();
			ArrayList<News>newsquerylist = new ArrayList<News>();
			ToolService toolService = new ToolService();
			while (rSet.next()) {
				News news = new News(rSet.getInt("setID"),
						rSet.getInt("gID"),
						rSet.getInt("pID"),
						rSet.getString("Message"),
						toolService.getsqltime(rSet.getString("ReleaseTime")),
						toolService.getsqltime(rSet.getString("ModifyTime")));
				newsquerylist.add(news);
			}
			return newsquerylist;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String NewsNumber() {
		// TODO Auto-generated method stub
		String NewsNumbersql = "select count(*)as count from GuestBook";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(NewsNumbersql);
			ResultSet rSet=pStatement.executeQuery();
			rSet.next();
			return rSet.getString("count");
		} catch (SQLException  e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String NewsQueryNumber(int pid) {
		// TODO Auto-generated method stub
		String NewsQueryNumbersql = "select count(*)as count from GuestBook where pID=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(NewsQueryNumbersql);
			pStatement.setInt(1, pid);
			ResultSet rSet=pStatement.executeQuery();
			rSet.next();
			return rSet.getString("count");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void NewsDeleteOne(int gid) {
		// TODO Auto-generated method stub
		String NewsDeleteOnesql = "delete from GuestBook where gid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(NewsDeleteOnesql);
			pStatement.setInt(1, gid);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
/*
 * CREATE TABLE GuestBook(
	setID INT NOT NULL,
	getID INT NOT NULL,
	gID INT NOT NULL,
	pID INT NOT NULL,
	Message text NOT NULL,
	ReleaseTime Datetime NOT NULL,
	ModifyTime Datetime,
	PRIMARY KEY(gID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE GuestBook
ADD FOREIGN KEY(setID) REFERENCES User(ID) ON DELETE CASCADE,
ADD FOREIGN KEY(getID) REFERENCES User(ID) ON DELETE CASCADE;

INSERT INTO GuestBook() VALUES(1,1,1,1,'练习时长两年半','2019-06-15 14:11:32','2019-06-23 14:11:32');
INSERT INTO GuestBook() VALUES(1,1,6,1,'练习时长两年半','2019-06-15 14:11:32','2019-06-23 14:11:32');

*	DROP PROCEDURE test;
	
	delimiter $$
	create procedure test()
	begin
	declare i int;
	        set i = 0;
	while i <= 100 do
	            INSERT INTO GuestBook() VALUES(i,i,i,i,'练习时长两年半','2019-06-15 14:11:32','2019-06-23 14:11:32');
	            set i = i + 1;
	        end while;
	end
	$$
	delimiter ;
	call test();
	*/
