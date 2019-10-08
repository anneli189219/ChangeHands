package px_changehands.dao;

import java.util.ArrayList;

import px_changehands.entity.Order;

public interface OrderDao {
	/**
	 * 删除订单
	 */
	public boolean OrderDelete(int oid);
	/**
	 * 多表查询
	 * @param id 
	 * @param pid 
	 * @return
	 */
	public ArrayList<Order> OrderMap();
	/**
	 * 查询全部订单数量
	 * @return
	 */
	public String ordernumber();
}
