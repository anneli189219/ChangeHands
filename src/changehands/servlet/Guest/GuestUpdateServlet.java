package changehands.servlet.Guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changehands.dao.impl.GuestDaoImpl;
import changehands.entity.GuestBookBean;
import changehands.tool.Tool;

/**
 * Servlet implementation class GuestUpdateServlet
 */
@WebServlet("/GuestUpdateServlet")
public class GuestUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Tool tool = new Tool();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestUpdateServlet() {
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
		
		int gID = Integer.valueOf(request.getParameter("gID"));
		String put_text = request.getParameter("put_text");
		GuestDaoImpl guestDaoImpl = new GuestDaoImpl();
		
		GuestBookBean GuestBook = new GuestBookBean();
		GuestBook = guestDaoImpl.GuestGetValue(gID);
		
		GuestBookBean GuestBookUpdate = new GuestBookBean(GuestBook.getsetID(),GuestBook.getgetID(),gID,GuestBook.getpID(),put_text,GuestBook.getReleaseTime(),tool.getNowTime());
		guestDaoImpl.GuestUpdate(gID, GuestBookUpdate);
		
		response.getWriter().println("<script> alert('修改成功！');window.location='pages/UserGuestPage.jsp'</script>");
	}

}
