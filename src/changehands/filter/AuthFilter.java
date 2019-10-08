package changehands.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthFilter
 */
//@WebFilter(filterName = "/AuthFilter" , urlPatterns = "/*" )
public class AuthFilter implements Filter {
	private List<String> list = new ArrayList<String>();
	
	public void init(FilterConfig arg0) throws ServletException {
		//定义不被拦截的页面
		list.add("/index.jsp");
		list.add("/Login.jsp");
		list.add("/Register.jsp");
		list.add("/gbPassword.jsp");
		list.add("/setPassword.jsp");
		
		list.add("/productInfo.jsp");
		list.add("/productPage.jsp");
		list.add("/productSearch.jsp");
		
		list.add("/index-denglu_n.jsp"); 
		list.add("/index-denglu_y.jsp"); 
		
		list.add("/index-nav_n.jsp"); 
		list.add("/index-nav_y.jsp"); 
		
		list.add("/index-end.jsp"); 
		list.add("/index-top.jsp"); 
	}
	
	/**
	 * Default constructor.
	 */
	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		//1、获取页面中的访问的路径连接
		String path = request.getServletPath();
		
		System.out.println(path);
		
		if(list!=null && list.contains(path)){
			//如果页面中获取的访问连接于定义的可放行的连接一致，则放行
			chain.doFilter(request, response);
			return;
		}
		//2、从session对象中获取当前登录的用户ID
		
		if(request.getSession().getAttribute("UserID")!=null){
			//如果从session中获取的用户对象不为空，则放行
			chain.doFilter(request, response);
			return;
		}
		//如果不满足条件1和2，则不能放行，回到系统的登录页面
		//response.sendRedirect(request.getContextPath()+"/Login.jsp");
		response.getWriter().println("<script>window.location.href='Login.jsp'</script>");
	}

}
