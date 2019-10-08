package changehands.servlet.Product;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changehands.dao.impl.ProductDaoImpl;
import changehands.entity.ProductBean;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
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
		
		int pid = Integer.valueOf(request.getParameter("pID"));

		String TradeName = request.getParameter("ProductName");
		String Describes = request.getParameter("Describe");
		BigDecimal Price = new BigDecimal(request.getParameter("Price"));
		int Number = Integer.valueOf(request.getParameter("Number"));
		//String ShowPath = request.getParameter("image_file");
		int fID = Integer.valueOf(request.getParameter("product_list"));
		
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		
		ProductBean pProduct = productDaoImpl.getProductSelect(pid);

		ProductBean productBean = new ProductBean(pProduct.getID(), pProduct.getpID(), pProduct.getFlag(), TradeName, Describes, Price, Number, pProduct.getShowPath(), fID, pProduct.getAddTime());
		
		productDaoImpl.ProductUpdate(pid, productBean);
		
		response.getWriter().println("<script> alert('修改成功！');window.location='pages/ProductInfoPage.jsp?pID="+pid+"'</script>");
	}

}
