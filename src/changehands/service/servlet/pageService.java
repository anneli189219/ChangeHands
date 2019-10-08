package changehands.service.servlet;

import java.util.HashMap;
import java.util.List;
import changehands.dao.impl.ProductDaoImpl;
import changehands.entity.ProductBean;
import changehands.entity.pageBean;

/**
 * 首先要知道以下参数 请求的页码 每页最多显示多少条记录
 * 
 * @author
 *
 */
public class pageService {
	public pageService() {
	}

	
	@SuppressWarnings("unchecked")
	public pageBean getPageBean(int currentpage, int recordpage, String selectname, int fID) {
		// 通过DaoImpl查询数据库 构建pageBean 然后返回
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		HashMap<String, Object> myMap = productDaoImpl.ProductSelect(currentpage, recordpage, selectname, fID);
		pageBean pBean = new pageBean(currentpage, recordpage);
		pBean.setCurrentpage(currentpage);
		pBean.setNumberpage(recordpage);
		pBean.setProductlist((List<ProductBean>) (myMap.get("productBeans")));
		pBean.setTotalpage((int) ((int) myMap.get("totals") + recordpage - 1) / recordpage);
		if (currentpage < pBean.getTotalpage()) {
			pBean.setNext(currentpage + 1);
		}
		if (currentpage > 1) {
			pBean.setPre(currentpage - 1);
		}
		pBean.toString();
		return pBean;
	}
}