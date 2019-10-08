package changehands.dao;

import java.util.ArrayList;
import changehands.entity.GuestBookBean;

/**
 * 该接口为操作GuestBook表的Dao层
 * 
 * @author 17软工莫培文
 *
 */
public interface GuestDao {
	/**
	 * 获得指定用户id的留言内容集合
	 * 
	 * @param id
	 *            用户id
	 * @return 返回留言集合
	 */
	public ArrayList<GuestBookBean> getGuestSet(int id);

	/**
	 * 获得查询内容的留言内容集合
	 * 
	 * @param id
	 *            用户id
	 * @param text
	 *            查询内容
	 * @return 返回留言集合
	 */
	public ArrayList<GuestBookBean> getGuestSet(int id, String text);
	
	/**
	 * 获得指定商品的留言内容
	 * @param id 商家ID
	 * @param pid 商品ID
	 * @return 返回留言集合
	 */
	public ArrayList<GuestBookBean> getGuestSet(int id, int pid);

	/**
	 * 修给指定留言id的留言内容
	 * 
	 * @param id
	 *            留言id
	 * @param GuestBook
	 *            修改内容的对象
	 */
	public void GuestUpdate(int id, GuestBookBean GuestBook);

	/**
	 * 删除指定留言id的留言内容
	 * 
	 * @param id
	 *            留言id
	 */
	public void GuestDel(int id);

	/**
	 * 插入新的留言内容 id是随机的6位数
	 * 
	 * 
	 * @param GuestBook
	 *            插入内容的对象
	 */
	public void GuestInsert(GuestBookBean GuestBook);
	
	/**
	 * 获得指定留言id的内容
	 * @param pid 留言id
	 * @return 返回留言内容 
	 */
	public GuestBookBean GuestGetValue(int pid);
}
