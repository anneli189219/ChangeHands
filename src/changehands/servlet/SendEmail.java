package changehands.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changehands.tool.Tool;

@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Tool tool = new Tool();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=(String) request.getAttribute("username");
		String email=(String) request.getAttribute("email");
		
		int RandCode = tool.getRandom(6);
		
		//写入request
		request.setAttribute("username",username);
		
		//写入session
		request.getSession().setAttribute("RandCode",RandCode);
		
		String to = email;

		// 发件人电子邮箱
		String from = "382193833@qq.com";

		// 指定发送邮件的主机为 smtp.qq.com
		String host = "smtp.qq.com"; // QQ 邮件服务器

		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);

		properties.put("mail.smtp.auth", "true");
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("382193833@qq.com", "shmjfqribozgbjcd"); // 发件人邮件用户名、授权码
			}
		});

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: 头部头字段
			message.setSubject("This is the Subject Line!");

			// 设置消息体
			// message.setText("东哥最帅");

			String msgContent = "<!DOCTYPE html>"
					+"<html>"
					+"<head>"
					+"<meta charset='utf-8' />"
					+"<title>欢迎使用ChangeHands系统</title>"
					+"</head>"
					+"<body>"
							+"亲爱的会员，您好"
							+"<br/><br/>" 
							+"您在 " 
							+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date())
							+"提交找回密码的请求。"
							+"<br/><br/>"
							+"以下是您的帐户及验证码信息："
							+"<br/><br/>"
							+ "用户名："
							+ username
							+"<br/>"
							+ "验证码："
							+"<strong>"
							+ RandCode
							+"</strong>"
							+"<br/><br/>"
							+"感谢您使用本系统。"
							+"<br/>"
							+"此为自动发送邮件，请勿直接回复！"
							+"</body>"
							+"</html>";  
			message.setContent(msgContent, "text/html;charset=utf-8");// 设置邮件内容，为html格式 

			// 发送消息
			Transport.send(message);

			request.getRequestDispatcher("setPassword.jsp").forward(request,response);
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
