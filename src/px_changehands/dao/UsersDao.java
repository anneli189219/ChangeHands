package px_changehands.dao;

import java.util.ArrayList;

import px_changehands.entity.Users;

public interface UsersDao {
		/**
		 * 添加用户方法
		 * @param Users 被添加的用户实体
		 */
		public void UsersAdd(Users users);
		/**
		 * 删除当前id用户下id的值
		 * @param id 被删除的联系人的id
		 */
		public void UsersDelete(int id);
		/**
		 * 查询当前用户的所有的用户
		 * @return 当前用户的所有的联系人信息
		 */
		public ArrayList<Users> UsersSelect();
		/**
		 * 模糊查询当前用户的所有的用户
		 * @param usersname 当前用户的关键字
		 * @return 当前用户的所有的用户信息
		 */
		public ArrayList<Users> UsersSelectlike(String usersname);
		/**
		 * 查询当前用户下的指定id的用户信息
		 * @param id 当前用户关乎的联系人id
		 * @return 当前用户关乎的用户详细信息
		 */
		public Users UsersSelectOne(int id);
		/**
		 * 修改信息
		 * @param oldpassword 用户ID
		 */
		public void UsersUpdata(int id, Users users);
		/**
		 * 修改密码
		 * @param oldpassword 用户ID
		 */
		public void UsersUpdatapassword(int id, String Password);
		/**
		 * 查询用户总数
		 */
		public String UsersNumber();
		/**
		 * 查询检索后用户总数
		 */
		public String UsersQueryNumber(String usersname);
		/**
		 * 查询重复id
		 */
		public boolean RepeatQuery(int id);

}
