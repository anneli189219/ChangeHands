package changehands.servlet.Shopping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import changehands.dao.impl.ProductDaoImpl;
import changehands.dao.impl.ShoppedDaoImpl;
import changehands.dao.impl.ShoppingDaoImpl;
import changehands.entity.ProductBean;
import changehands.entity.ShoppedBean;
import changehands.entity.ShoppingBean;
import changehands.entity.pageBean;
import changehands.tool.Tool;

/**
 * Servlet implementation class shoppingHandle
 */
@WebServlet("/shoppingHandle")
public class shoppingHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Tool tool = new Tool();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int UserID = (int) request.getSession().getAttribute("UserID");
		//获得商品ID
		int pID = Integer.valueOf(request.getParameter("pID"));
		
		//得到操作指令 0减一   1加一   2下单   3删除
		int hID = Integer.valueOf(request.getParameter("hID"));
		
		ShoppingBean shoppingBean = new ShoppingBean();
		
		ShoppingDaoImpl shoppingDaoImpl = new ShoppingDaoImpl();
		
		//得到购物车的bean
		shoppingBean = shoppingDaoImpl.getShoppingBean(pID,UserID);
		
		List<Map<String,Object>> ShoppingList = null;
		
		switch (hID) {
		case 0://减一
			if (shoppingBean.getNumber()-1!=0) {
				shoppingDaoImpl.ShoppingUpdate(shoppingBean.getNumber()-1, pID, UserID);
				
				//重新赋值
				ShoppingList = shoppingDaoImpl.ShoppingSelect(UserID);
				request.setAttribute("ShoppingList", ShoppingList);
				
				request.getRequestDispatcher("Shopping.jsp").forward(request,response);//请求转发
			}
			else {
				
				ShoppingList = shoppingDaoImpl.ShoppingSelect(UserID);
				request.setAttribute("ShoppingList", ShoppingList);
				
				request.getRequestDispatcher("Shopping.jsp").forward(request,response);//请求转发
			}
			break;
		case 1://加一
			shoppingDaoImpl.ShoppingUpdate(shoppingBean.getNumber()+1, pID, UserID);
			
			//重新赋值
			ShoppingList = shoppingDaoImpl.ShoppingSelect(UserID);
			request.setAttribute("ShoppingList", ShoppingList);
			
			request.getRequestDispatcher("Shopping.jsp").forward(request,response);//请求转发
			break;
		case 2://下单
			ShoppedBean shoppedBean = new ShoppedBean(UserID,pID,tool.getRandom(6),shoppingBean.getNumber(),tool.getNowTime());
			
			ShoppedDaoImpl shoppedDaoImpl = new ShoppedDaoImpl();
			shoppedDaoImpl.ShoppedInsert(shoppedBean);
			
			//减库存
			ProductBean productBean = new ProductBean();
			ProductDaoImpl productDaoImpl = new ProductDaoImpl();
			productBean = productDaoImpl.getProductSelect(pID);
			
			if (productBean.getNumber()-shoppingBean.getNumber()<=0) {
				productBean.setFlag(false);
				productBean.setNumber(productBean.getNumber()-shoppingBean.getNumber());
				productDaoImpl.ProductUpdate(pID, productBean);
			}else {
				productBean.setNumber(productBean.getNumber()-shoppingBean.getNumber());
				productDaoImpl.ProductUpdate(pID, productBean);
			}
			
			//删除
			shoppingDaoImpl.ShoppingDel(pID, UserID);
			//重新赋值
			ShoppingList = shoppingDaoImpl.ShoppingSelect(UserID);
			request.setAttribute("ShoppingList", ShoppingList);
			
			request.getRequestDispatcher("Shopping.jsp").forward(request,response);//请求转发
			break;
		case 3://删除
			shoppingDaoImpl.ShoppingDel(pID, UserID);
			
			//重新赋值
			ShoppingList = shoppingDaoImpl.ShoppingSelect(UserID);
			request.setAttribute("ShoppingList", ShoppingList);
			
			request.getRequestDispatcher("Shopping.jsp").forward(request,response);//请求转发
			break;
		default:
			response.getWriter().println("<script> alert('出现异常！请重新登录！');window.location='Login.jsp'</script>");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
