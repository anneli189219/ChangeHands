package changehands.servlet.User;

import java.io.File;
import java.io.IOException;
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

import changehands.dao.impl.UserDaoImpl;
import changehands.entity.UserBean;

/**
 * Servlet implementation class UserUploadPcture
 */
@WebServlet("/UserUploadPcture")
public class UserUploadPcture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUploadPcture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
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
		
		String userName=(String) request.getAttribute("UserName");//用户名
		String sex=(String) request.getAttribute("Sex");//性别
		int age = Integer.parseInt((String) request.getAttribute("Age"));//年龄
		String email=(String) request.getAttribute("Email");//邮箱
		String mobile=(String) request.getAttribute("Mobile");//手机
		String address = (String) request.getAttribute("Address");//地址
		String headPath = (String) request.getAttribute("fileName");//头像
		
		//解决乱码
		userName = new String(userName.toString().getBytes("iso-8859-1"),"utf-8");
		sex = new String(sex.toString().getBytes("iso-8859-1"),"utf-8");
		address = new String(address.toString().getBytes("iso-8859-1"),"utf-8");
		
		HttpSession session = request.getSession();
		
		int UserID = (int)session.getAttribute("UserID");//获得session里的用户ID
		
		UserBean User = new UserBean();
	
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		User = userDaoImpl.UserSelect(UserID);
		
		if (!userName.equals("")) {
			if (!userDaoImpl.UserNameCheck(User.getUserName(),userName)) {
				User.setUserName(userName);
				User.setSex(sex);
				User.setAge(age);
				User.setEmail(email);
				User.setMobile(mobile);
				User.setAddress(address);
				User.setHeadPath(headPath);
				
				userDaoImpl.UserUpdate(UserID, User);
				response.getWriter().println("<script> alert('保存成功！');window.location='pages/UserInforPage.jsp'</script>");
			}
			else {
				response.getWriter().println("<script> alert('用户名已存在！请重新输入！');window.location='pages/UserInforPage.jsp'</script>");
			}

		}
		else{
			response.getWriter().println("<script> alert('用户名不能为空！');window.location='pages/UserInforPage.jsp'</script>");
		}
	}

}
