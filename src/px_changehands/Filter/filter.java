package px_changehands.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class filter
 */
//@WebFilter(filterName="filter",urlPatterns="/ManagementSystem/tgls/*")
public class filter implements Filter {

    /**
     * Default constructor. 
     */
    public filter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;//获取request对象
		HttpServletResponse resp = (HttpServletResponse) response;//获取response对象
		resp.setContentType("text/html;");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();//获取session对象
		
		//获取session中是否保存了用户信息
        Object obj=session.getAttribute("admin");
		// 得到用户请求的URI
		String request_uri = req.getRequestURI();
		// 得到web应用程序的上下文路径
		String ctxPath = req.getContextPath();
		// 去除上下文路径，得到剩余部分的路径
		String url = request_uri.substring(ctxPath.length());
		System.out.println(url);
		if(url.equals("/ManagementSystem/login.jsp")){
            url="";
            chain.doFilter(request, response);
            return;
			  } else {
				  // 如果访问的不是登录页面，则判断用户是否已经登录
				  if (obj==null){
					  req.getRequestDispatcher("login.jsp").forward(request, response);
				  } 
				  else {
					  chain.doFilter(request, response);//放行，通过了当前过滤器，递交给下一个filter进行过滤
					  return;
				  }
			  }

		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
