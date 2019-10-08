package px_changehands.dao;

import java.util.ArrayList;

import px_changehands.entity.News;

public interface NewsDao {
	/**
	 * 查询全部
	 */
	public ArrayList<News> NewsList();
	/**
	 * 删除单个留言
	 */
	public void NewsDeleteOne(int gid);
	/**
	 * 检索留言
	 * @param pid 当前用户关乎的商品的id
	 */
	public ArrayList<News> NewsQuery(int pid);
	/**
	 * 查询全部留言数
	 */
	public String NewsNumber();
	/**
	 * 查询搜索商品数
	 */
	public String NewsQueryNumber(int id);
	/**
	 * 删除留言
	 */
	public void NewsDelete(int id);
}
