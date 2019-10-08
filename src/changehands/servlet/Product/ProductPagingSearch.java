package changehands.servlet.Product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changehands.dao.impl.ProductDaoImpl;
import changehands.entity.ProductBean;

/**
 * Servlet implementation class ProductPagingSearch
 */
@WebServlet("/ProductPagingSearch")
public class ProductPagingSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPagingSearch() {
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
		
		ArrayList<ProductBean> ProductList = new ArrayList<ProductBean>();

		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		
		ProductList = productDaoImpl.getProductSet(UserID,text);
		request.setAttribute("ProductList", ProductList);
		
		int intPage = (int)Math.ceil(ProductList.size()/5.0);
		
		if (ProductList.size()==0) {
			intPage=1;
		}
		
		int pPage=Integer.parseInt(request.getParameter("pPage"));//页码
		int sFlag=Integer.parseInt(request.getParameter("sFlag"));//操作标识
		
		switch(sFlag)
		{
		case 0:
			pPage=1;
			session.setAttribute("pPage", pPage);
			response.getWriter().println("<script>window.location='pages/UserProductSearch.jsp'</script>");
			break;
		case 1:
			if (pPage!=1) {
				pPage--;
				session.setAttribute("pPage", pPage);
				response.getWriter().println("<script>window.location='pages/UserProductSearch.jsp'</script>");
			}
			else{
				response.getWriter().println("<script>window.location='pages/UserProductSearch.jsp'</script>");
			}
			break;
		case 2:
			if (pPage!=intPage&&ProductList.size()!=0) {
				pPage++;
				session.setAttribute("pPage", pPage);
				response.getWriter().println("<script>window.location='pages/UserProductSearch.jsp'</script>");
			}
			else{
				response.getWriter().println("<script>window.location='pages/UserProductSearch.jsp'</script>");
			}
			break;
		case 3:
			pPage=intPage;
			session.setAttribute("pPage", pPage);
			response.getWriter().println("<script>window.location='pages/UserProductSearch.jsp'</script>");
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
