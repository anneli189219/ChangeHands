package changehands.servlet.Shopping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changehands.dao.impl.ShoppingDaoImpl;

/**
 * Servlet implementation class ShoppingShowServlet
 */
@WebServlet("/ShoppingShowServlet.do")
public class ShoppingShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//得到用户ID
		HttpSession session = request.getSession();
		int UserID= (int)session.getAttribute("UserID");
		
		ShoppingDaoImpl shoppingDaoImpl = new ShoppingDaoImpl();//数据库操作类
		
		//得到商品集合内容
		List<Map<String,Object>> ShoppingList = shoppingDaoImpl.ShoppingSelect(UserID);
		
		//写入集合内容
		request.setAttribute("ShoppingList", ShoppingList);
		
		request.getRequestDispatcher("Shopping.jsp").forward(request,response);//请求转发
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//得到用户ID
		HttpSession session = request.getSession();
		int UserID= (int)session.getAttribute("UserID");
		
		ShoppingDaoImpl shoppingDaoImpl = new ShoppingDaoImpl();//数据库操作类
		
		//得到商品集合内容
		List<Map<String,Object>> ShoppingList = shoppingDaoImpl.ShoppingSelect(UserID);
		
		//写入集合内容
		request.setAttribute("ShoppingList", ShoppingList);
		
		request.getRequestDispatcher("Shopping.jsp").forward(request,response);//请求转发
	}

}
