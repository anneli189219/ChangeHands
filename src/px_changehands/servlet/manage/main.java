package px_changehands.servlet.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import px_changehands.Service.AdminService;
import px_changehands.Service.ToolService;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
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
		
		ToolService toolService = new ToolService();
		AdminService adminService = new AdminService();
		request.setAttribute("usersnumber", adminService.getUsersNumber());
		request.setAttribute("istime", toolService.GetisTime());
		request.setAttribute("ip", toolService.Getip(request));
		request.setAttribute("systemname", toolService.Getsystemname());
		request.setAttribute("systeversion", toolService.Getsystemversion());
		request.setAttribute("systearchitecture", toolService.Getsystemarchitecture());
		request.setAttribute("goodsnumber", adminService.GoodsNumber());
		request.setAttribute("goodsoknumber", adminService.GoodsokNumber());
		request.setAttribute("newsnumber", adminService.NewsNumber());
		//System.out.println(adminService.GoodsokNumber());
		request.getRequestDispatcher("ManagementSystem/tgls/main/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
