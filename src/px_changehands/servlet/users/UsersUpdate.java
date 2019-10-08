package px_changehands.servlet.users;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import px_changehands.Service.AdminService;
import px_changehands.entity.Users;

/**
 * Servlet implementation class UsersUpdate
 */
@WebServlet("/UsersUpdate")
public class UsersUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		AdminService adminService = new AdminService();
		Users users = new Users(new String(request.getAttribute("UserName").toString().getBytes("iso-8859-1"),"utf-8"),
				new String(request.getAttribute("RealName").toString().getBytes("iso-8859-1"),"utf-8"),
				new String(request.getAttribute("Sex").toString().getBytes("iso-8859-1"),"utf-8"),
				Integer.valueOf((String)request.getAttribute("Age")),
				(String)request.getAttribute("Email"),
				(String)request.getAttribute("Mobile"),
				new String(request.getAttribute("Address").toString().getBytes("iso-8859-1"),"utf-8"));
		users.setHeadpath((String) request.getAttribute("fileName"));
		System.out.println(request.getParameter("id"));
		adminService.UsersUpdata(Integer.valueOf(request.getParameter("id")), users);
		response.getWriter().println("<script> alert('修改成功');window.location='/ChangeHands/agentlist'</script>");
	}

}
