package px_changehands.servlet.manage;

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
import px_changehands.entity.Users;

/**
 * Servlet implementation class agent_list
 */
@WebServlet("/agentlist")
public class agentlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agentlist() {
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
		ArrayList<Users> arrayList = (ArrayList<Users>)adminService.UsersSelectAll();
		session.setAttribute("nowpage", nowpage);//页数初始化
		session.setAttribute("arrayList", arrayList);
		session.setMaxInactiveInterval(0);
		request.setAttribute("totalPages", toolService.totalPages(Integer.valueOf(adminService.getUsersNumber())));//设置总页数
		request.getRequestDispatcher("ManagementSystem/tgls/agent/agent_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
