package px_changehands.Service;

import java.util.ArrayList;

import px_changehands.dao.impl.AdminDaoImpl;
import px_changehands.dao.impl.GoodsDaoImpl;
import px_changehands.dao.impl.NewsDaoImpl;
import px_changehands.dao.impl.OrderDaoImpl;
import px_changehands.dao.impl.UsersDaoImpl;
import px_changehands.entity.Admin;
import px_changehands.entity.AdminSession;
import px_changehands.entity.News;
import px_changehands.entity.Order;
import px_changehands.entity.Product;
import px_changehands.entity.Users;

/**
 * Admin Service层的功能实现
 * @author onest
 *
 */
public class AdminService {
	
	AdminDaoImpl adminDaoImpl;
	UsersDaoImpl usersDaoImpl;
	GoodsDaoImpl goodsDaoImpl;
	NewsDaoImpl newsDaoImpl;
	OrderDaoImpl orderDaoImpl;
	public AdminService(){
		//初始化AdminDaoImpl实例
		adminDaoImpl = new AdminDaoImpl();
		usersDaoImpl = new UsersDaoImpl();
		goodsDaoImpl = new GoodsDaoImpl();
		newsDaoImpl = new NewsDaoImpl();
		orderDaoImpl = new OrderDaoImpl();
	}
	//=====================管理员===============
	/**
	 * 查找信息
	 * @param  adminname当前人员的name
	 * @return
	 */
	public AdminSession SelectAdmin(String adminname){
		return this.adminDaoImpl.GetAdmin(adminname);
	}
	
	/**
	 * 用户登录
	 * @param  adminname当前人员的name
	 * @param  adminpassword当前人员的密码
	 * @return
	 */
	public boolean Loginok(String adminname, String adminpassword){
		return this.adminDaoImpl.AdminLogin(adminname, adminpassword);
	}
	
	/**
	 * 修改信息
	 * @param  ID当前人员的ID
	 * @return
	 */
	public void UpdateAdmin(String oldpassword, Admin admin){
		this.adminDaoImpl.AdminUpdata(oldpassword, admin);
	}

	
	//=====================用户===============
	/**
	 * 添加用户方法
	 * @param Users 被添加的用户实体
	 */
	public void UsersAdd(Users users) {
		this.usersDaoImpl.UsersAdd(users);
	}
	/**
	 * 删除当前id用户下id的值
	 * @param id 被删除的联系人的id
	 */
	public void UsersDelete(int id){
		this.usersDaoImpl.UsersDelete(id);
	}
	/**
	 * 查询当前用户的所有的用户
	 * @return 当前用户的所有的联系人信息
	 */
	public ArrayList<Users> UsersSelectAll(){
		return this.usersDaoImpl.UsersSelect();
	}
	/**
	 * 模糊查询当前的用户
	 * usersname 用户名关键字
	 * @return 当前用户的所有的联系人信息
	 */
	public ArrayList<Users> UsersSelectlike(String usersname){
		return this.usersDaoImpl.UsersSelectlike(usersname);
	} 
	/**
	 * 查询当前用户下的指定id的用户信息
	 * @param id 当前用户关乎的联系人id
	 * @return 当前用户关乎的用户详细信息
	 */
	public Users UsersSelectOne(int id){
		return this.usersDaoImpl.UsersSelectOne(id);
	}
	/**
	 * 修改信息
	 * @param oldpassword 用户ID
	 */
	public void UsersUpdata(int id, Users users){
		this.usersDaoImpl.UsersUpdata(id, users);
	}
	/**
	 * 修改密码
	 * @param oldpassword 用户ID
	 */
	public void UsersUpdatapassword(int id, String Password){
		this.usersDaoImpl.UsersUpdatapassword(id, Password);
	}
	/**
	 * 获取所有用户数量
	 */
	public String getUsersNumber(){
		return usersDaoImpl.UsersNumber();
	}
	/**
	 * 获取所有用户数量
	 */
	public String getUsersQuery(String usersname){
		return usersDaoImpl.UsersQueryNumber(usersname);
	}
	
	//======================商品
	//======================
	/**
	 * 查询全部商品
	 */
	public ArrayList<Product> GoodsSelect() {
		return goodsDaoImpl.GoodsSelect();
	}
	/**
	 * 查询单个商品
	 */
	public Product GoodsSelectOne(int pid) {
		return goodsDaoImpl.GoodsSelectOne(pid);
	}
	/**
	 * 删除商品
	 * @return 
	 */
	public void GoodsDeleteOne(int pid) {
		goodsDaoImpl.GoodsDeleteOne(pid);;
	}
	/**
	 * 修改商品
	 */
	public void GoodsUpdate(int pid, Product product) {
		goodsDaoImpl.GoodsUpdate(pid, product);
	}
	/**
	 * 搜索商品
	 */
	public ArrayList<Product> GoodsSelectlike(String tradename) {
		return goodsDaoImpl.GoodsSelectlike(tradename);
	}
	/**
	 * 查询全部商品数量
	 */
	public String GoodsNumber() {
		return goodsDaoImpl.GoodsNumber();
	}
	/**
	 * 审核商品
	 */
	public void CheckGoods(int pid) {
		goodsDaoImpl.CheckGoods(pid);
	}
	/**
	 * 删除用户全部商品
	 */
	public void GoodsDelete(int id){
		goodsDaoImpl.GoodsDelete(id);
	}
	/**
	 * 查询所有未审核商品
	 */
	public ArrayList<Product> Goodsok(){
		return goodsDaoImpl.Goodsok();
	}
	/**
	 * 查询所有未审核数量
	 */
	public String GoodsokNumber(){
		return goodsDaoImpl.GoodsokNumber();
	}
	/**
	 * 检索商品数量
	 */
	public String GoodsQueryNumber(String tradename) {
		return goodsDaoImpl.GoodsQueryNumber(tradename);
	}
	/**
	 * 下架商品
	 */
	public void LowerShelf(int pid) {
		goodsDaoImpl.LowerShelf(pid);
	}
	
	//=================留言==============
	/**
	 * 查询全部留言
	 */
	public ArrayList<News> NewsList() {
		return newsDaoImpl.NewsList();
	}
	/**
	 * 删除留言
	 */
	public void NewsDelete(int id) {
		newsDaoImpl.NewsDelete(id);
	}
	/**
	 * 检索留言
	 */
	public ArrayList<News> NewsQuery(int pid) {
		return newsDaoImpl.NewsQuery(pid);
	}
	/**
	 * 查询全部留言数
	 */
	public String NewsNumber() {
		return newsDaoImpl.NewsNumber();
	}
	/**
	 * 查询检索留言数
	 */
	public String NewsQueryNumber(int id) {
		return newsDaoImpl.NewsQueryNumber(id);
	}
	/**
	 * 删除单条留言
	 */
	public void NewsDeleteOne(int gid) {
		newsDaoImpl.NewsDeleteOne(gid);
	}
	/**
	 * 查询商品分类
	 */
	public ArrayList<Product> GoodsClass(int fid) {
		return goodsDaoImpl.GoodsClass(fid);
	}
	/**
	 * 查询商品分类数量
	 */
	public String GoodsClassNumber(int fid) {
		return goodsDaoImpl.GoodsClassNumber(fid);
	}
	
	//==========================订单===
	/**
	 * 删除订单
	 * @param id
	 * @param pid
	 * @return
	 */
	public boolean OrderDelete(int oid) {
		return orderDaoImpl.OrderDelete(oid);
	}
	/**
	 * 查询订单
	 * @return
	 */
	public ArrayList<Order> OrderMap() {
		return orderDaoImpl.OrderMap();
	}
	/**
	 * 查询全部订单
	 * @return
	 */
	public String ordernumber() {
		return orderDaoImpl.ordernumber();
	}
}
