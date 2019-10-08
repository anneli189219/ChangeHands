package changehands.servlet.Product;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changehands.dao.impl.ProductDaoImpl;
import changehands.entity.ProductBean;
import changehands.tool.Tool;

/**
 * Servlet implementation class ProductAddServlet
 */
@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Tool tool = new Tool();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		int UserID= (int)session.getAttribute("UserID");
		
		String TradeName = request.getParameter("ProductName");
		String Describes = request.getParameter("Describe");
		BigDecimal Price = new BigDecimal(request.getParameter("Price"));
		int Number = Integer.valueOf(request.getParameter("Number"));
		String ShowPath = "DefaultProduct.jpg";
		int fID = Integer.valueOf(request.getParameter("product_list"));
		
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		
		ProductBean productBean = new ProductBean(UserID, tool.getRandom(6), false, TradeName, Describes, Price, Number, ShowPath, fID, tool.getNowTime());
		
		productDaoImpl.ProductInsert(productBean);
		
		response.getWriter().println("<script> alert('发布成功！');window.location='pages/UserProductPage.jsp'</script>");
	}

}
