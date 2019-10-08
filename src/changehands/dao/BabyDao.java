package changehands.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import changehands.entity.BabyBean;

public interface BabyDao {
	
	/**
	 * 获得指定宝贝bID的商品信息
	 * @param bID 宝贝bID
	 * @return 返回宝贝bean
	 */
	public BabyBean BabySelect(int bID);
	
	/**
	 * 删除指定宝贝bID的内容
	 * @param bID 宝贝bID
	 */
	public void BabyDel(int bID);
	
	/**
	 * 添加指定的商品内容到宝贝
	 * @param babyBean 商品内容
	 */
	public void BaByAdd(BabyBean babyBean);
	
	/**
	 * 获得指定用户ID的宝贝集合
	 * @param ID 用户ID
	 * @return 返回宝贝集合
	 */
	public HashMap<String, Object> BaBySelectList(int currentpage, int numberpage, int ID);
	
	/**
	 * 获得指定用户ID的宝贝数量
	 * @param ID 用户ID
	 * @return 返回宝贝数量
	 */
	public int BabyCount(int ID);
}
