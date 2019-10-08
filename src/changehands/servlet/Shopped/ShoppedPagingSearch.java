package changehands.servlet.Shopped;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changehands.dao.impl.ShoppedDaoImpl;

/**
 * Servlet implementation class ShoppedPagingSearch
 */
@WebServlet("/ShoppedPagingSearch")
public class ShoppedPagingSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppedPagingSearch() {
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
		
		String text=(String) session.getAttribute("text");

		ShoppedDaoImpl ShoppedDaoImpl = new ShoppedDaoImpl();

		int UserID = (int)session.getAttribute("UserID");
		
		List<Map<String, Object>> ShoppedList_ = ShoppedDaoImpl.getShoppedSet_(UserID,text);
		request.setAttribute("ShoppedList_", ShoppedList_);

		int intPage = (int)Math.ceil(ShoppedList_.size()/5.0);
		
		if (ShoppedList_.size()==0) {
			intPage=1;
		}
		
		int sPage=Integer.parseInt(request.getParameter("sPage"));//页码
		int sFlag=Integer.parseInt(request.getParameter("sFlag"));//操作标识
		
		switch(sFlag)
		{
		case 0:
			sPage=1;
			session.setAttribute("sPage", sPage);
			response.getWriter().println("<script>window.location='pages/UserShoppedSearch.jsp'</script>");
			break;
		case 1:
			if (sPage!=1) {
				sPage--;
				session.setAttribute("sPage", sPage);
				response.getWriter().println("<script>window.location='pages/UserShoppedSearch.jsp'</script>");
			}
			else{
				response.getWriter().println("<script>window.location='pages/UserShoppedSearch.jsp'</script>");
			}
			break;
		case 2:
			if (sPage!=intPage&&ShoppedList_.size()!=0) {
				sPage++;
				session.setAttribute("sPage", sPage);
				response.getWriter().println("<script>window.location='pages/UserShoppedSearch.jsp'</script>");
			}
			else{
				response.getWriter().println("<script>window.location='pages/UserShoppedSearch.jsp'</script>");
			}
			break;
		case 3:
			sPage=intPage;
			session.setAttribute("sPage", sPage);
			response.getWriter().println("<script>window.location='pages/UserShoppedSearch.jsp'</script>");
			break;
			
		default:
			response.getWriter().println("<script> alert('出现异常！请重新登录！');top.location='UserLogin.jsp'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
