package px_changehands.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import px_changehands.Service.AdminService;
import px_changehands.Service.ToolService;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		String userName = request.getParameter("userName");
		String password = request.getParameter("passWord");
		String md5password = toolService.MD5(password);//密码加密
		System.out.println(md5password);
		HttpSession session = request.getSession(); 
		boolean loginok = adminService.Loginok(userName, md5password);
		if (loginok) {
			//登陆成功用session存ID 
			session.setAttribute("admin", adminService.SelectAdmin(userName));
			session.setMaxInactiveInterval(0);
			System.out.println("登录成功");
			response.sendRedirect("ManagementSystem/frame.jsp");
		}else {
			response.getWriter().println("<script> alert('密码或用户名错误');window.location.href='ManagementSystem/login.jsp'</script>");
		}
		
		
	}

}
