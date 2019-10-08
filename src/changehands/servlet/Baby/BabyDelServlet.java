package changehands.servlet.Baby;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changehands.dao.impl.BabyDaoImpl;
import changehands.entity.BabyBean;

/**
 * Servlet implementation class BabyDelServlet
 */
@WebServlet("/BabyDelServlet.do")
public class BabyDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BabyDelServlet() {
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
		
		int bID = Integer.valueOf(request.getParameter("bID"));
		
		BabyDaoImpl babyDaoImpl = new BabyDaoImpl();
		
		babyDaoImpl.BabyDel(bID);
		
		response.getWriter().println("<script> alert('删除宝贝成功！');window.location='BabyPage.jsp?fID=8'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
