package px_changehands.dao;

import java.util.ArrayList;

import px_changehands.entity.Product;

public interface GoodsDao {
	/**
	 * 查询全部商品
	 */
	public ArrayList<Product> GoodsSelect();
	/**
	 * 查询单个商品
	 * @param pid 商品id
	 */
	public Product GoodsSelectOne(int pid);
	/**
	 * 删除商品
	 * @param pid 商品id
	 */
	public void GoodsDeleteOne(int pid);
	/**
	 * 根据ID删除
	 * @param id 用户id
	 */
	public void GoodsDelete(int id);
	/**
	 * 修改商品
	 */
	public void GoodsUpdate(int pid, Product product);
	/**
	 * 搜索商品
	 * @param tradename 商品名称
	 */
	public ArrayList<Product> GoodsSelectlike(String tradename);
	/**
	 * 查询全部商品数
	 */
	public String GoodsNumber();
	/**
	 * 审核商品
	 * @param pid 商品id
	 */
	public void CheckGoods(int pid);
	/**
	 * 查询所有未审核商品
	 */
	public ArrayList<Product> Goodsok();
	/**
	 * 查询所有未审核数量
	 */
	public String GoodsokNumber();
	/**
	 * 查询检索数量
	 */
	public String GoodsQueryNumber(String tradename);
	/**
	 * 商品下架
	 */
	public void LowerShelf(int pid);
	/**
	 * 查询分类商品
	 * @param fid 分类标识
	 */
	public ArrayList<Product> GoodsClass(int fid);
	/**
	 * 查询分类数量
	 * @param fid 分类标识
	 */
	public String GoodsClassNumber(int fid);
}
