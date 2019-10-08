package px_changehands.servlet.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import px_changehands.Service.AdminService;
import px_changehands.Service.ToolService;

/**
 * Servlet implementation class UsersUpdatePassword
 */
@WebServlet("/UsersUpdatePassword")
public class UsersUpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersUpdatePassword() {
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
		ToolService toolService = new ToolService();
		String password = toolService.MD5(request.getParameter("password"));
		String password2 = toolService.MD5(request.getParameter("password2"));
		if (password.equals(password2)) {
			adminService.UsersUpdatapassword(Integer.valueOf(request.getParameter("id")), password);
			response.getWriter().println("<script> alert('修改成功');window.location='/ChangeHands/agentlist'</script>");
		}else{
			response.getWriter().println("<script> alert('两次输入的密码不一样');window.location='ManagementSystem/tgls/users_password.jsp'</script>");
		}
		
	}

}
