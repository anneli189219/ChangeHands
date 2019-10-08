package changehands.dao;

import java.util.List;
import java.util.Map;

import changehands.entity.ShoppingBean;

public interface ShoppingDao {
	/**
	 * 添加到购物车
	 * @param shoppingBean 购物车bean
	 */
	public void ShoppingInsert(ShoppingBean shoppingBean);
	
	/**
	 * 查询用户id的购物车商品
	 * @param id 用户的id
	 * @return 查询到的购物车商品集合
	 */
	public List<Map<String,Object>> ShoppingSelect(int id);
	
	/**
	 * 删除指定商品pid的购物车内容
	 * @param pid 商品pid
	 * @param id 用户的id
	 */
	public void ShoppingDel(int pid,int id);
	
	/**
	 * 查询指定商品pID的ShoppingBean
	 * @param pID 商品pID
	 * @param ID 用户的ID
	 * @return ShoppingBean
	 */
	public ShoppingBean getShoppingBean(int pID,int ID);
	
	/**
	 * 更新指定商品pID的ShoppingBean
	 * @param number 商品数量
	 * @param pID 商品pID
	 * @param ID 用户的ID
	 */
	public void ShoppingUpdate(int number,int pID, int ID);
	
	/**
	 * 获得购物车商品的数量
	 * @param ID 用户ID
	 * @return 返回商品数
	 */
	public int getShoppingCount(int ID);
}
