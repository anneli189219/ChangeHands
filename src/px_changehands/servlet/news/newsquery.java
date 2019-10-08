package px_changehands.servlet.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import px_changehands.Service.AdminService;
import px_changehands.entity.News;

/**
 * Servlet implementation class newsquery
 */
@WebServlet("/newsquery")
public class newsquery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newsquery() {
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
		
		AdminService adminService = new AdminService();
		ArrayList<News> arrayListquery = (ArrayList<News>)adminService.NewsQuery(Integer.valueOf(request.getParameter("name")));
		request.setAttribute("number", adminService.NewsQueryNumber(Integer.valueOf(request.getParameter("name"))));
		request.setAttribute("arrayList", arrayListquery);
		request.getRequestDispatcher("ManagementSystem/tgls/news/news_query.jsp").forward(request, response);
	}

}
