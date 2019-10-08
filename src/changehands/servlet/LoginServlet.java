package changehands.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changehands.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		String checkbox = request.getParameter("checkbox");
		
		String codeCacheData = (String) request.getSession().getAttribute("CodeCacheData");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();

		boolean LoginOK = userDaoImpl.UserLogin(username, password);
		if (code.equals(codeCacheData)) {
			if (LoginOK) {
				int UserID=userDaoImpl.getUserID(username);
				HttpSession session = request.getSession();
				if (checkbox!=null) {
					Cookie cookie = new Cookie("checkbox", checkbox);//cookie
					cookie.setMaxAge(60*60);
					response.addCookie(cookie);
					
					session.setAttribute("UserID", UserID);
					session.setAttribute("User",userDaoImpl.UserSelect(UserID));
					session.setMaxInactiveInterval(3*24*60*60);//3天
				}
				else{
					session.setAttribute("UserID", UserID);
					session.setAttribute("User",userDaoImpl.UserSelect(UserID));
				}
				
				
				response.getWriter().println("<script>top.location='index-x.jsp'</script>");
				//request.getRequestDispatcher("index-x.jsp").forward(request,response);
			} else {
				response.getWriter().println("<script> alert('您输入的用户名或者密码错误！请重新登录！');window.location='Login.jsp'</script>");
			}
		}else {
			response.getWriter().println("<script> alert('您输入的验证码错误！请重新登录！');window.location='Login.jsp'</script>");
		}
		
	}

}
