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
 * Servlet implementation class SalePagingSearch
 */
@WebServlet("/SalePagingSearch")
public class SalePagingSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalePagingSearch() {
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
		
		int UserID = (int)session.getAttribute("UserID");

		String text=(String)session.getAttribute("text");
		
		ShoppedDaoImpl ShoppedDaoImpl = new ShoppedDaoImpl();

		List<Map<String, Object>> SaleList = ShoppedDaoImpl.getSaleSet(UserID,text);
		request.setAttribute("SaleList", SaleList);

		int intPage = (int)Math.ceil(SaleList.size()/5.0);
		
		if (SaleList.size()==0) {
			intPage=1;
		}
		
		int aPage=Integer.parseInt(request.getParameter("aPage"));//页码
		int sFlag=Integer.parseInt(request.getParameter("sFlag"));//操作标识
		
		switch(sFlag)
		{
		case 0:
			aPage=1;
			session.setAttribute("aPage", aPage);
			response.getWriter().println("<script>window.location='pages/UserSaleSearch.jsp'</script>");
			break;
		case 1:
			if (aPage!=1) {
				aPage--;
				session.setAttribute("aPage", aPage);
				response.getWriter().println("<script>window.location='pages/UserSaleSearch.jsp'</script>");
			}
			else{
				response.getWriter().println("<script>window.location='pages/UserSaleSearch.jsp'</script>");
			}
			break;
		case 2:
			if (aPage!=intPage&&SaleList.size()!=0) {
				aPage++;
				session.setAttribute("aPage", aPage);
				response.getWriter().println("<script>window.location='pages/UserSaleSearch.jsp'</script>");
			}
			else{
				response.getWriter().println("<script>window.location='pages/UserSaleSearch.jsp'</script>");
			}
			break;
		case 3:
			aPage=intPage;
			session.setAttribute("aPage", aPage);
			response.getWriter().println("<script>window.location='pages/UserSaleSearch.jsp'</script>");
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
