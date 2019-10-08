package changehands.dao.impl;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import changehands.dao.GuestDao;
import changehands.entity.GuestBookBean;
import changehands.tool.Tool;

public class GuestDaoImpl implements GuestDao {
	Tool tool = new Tool();
	// 数据库连接
	private Connection connection;
	private String dburl = "jdbc:mysql://localhost:3306/ChangeHands";
	private String dbuname = "root";
	private String dbupwd = "189219";

	public GuestDaoImpl() {
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
	public ArrayList<GuestBookBean> getGuestSet(int id) {
		// TODO Auto-generated method stub
		ArrayList<GuestBookBean> GuestBookList = new ArrayList<GuestBookBean>();
		GuestBookBean guestBookBean = null;

		String uSql = "select * from GuestBook where setID=? or getID=? order by ModifyTime desc";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, id);
			pStatement.setInt(2, id);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();// 返回结果集

			while (rSet.next()) {
				guestBookBean = new GuestBookBean();// 必须重新new一个对象,不然会指向同一地址

				guestBookBean.setsetID(rSet.getInt("setID"));
				guestBookBean.setgetID(rSet.getInt("getID"));
				guestBookBean.setpID(rSet.getInt("pID"));
				guestBookBean.setgID(rSet.getInt("gID"));
				guestBookBean.setMessage(rSet.getString("Message"));
				guestBookBean.setReleaseTime(rSet.getString("ReleaseTime"));
				guestBookBean.setModifyTime(rSet.getString("ModifyTime"));

				GuestBookList.add(guestBookBean);// 添加到动态数组
			}
			return GuestBookList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<GuestBookBean> getGuestSet(int id, String text) {
		// TODO Auto-generated method stub
		ArrayList<GuestBookBean> GuestBookList = new ArrayList<GuestBookBean>();
		GuestBookBean guestBookBean = new GuestBookBean();

		String uSql = "select * from GuestBook where (setID=? or getID=?) and Message like ? order by ModifyTime desc";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, id);
			pStatement.setInt(2, id);
			pStatement.setString(3, "%" + text + "%");
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();// 返回结果集

			while (rSet.next()) {
				guestBookBean = new GuestBookBean();
				guestBookBean.setsetID(rSet.getInt("setID"));
				guestBookBean.setgetID(rSet.getInt("getID"));
				guestBookBean.setpID(rSet.getInt("pID"));
				guestBookBean.setgID(rSet.getInt("gID"));
				guestBookBean.setMessage(rSet.getString("Message"));
				guestBookBean.setReleaseTime(rSet.getString("ReleaseTime"));
				guestBookBean.setModifyTime(rSet.getString("ModifyTime"));

				GuestBookList.add(guestBookBean);
			}
			return GuestBookList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<GuestBookBean> getGuestSet(int id, int pid) {
		// TODO Auto-generated method stub
		ArrayList<GuestBookBean> GuestBookList = new ArrayList<GuestBookBean>();
		GuestBookBean guestBookBean = new GuestBookBean();

		String uSql = "select * from GuestBook where (setID=? or getID=?) and pid=? order by ModifyTime desc";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, id);
			pStatement.setInt(2, id);
			pStatement.setInt(3, pid);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();// 返回结果集

			while (rSet.next()) {
				guestBookBean = new GuestBookBean();
				guestBookBean.setsetID(rSet.getInt("setID"));
				guestBookBean.setgetID(rSet.getInt("getID"));
				guestBookBean.setpID(rSet.getInt("pID"));
				guestBookBean.setgID(rSet.getInt("gID"));
				guestBookBean.setMessage(rSet.getString("Message"));
				guestBookBean.setReleaseTime(rSet.getString("ReleaseTime"));
				guestBookBean.setModifyTime(rSet.getString("ModifyTime"));

				GuestBookList.add(guestBookBean);
			}
			return GuestBookList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public void GuestUpdate(int id, GuestBookBean GuestBook) {
		// TODO Auto-generated method stub
		String uSql = "update GuestBook set Message=?,ModifyTime=? where gID=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);

			pStatement.setString(1, GuestBook.getMessage());
			pStatement.setString(2, tool.getNowTime());
			pStatement.setInt(3, id);

			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void GuestDel(int id) {
		// TODO Auto-generated method stub
		String uSql = "delete from GuestBook where gID=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, id);
			pStatement.execute();// 不返回结果集
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void GuestInsert(GuestBookBean GuestBook) {
		// TODO Auto-generated method stub
		String uSql = "insert into GuestBook() values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);

			pStatement.setInt(1, GuestBook.getsetID());
			pStatement.setInt(2, GuestBook.getgetID());
			pStatement.setInt(3, GuestBook.getpID());
			pStatement.setInt(4, tool.getRandom(6));//gID
			pStatement.setString(5, GuestBook.getMessage());
			pStatement.setString(6, GuestBook.getReleaseTime());
			pStatement.setString(7, GuestBook.getModifyTime());

			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public GuestBookBean GuestGetValue(int gID) {

		GuestBookBean guestBookBean = new GuestBookBean();

		String uSql = "select * from GuestBook where gID=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(uSql);
			pStatement.setInt(1, gID);
			pStatement.execute();
			ResultSet rSet = pStatement.executeQuery();// 返回结果集

			while (rSet.next()) {
				guestBookBean = new GuestBookBean();
				guestBookBean.setsetID(rSet.getInt("setID"));
				guestBookBean.setgetID(rSet.getInt("getID"));
				guestBookBean.setpID(rSet.getInt("pID"));
				guestBookBean.setgID(rSet.getInt("gID"));
				guestBookBean.setMessage(rSet.getString("Message"));
				guestBookBean.setReleaseTime(rSet.getString("ReleaseTime"));
				guestBookBean.setModifyTime(rSet.getString("ModifyTime"));
			}
			return guestBookBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}
