package px_changehands.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import px_changehands.Service.AdminService;
import px_changehands.Service.ToolService;
import px_changehands.entity.Admin;
import px_changehands.entity.AdminSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminUpdate")
public class AdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdate() {
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
		AdminSession adminSession = (AdminSession) request.getSession().getAttribute("admin");//session
		Admin admin = new Admin();
		
		String oldpassword = toolService.MD5(request.getParameter("oldpassword"));//旧密码加密
		String password = toolService.MD5(request.getParameter("password"));
		String password2 = toolService.MD5(request.getParameter("password2"));

		//判断旧密码和两次新密码是否正确
		boolean loginok = adminService.Loginok(adminSession.getAdminname(), oldpassword);
		if (loginok) {
			if (password.equals(password2)) {
				admin.setAdminpassword(toolService.MD5(request.getParameter("password")));//新密码加密并放到admin里
				admin.setId(adminSession.getId());//把session里的id放到admin里
				adminService.UpdateAdmin(oldpassword, admin);//更新sql数据
				response.getWriter().println("<script> alert('修改成功');top.location='ManagementSystem/login.jsp'</script>");
			}else{
				response.getWriter().println("<script> alert('两次输入的密码不一样');window.location='ManagementSystem/tgls/admin_password.jsp'</script>");
			}
		}else{
			response.getWriter().println("<script> alert('原密码错误');window.location='ManagementSystem/tgls/admin_password.jsp'</script>");
		}
		
	}

}
