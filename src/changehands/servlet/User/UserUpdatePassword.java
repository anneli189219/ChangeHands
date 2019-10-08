package changehands.servlet.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changehands.dao.impl.UserDaoImpl;
import changehands.entity.UserBean;

/**
 * Servlet implementation class UserUpdatePassword
 */
@WebServlet("/UserUpdatePassword")
public class UserUpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatePassword() {
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
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int Code=Integer.valueOf(request.getParameter("Code"));

		int RandCode = (int) request.getSession().getAttribute("RandCode");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		int UserID = userDaoImpl.getUserID(username);
		
		UserBean userBean = userDaoImpl.UserSelect(UserID);
		
		if (Code==RandCode) {
			userBean.setPassword(password);
			userDaoImpl.UserUpdate(UserID, userBean);
			response.getWriter().println("<script> alert('密码修改成功！请重新登录！');top.location='Login.jsp'</script>");
		}else{
			response.getWriter().println("<script> alert('验证码错误！请重新输入！');top.location='gbPassword.jsp'</script>");
		}

	}

}
