package px_changehands.servlet.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import px_changehands.Service.AdminService;
import px_changehands.entity.Product;

/**
 * Servlet implementation class goodslower
 */
@WebServlet("/goodslower")
public class goodslower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodslower() {
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
		
		HttpSession session = request.getSession();
		AdminService adminService = new AdminService();
		boolean flag = Boolean.valueOf(request.getParameter("flag"));
		if (flag) {
			adminService.LowerShelf(Integer.valueOf(request.getParameter("pid")));
			ArrayList<Product> arrayList = (ArrayList<Product>)adminService.GoodsSelect();
			session.setAttribute("arrayList", arrayList);
			response.getWriter().println("<script> alert('下架成功');window.location='ManagementSystem/tgls/goodsManage/goods_list.jsp'</script>");
		}else {
			request.getRequestDispatcher("ManagementSystem/tgls/goodsManage/goods_list.jsp").forward(request, response);
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
