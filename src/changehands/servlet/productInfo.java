package changehands.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changehands.dao.impl.GuestDaoImpl;
import changehands.dao.impl.ProductDaoImpl;
import changehands.entity.GuestBookBean;
import changehands.entity.ProductBean;

/**
 * Servlet implementation class productInfo
 */
@WebServlet("/productInfo")
public class productInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productInfo() {
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
		
		int pID=Integer.parseInt(request.getParameter("pID"));
		
		//商品信息
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		ProductBean productBean = productDaoImpl.getProductSelect(pID);
		request.setAttribute("productBean", productBean);
		
		//留言信息
		GuestDaoImpl guestDaoImpl = new GuestDaoImpl();
		ArrayList<GuestBookBean> guestBookList = guestDaoImpl.getGuestSet(productBean.getID(),pID); 
		request.setAttribute("guestBookList", guestBookList);
		
		request.getRequestDispatcher("ProductInfo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
