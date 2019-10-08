package px_changehands.servlet.goods;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import px_changehands.Service.AdminService;
import px_changehands.dao.impl.GoodsDaoImpl;
import px_changehands.entity.Product;

/**
 * Servlet implementation class goodsupdate
 */
@WebServlet("/goodsupdate")
public class goodsupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsupdate() {
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
		Product product = new Product();
		product.setTradename(request.getParameter("tradename"));
		product.setDescribes(request.getParameter("describes"));
		product.setPrice(new BigDecimal(request.getParameter("price")));
		product.setNumber(Integer.valueOf(request.getParameter("number")));
		product.setFid(Integer.valueOf(request.getParameter("provid")));
		
		adminService.GoodsUpdate(Integer.valueOf(request.getParameter("pid")), product);
		
		response.getWriter().println("<script> alert('修改成功');window.location='/ChangeHands/goodslist'</script>");
	}

}
