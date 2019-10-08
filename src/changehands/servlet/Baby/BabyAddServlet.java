package changehands.servlet.Baby;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changehands.dao.impl.BabyDaoImpl;
import changehands.entity.BabyBean;
import changehands.tool.Tool;

/**
 * Servlet implementation class BabyAddServlet
 */
@WebServlet("/BabyAddServlet.do")
public class BabyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Tool tool = new Tool();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BabyAddServlet() {
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
		
		int pID = Integer.valueOf(request.getParameter("pID"));
		
		int UserID = (int) request.getSession().getAttribute("UserID");
		
		BabyDaoImpl babyDaoImpl = new BabyDaoImpl();
		
		BabyBean babyBean = new BabyBean(UserID,pID,tool.getRandom(6),tool.getNowTime());
		
		babyDaoImpl.BaByAdd(babyBean);
		
		response.getWriter().println("<script> alert('收藏宝贝成功！');window.location='BabyPage.jsp?fID=8'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
