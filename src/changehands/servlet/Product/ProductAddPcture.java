package changehands.servlet.Product;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import changehands.dao.impl.ProductDaoImpl;
import changehands.entity.ProductBean;
import changehands.tool.Tool;

/**
 * Servlet implementation class ProductAddPcture
 */
@WebServlet("/ProductAddPcture")
public class ProductAddPcture extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Tool tool = new Tool();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddPcture() {
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
		
		FileItemFactory factory = new DiskFileItemFactory();

		// 创建文件上传处理器
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 开始解析请求信息
		List<?> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 对所有请求信息进行判断
		Iterator<?> iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			// 信息为普通的格式
			if (item.isFormField()) {
				String fieldName = item.getFieldName();
				String value = item.getString();
				request.setAttribute(fieldName, value);
			}
			// 信息为文件格式
			else {
				String fileName = item.getName();
				System.out.println(fileName);//  输出文件上传路径
				int index = fileName.lastIndexOf("\\");
				fileName = fileName.substring(index + 1);
				request.setAttribute("fileName", fileName);
				System.out.println(fileName);//  输出文件名字
				String basePath = request.getSession().getServletContext().getRealPath("/imgs");	
				//  request.getRealPath("/imgs") 此方法已过时
				
				File file = new File(basePath, fileName);
				try {
					item.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		HttpSession session = request.getSession();
		int UserID= (int)session.getAttribute("UserID");
		
		String TradeName = (String) request.getAttribute("ProductName");
		String Describes = (String) request.getAttribute("Describe");
		BigDecimal Price = new BigDecimal((String) request.getAttribute("Price"));
		int Number = Integer.valueOf((String) request.getAttribute("Number"));
		String ShowPath = (String) request.getAttribute("fileName");
		int fID = Integer.valueOf((String) request.getAttribute("product_list"));
		
		//解决乱码
		TradeName = new String(TradeName.toString().getBytes("iso-8859-1"),"utf-8");
		Describes = new String(Describes.toString().getBytes("iso-8859-1"),"utf-8");
		
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		
		ProductBean productBean = new ProductBean(UserID, tool.getRandom(6), false, TradeName, Describes, Price, Number, ShowPath, fID, tool.getNowTime());
		
		productDaoImpl.ProductInsert(productBean);
		
		response.getWriter().println("<script> alert('发布成功！');window.location='pages/UserProductPage.jsp'</script>");
	}

}
