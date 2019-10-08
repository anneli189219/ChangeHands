package changehands.servlet.Guest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changehands.dao.impl.GuestDaoImpl;
import changehands.entity.GuestBookBean;

/**
 * Servlet implementation class GuestPagingSearch
 */
@WebServlet("/GuestPagingSearch")
public class GuestPagingSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestPagingSearch() {
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
		
		int UserID = (int)session.getAttribute("UserID");
		
		ArrayList<GuestBookBean> GuestBookList = new ArrayList<GuestBookBean>();

		GuestDaoImpl guestDaoImpl = new GuestDaoImpl();

		GuestBookList = guestDaoImpl.getGuestSet(UserID,text);
		request.setAttribute("GuestBookList", GuestBookList);

		int intPage = (int) Math.ceil(GuestBookList.size() / 5.0);

		if (GuestBookList.size() == 0) {
			intPage = 1;
		}

		int nPage = Integer.parseInt(request.getParameter("nPage"));// 页码
		int sFlag = Integer.parseInt(request.getParameter("sFlag"));// 操作标识

		switch (sFlag) {
		case 0:
			nPage = 1;
			session.setAttribute("nPage", nPage);
			response.getWriter().println("<script>window.location='pages/UserGuestSearch.jsp'</script>");
			break;
		case 1:
			if (nPage != 1) {
				nPage--;
				session.setAttribute("nPage", nPage);
				response.getWriter().println("<script>window.location='pages/UserGuestSearch.jsp'</script>");
			} else {
				response.getWriter().println("<script>window.location='pages/UserGuestSearch.jsp'</script>");
			}
			break;
		case 2:
			if (nPage != intPage && GuestBookList.size() != 0) {
				nPage++;
				session.setAttribute("nPage", nPage);
				response.getWriter().println("<script>window.location='pages/UserGuestSearch.jsp'</script>");
			} else {
				response.getWriter().println("<script>window.location='pages/UserGuestSearch.jsp'</script>");
			}
			break;
		case 3:
			nPage = intPage;
			session.setAttribute("nPage", nPage);
			response.getWriter().println("<script>window.location='pages/UserGuestSearch.jsp'</script>");
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
