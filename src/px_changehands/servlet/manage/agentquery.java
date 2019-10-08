package px_changehands.servlet.manage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import px_changehands.Service.AdminService;
import px_changehands.entity.Users;

/**
 * Servlet implementation class agentquery
 */
@WebServlet("/agentquery")
public class agentquery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agentquery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
		
		AdminService adminService = new AdminService();
		ArrayList<Users> arrayListquery = (ArrayList<Users>)adminService.UsersSelectlike(request.getParameter("name"));
		request.setAttribute("number", adminService.getUsersQuery(request.getParameter("name")));
		request.setAttribute("arrayList", arrayListquery);
		request.getRequestDispatcher("ManagementSystem/tgls/agent/agent_query.jsp").forward(request, response);
	}

}
