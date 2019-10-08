package changehands.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changehands.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class gbPasswordServlet
 */
@WebServlet("/gbPasswordServlet")
public class gbPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gbPasswordServlet() {
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
		String email=request.getParameter("email");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		boolean PasswordFlag =  userDaoImpl.getUserPasswordFlag(username, email);
		
		if (PasswordFlag) {
			//验证成功
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.getRequestDispatcher("SendEmail").forward(request,response);
		}else{
			//验证失败
			response.getWriter().println("<script> alert('邮箱和用户名不一致！请重新输入！');window.location='gbPassword.jsp'</script>");
		}
		
	}

}
