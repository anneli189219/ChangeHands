package changehands.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import changehands.entity.ShoppedBean;

public interface ShoppedDao {
	
	/**
	 * 级联查询 返回销售记录的List结果集
	 * @param sid 销售记录id
	 * @return 返回销售记录的List结果集
	 */
	public List<Map<String, Object>> getSaleSelect(int sid);
	
	/**
	 * 级联查询 返回销售记录的List结果集
	 * @param id 用户id
	 * @return 返回销售记录的List结果集
	 */
	public List<Map<String, Object>> getSaleSet(int id);
	
	/**
	 * 级联查询 返回销售记录的List结果集
	 * @param id 用户id
	 * @param text 查询内容
	 * @return 返回销售记录的List结果集
	 */
	public List<Map<String, Object>> getSaleSet(int id,String text);
	
	/**
	 * 级联查询 返回两个表的List结果集
	 * @param id 用户id
	 * @return 返回两个表的List结果集
	 */
	public List<Map<String, Object>> getShoppedSet_(int id);
	
	/**
	 * 级联查询 返回两个表的List结果集
	 * @param id 用户id
	 * @param text 查询内容
	 * @return 返回两个表的List结果集
	 */
	public List<Map<String, Object>> getShoppedSet_(int id,String text);
	
	/**
	 * 获得指定用户id的已购买商品集合
	 * @param id 用户id
	 * @return 用户已购买商品集合
	 */
	public ArrayList<ShoppedBean> getShoppedSet(int id);

	/**
	 * 获得指定查询内容的已购买商品集合
	 * @param text 查询内容
	 * @return 已购买商品集合
	 */
	public ArrayList<ShoppedBean> getShoppedSet(String text);

	/**
	 * 修改指定销售商品id的信息
	 * @param sid 销售商品id
	 * @param Shopped 修改内容
	 */
	public void ShoppedUpdate(int sid, ShoppedBean Shopped);

	/**
	 * 删除指定销售商品id的信息
	 * @param sid 销售商品id
	 */
	public void ShoppedDel(int sid);

	/**
	 * 插入新的已购商品 id是随机的6位
	 * @param Shopped 插入内容
	 */
	public void ShoppedInsert(ShoppedBean Shopped);
	
	/**
	 * 获得用户已购买的商品数量
	 * @param ID 用户ID
	 * @return 已购买的商品数量
	 */
	public int getShoppedCount(int ID);
}
