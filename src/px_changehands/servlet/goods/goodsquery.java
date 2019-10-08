package px_changehands.servlet.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import px_changehands.Service.AdminService;
import px_changehands.entity.Product;

/**
 * Servlet implementation class goodsquery
 */
@WebServlet("/goodsquery")
public class goodsquery extends HttpServlet {
	AdminService adminService = new AdminService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsquery() {
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

		if (request.getParameter("provid").equals("10")) {
			System.out.println(request.getParameter("name"));
			ArrayList<Product> arrayListquery = (ArrayList<Product>)adminService.GoodsSelectlike(request.getParameter("name"));
			request.setAttribute("number", adminService.GoodsQueryNumber(request.getParameter("name")));
			request.setAttribute("arrayListquery", arrayListquery);
			request.getRequestDispatcher("ManagementSystem/tgls/goodsManage/goods_query.jsp").forward(request, response);
		}else {
			//System.out.println(request.getParameter("provid"));
			ArrayList<Product> arrayListquery = (ArrayList<Product>)adminService.GoodsClass(Integer.valueOf(request.getParameter("provid")));
			request.setAttribute("number", adminService.GoodsClassNumber(Integer.valueOf(request.getParameter("provid"))));
			request.setAttribute("arrayListquery", arrayListquery);
			request.getRequestDispatcher("ManagementSystem/tgls/goodsManage/goods_query.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
			
	}

}
