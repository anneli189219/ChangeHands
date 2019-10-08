package changehands.service.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import changehands.dao.impl.BabyDaoImpl;
import changehands.entity.BabypageBean;

/**
 * 首先要知道以下参数 请求的页码 每页最多显示多少条记录
 * 
 * @author
 *
 */
public class BabypageService {
	public BabypageService() {
	}

	
	@SuppressWarnings("unchecked")
	public BabypageBean getPageBean(int currentpage, int recordpage, int ID) {
		
		//得到baby对象的集合
		BabyDaoImpl babyDaoImpl  = new BabyDaoImpl();
		HashMap<String, Object> myMap = babyDaoImpl.BaBySelectList(currentpage, recordpage, ID);
		BabypageBean pBean = new BabypageBean(currentpage, recordpage);
		//currentpage当前页 recordpage一页显示的宝贝数量
		pBean.setCurrentpage(currentpage);
		pBean.setNumberpage(recordpage);
		
		pBean.setBabyList((List<Map<String, Object>>)(myMap.get("BabyList")));
		
		System.out.println(myMap.get("totals"));
		
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