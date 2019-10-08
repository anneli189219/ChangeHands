package changehands.servlet.Shopping;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import changehands.dao.impl.ProductDaoImpl;
import changehands.dao.impl.ShoppingDaoImpl;
import changehands.entity.ProductBean;
import changehands.entity.ShoppingBean;
import changehands.tool.Tool;

/**
 * Servlet implementation class ShoppingAddServlet
 */
@WebServlet("/ShoppingAddServlet.do")
public class ShoppingAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Tool tool = new Tool();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//设置编码格式为utf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获得商品ID
		int pID = Integer.valueOf(request.getParameter("pID"));
		
		
		//获得添加到购物车的商品数量
		int num = Integer.valueOf(request.getParameter("num"));
		
		//得到用户的ID
		int UserID= (int)request.getSession().getAttribute("UserID");
		
		
		ProductBean productBean =new ProductBean();
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		
		//获得指定商品ID的商品内容
		productBean = productDaoImpl.getProductSelect(pID);
	
		//判断商品是不是自己发布的
		if (productBean.getID()!=UserID) {
			if (num!=0) {
				ShoppingDaoImpl shoppingDaoImpl = new ShoppingDaoImpl();//数据库操作类
				
				ShoppingBean shoppingBean = new ShoppingBean(UserID,pID,num,tool.getNowTime());//实体类
				
				shoppingDaoImpl.ShoppingInsert(shoppingBean);//增加商品到购物车
				
				request.getRequestDispatcher("ShoppingShowServlet.do").forward(request,response);//请求转发
			}
			else{
				response.getWriter().println("<script> alert('添加失败！商品数量不能为0！');top.location='index-x.jsp'</script>");
			}
		}else{
			response.getWriter().println("<script> alert('添加失败！不能添加自己发布的商品！');top.location='index-x.jsp'</script>");
		}
		
		
		
	}

}
