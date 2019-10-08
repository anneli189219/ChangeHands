package px_changehands.servlet.users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import px_changehands.Service.AdminService;
import px_changehands.entity.Users;

/**
 * Servlet implementation class UsersDelete
 */
@WebServlet("/UsersDelete")
public class UsersDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersDelete() {
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
		//adminService.NewsDelete(Integer.valueOf(request.getParameter("id")));
		//adminService.GoodsDelete(Integer.valueOf(request.getParameter("id")));
		adminService.UsersDelete(Integer.valueOf(request.getParameter("id")));
		ArrayList<Users> arrayList = (ArrayList<Users>)adminService.UsersSelectAll();
		session.setAttribute("arrayList", arrayList);
		response.getWriter().println("<script> alert('删除成功');window.location='ManagementSystem/tgls/agent/agent_list.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
