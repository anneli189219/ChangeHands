package changehands.dao;

import java.util.ArrayList;
import java.util.HashMap;

import changehands.entity.ProductBean;

public interface ProductDao {
	/**
	 * 获得指定用户id发布的商品集合
	 * 
	 * @param id
	 *            用户id
	 * @return 返回商品集合
	 */
	public ArrayList<ProductBean> getProductSet(int id);

	/**
	 * 获得查询内容的商品集合
	 * @param id
	 *            用户id
	 * @param text
	 *            查询内容
	 * @return 返回商品集合
	 */
	public ArrayList<ProductBean> getProductSet(int id,String text);

	/**
	 * 获得指定商品id的商品内容
	 * @param pid 商品的id
	 * @return 返回商品内容
	 */
	public ProductBean getProductSelect(int pid);
	
	/**
	 * 修改指定id的商品
	 * 
	 * @param id
	 *            商品id
	 * @param Product
	 *            修改内容的对象
	 */
	public void ProductUpdate(int id, ProductBean Product);

	/**
	 * 删除指定id的商品
	 * 
	 * @param id
	 *            商品id
	 */
	public void ProductDel(int id);

	/**
	 * 插入用户发布的商品 id是随机的6位数
	 * 
	 * @param Product 插入的内容
	 */
	public void ProductInsert(ProductBean Product);
	
	/**
	 * 获得商品信息
	 * @param pid 商品ID
	 * @param id 商家ID
	 * @return 返回商品信息bean
	 */
	public ProductBean ProductInfo(int pid, int id);
	
	/**
	 * 查询商品分页
	 * @param currentpage 当前页
	 * @param numberpage 每页的显示个数
	 * @param selectname 查询内容
	 * @param fID 分类ID
	 * @return 返回商品内容集合
	 */
	public HashMap<String, Object> ProductSelect(int currentpage, int numberpage, String selectname,int fID);
	
	/**
	 * 获得用户已发布商品的数量
	 * @param ID 用户ID
	 * @return 已发布商品的数量
	 */
	public int getProductCount(int ID);
}
