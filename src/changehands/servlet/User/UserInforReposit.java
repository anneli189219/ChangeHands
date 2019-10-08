package changehands.servlet.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changehands.dao.impl.UserDaoImpl;
import changehands.entity.UserBean;

/**
 * Servlet implementation class UserInforReposit
 */
@WebServlet("/UserInforReposit")
public class UserInforReposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInforReposit() {
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
		
		String userName=request.getParameter("UserName");//用户名
		String sex=request.getParameter("Sex");//性别
		int age = Integer.parseInt(request.getParameter("Age"));//年龄
		String email=request.getParameter("Email");//邮箱
		String mobile=request.getParameter("Mobile");//手机
		String address = request.getParameter("Address");//地址

		HttpSession session = request.getSession();
		
		int UserID = (int)session.getAttribute("UserID");//获得session里的用户ID
		
		UserBean User = new UserBean();
	
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		User = userDaoImpl.UserSelect(UserID);
		
		if (!userName.equals("")) {
			if (!userDaoImpl.UserNameCheck(User.getUserName(),userName)) {
				User.setUserName(userName);
				User.setSex(sex);
				User.setAge(age);
				User.setEmail(email);
				User.setMobile(mobile);
				User.setAddress(address);
				
				userDaoImpl.UserUpdate(UserID, User);
				response.getWriter().println("<script> alert('保存成功！');window.location.href='pages/UserInforPage.jsp'</script>");
			}
			else {
				response.getWriter().println("<script> alert('用户名已存在！请重新输入！');window.location.href='pages/UserInforPage.jsp'</script>");
			}

		}
		else{
			response.getWriter().println("<script> alert('用户名不能为空！');window.location.href='pages/UserInforPage.jsp'</script>");
		}
	}

}
