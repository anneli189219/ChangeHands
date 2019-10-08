package px_changehands.servlet.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import px_changehands.Service.AdminService;
import px_changehands.Service.ToolService;

/**
 * Servlet implementation class Goodspaging
 */
@WebServlet("/Goodspaging")
public class Goodspaging extends HttpServlet {
	AdminService adminService = new AdminService();
	ToolService toolService = new ToolService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Goodspaging() {
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
		int paging = toolService.totalPages(Integer.valueOf(adminService.GoodsNumber()));//获取总页数
		request.setAttribute("totalPages", paging);//设置总页数
		session.setAttribute("nowpage", toolService.paging(request.getParameter("pages"),//获取操作
											(int)session.getAttribute("nowpage"),
											paging));//获取当前页数
		request.getRequestDispatcher("ManagementSystem/tgls/goodsManage/goods_list.jsp").forward(request, response);
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
		
		HttpSession session = request .getSession();
		//获取总页数
		int paging = toolService.totalPages(Integer.valueOf(adminService.GoodsNumber()));
		request.setAttribute("totalPages", paging);//设置总页数
		if (request.getParameter("nowpage").equals("")) {
			response.getWriter().println("<script> alert('请输入页数');window.location='/goodslist'</script>");
		}else {
			//获取当前页数
			int nowpage = Integer.valueOf(request.getParameter("nowpage"));
			if (nowpage<1) {
				response.getWriter().println("<script> alert('已到首页');window.location='/ChangeHands/goodslist'</script>");
			}else if (nowpage>paging) {
				response.getWriter().println("<script> alert('已到尾页');window.location='/ChangeHands/goodslist'</script>");
			}else {
				session.setAttribute("nowpage", nowpage);
				request.getRequestDispatcher("ManagementSystem/tgls/goodsManage/goods_list.jsp").forward(request, response);
			}
		}
	}

}
