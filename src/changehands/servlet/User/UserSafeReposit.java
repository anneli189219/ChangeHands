package changehands.servlet.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changehands.entity.UserBean;
import changehands.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class UserSafeReposit
 */
@WebServlet("/UserSafeReposit")
public class UserSafeReposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSafeReposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		String OldPassword=request.getParameter("OldPassword");//旧密码
		String NewPassword=request.getParameter("NewPassword");//新密码
		String NewPassword_ = request.getParameter("NewPassword_");//确认密码
		String RealName = request.getParameter("RealName");//真实姓名
		
		HttpSession session = request.getSession();
		
		int UserID = (int)session.getAttribute("UserID");//获得session里的用户ID
		
		UserBean User = new UserBean();
	
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		User = userDaoImpl.UserSelect(UserID);
		
		if (!OldPassword.equals("")) {
			if(userDaoImpl.UserLogin(User.getUserName(), OldPassword)){
				//System.out.println(User.getUserName()+OldPassword);
				if (!NewPassword.equals("")) {
					if (NewPassword.equals(NewPassword_)) {
						User.setPassword(NewPassword);
						userDaoImpl.UserUpdate(UserID, User);
						response.getWriter().println("<script> alert('保存成功！请重新登录！');top.location='UserLogin.jsp'</script>");
					}
					else {
						response.getWriter().println("<script> alert('两次密码不正确！请重新输入！');window.location='pages/UserSafePage.jsp'</script>");
					}
				}
				else{
					response.getWriter().println("<script> alert('新密码不能为空！请重新输入');window.location='pages/UserSafePage.jsp'</script>");
				}
			}
			else {
				response.getWriter().println("<script> alert('旧密码错误！请重新输入！');window.location='pages/UserSafePage.jsp'</script>");
			}
		}
		else{
			User.setRealName(RealName);
			userDaoImpl.UserUpdate(UserID, User);
			response.getWriter().println("<script> alert('保存成功！');window.location='pages/UserSafePage.jsp'</script>");
		}
		

	}

}
