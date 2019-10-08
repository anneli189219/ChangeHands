package changehands.dao;

import java.sql.SQLException;

import javax.websocket.Decoder.Text;

import changehands.entity.UserBean;

/**
 * 该接口为操作User表的Dao层
 * 
 * @author 17软工莫培文
 *
 */
public interface UserDao {
	// 常量属性
	// 抽象方法

	/**
	 * 检查用户名是否重复
	 * @param UserName1
	 *            用户的用户名
	 * @param UserName2
	 *            修改的用户名
	 * @return 用户名重复返回true 不重复返回false
	 */
	public boolean UserNameCheck(String UserName1,String UserName2);

	/**
	 * 用户注册将User对象写入到数据库表User中
	 * 
	 * @param User
	 *            注册对象
	 */
	public void UserInsert(UserBean User);

	/**
	 * 查询个人的信息
	 * 
	 * @param id
	 *            当前用户的id
	 * @return 返回个人信息 如果未查询到 则返回null
	 */
	public UserBean UserSelect(int id);

	/**
	 * 用户登录功能的实现
	 * 
	 * @param UserName
	 *            帐号
	 * @param Password
	 *            密码
	 * @return 登录是否成功 true表示登录成功 false表示登录失败
	 */
	public boolean UserLogin(String UserName, String Password);

	/**
	 * 获得登录用户的ID
	 * 
	 * @param UserName
	 *            帐号
	 * @return 返回当前用户ID
	 */
	public int getUserID(String UserName);

	/**
	 * 修改个人信息
	 * 
	 * @param id
	 *            当前用户的id
	 * @param User
	 *            当前用户修改后的新信息
	 */
	public void UserUpdate(int id, UserBean User);

	/**
	 * 删除用户
	 * 
	 * @param id
	 *            删除用户的id
	 */
	public void UserDel(int id);
	
	/**
	 * 得到查询id的用户名
	 * @param id 查询用户的id
	 * @return 返回用户名
	 */
	public String getUserName(int id);

	/**
	 * 得到查询id的用户名 静态方法
	 * @param id 查询用户的id
	 * @return 返回用户名
	 */
	public static String getUserName_(int id) {
		return null;
	}
	
	/**
	 * 得到查询用户id的头像路径 静态方法
	 * @param id 查询用户的id
	 * @return 返回查询用户头像路径
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static String getUserPath(int id){
		return null;
	}
	
	/**
	 * 查询注册的用户名是否重复
	 * @param username 用户名
	 * @return true重复 false不重复
	 */
	public static boolean getUserNameFlag(String username){
		return false;
	}
	
	/**
	 * 找回密码 确定邮箱和用户名是否一致
	 * @param username 用户名
	 * @param email 邮箱
	 * @return 一致返回true 不一致返回false
	 */
	public boolean getUserPasswordFlag(String username, String email);
}
