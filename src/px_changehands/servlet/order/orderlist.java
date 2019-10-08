package px_changehands.servlet.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import px_changehands.Service.AdminService;
import px_changehands.Service.ToolService;
import px_changehands.entity.Order;

/**
 * Servlet implementation class orderlist
 */
@WebServlet("/orderlist")
public class orderlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderlist() {
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
		int nowpage = 1;
		AdminService adminService = new AdminService();
		ToolService toolService = new ToolService();
		ArrayList<Order> arrayList = (ArrayList<Order>)adminService.OrderMap();
		session.setAttribute("nowpage", nowpage);//设置页数
		session.setAttribute("arrayList", arrayList);
		session.setMaxInactiveInterval(0);
		request.setAttribute("totalPages", toolService.totalPages(Integer.valueOf(adminService.ordernumber())));//设置总页数
		request.getRequestDispatcher("ManagementSystem/tgls/order/order_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
