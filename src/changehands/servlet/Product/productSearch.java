package changehands.servlet.Product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changehands.entity.pageBean;
import changehands.service.servlet.pageService;

/**
 * Servlet implementation class index
 */
@WebServlet("/productSearch")
public class productSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productSearch() {
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
		
		int currentpage = (int) Double.parseDouble(request.getParameter("currentpage") != null ? request.getParameter("currentpage") : "1");
		int recordpage = (int) Double.parseDouble(request.getParameter("recordpage") != null ? request.getParameter("recordpage") : "15");
		
		int fID=-1;
		if (request.getParameter("fID")!=null) {
			fID = Integer.valueOf(request.getParameter("fID"));
		}
		
		String selectname = request.getParameter("SelectName");
		
		HttpSession session = request.getSession();
		
		if (selectname==null) {
			selectname = (String) session.getAttribute("selectname");
		}else{
			session.setAttribute("selectname", selectname);
		}
		
		pageService pService = new pageService();
		
		pageBean pBean = pService.getPageBean(currentpage, recordpage, selectname, fID);
		
		request.setAttribute("fID", fID);
		request.setAttribute("pBean", pBean);
		request.setAttribute("productBeans", pBean.getProductlist());
		request.setAttribute("currentpage", pBean.getCurrentpage());
		request.setAttribute("recordpage", pBean.getNumberpage());
		
		request.getRequestDispatcher("productSearch.jsp").forward(request, response);
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
		
		int currentpage = (int) Double.parseDouble(request.getParameter("currentpage") != null ? request.getParameter("currentpage") : "1");
		int recordpage = (int) Double.parseDouble(request.getParameter("recordpage") != null ? request.getParameter("recordpage") : "15");
		
		int fID=-1;
		if (request.getParameter("fID")!=null) {
			fID = Integer.valueOf(request.getParameter("fID"));
		}
		
		String selectname = request.getParameter("SelectName");
		
		HttpSession session = request.getSession();
		
		if (selectname==null) {
			selectname = (String) session.getAttribute("selectname");
		}else{
			session.setAttribute("selectname", selectname);
		}
		
		pageService pService = new pageService();
		
		pageBean pBean = pService.getPageBean(currentpage, recordpage, selectname, fID);
		
		request.setAttribute("fID", fID);
		request.setAttribute("pBean", pBean);
		request.setAttribute("productBeans", pBean.getProductlist());
		request.setAttribute("currentpage", pBean.getCurrentpage());
		request.setAttribute("recordpage", pBean.getNumberpage());
		
		request.getRequestDispatcher("productSearch.jsp").forward(request, response);
	}

}
