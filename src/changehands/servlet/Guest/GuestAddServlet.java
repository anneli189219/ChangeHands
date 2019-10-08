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
import changehands.dao.impl.ProductDaoImpl;
import changehands.dao.impl.UserDaoImpl;
import changehands.entity.GuestBookBean;
import changehands.entity.ProductBean;
import changehands.tool.Tool;

/**
 * Servlet implementation class GuestAddServlet
 */
@WebServlet("/GuestAddServlet.do")
public class GuestAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Tool tool = new Tool();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestAddServlet() {
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
		
		HttpSession session = request.getSession();
	
		int UserID = (int)session.getAttribute("UserID");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		int uID = userDaoImpl.getUserID(request.getParameter("name"));
		
		int setID = UserID;
		int getID = uID;
		
		int pID = Integer.valueOf(request.getParameter("pID"));
		
		int num = 0;
		if (request.getParameter("num")!=null) {
			num = Integer.valueOf(request.getParameter("num"));
		}
		
		String text = request.getParameter("put_text");
		
		GuestBookBean guestBookBean =  new GuestBookBean(setID,getID,pID,tool.getRandom(6),text,tool.getNowTime(),tool.getNowTime());
		GuestDaoImpl guestDaoImpl = new GuestDaoImpl();
		
		guestDaoImpl.GuestInsert(guestBookBean);
		
		if (num==0) {
			//out重定向
			response.getWriter().println("<script> alert('回复成功！');window.location='pages/UserGuestPage.jsp'</script>");
		}
		else{
			//商品信息
			ProductDaoImpl productDaoImpl = new ProductDaoImpl();
			ProductBean productBean = productDaoImpl.getProductSelect(pID);
			request.setAttribute("productBean", productBean);
			
			//留言信息
			ArrayList<GuestBookBean> guestBookList = guestDaoImpl.getGuestSet(productBean.getID(),pID); 
			request.setAttribute("guestBookList", guestBookList);
			
			request.getRequestDispatcher("ProductInfo.jsp").forward(request,response);//请求转发
		}
		
	}

}
