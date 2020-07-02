package io.imfast.webrwd.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.imfast.webrwd.model.User;
import io.imfast.webrwd.utils.SessionUtil;

public class AuthorizationFilter implements javax.servlet.Filter {

	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		if(url.startsWith(request.getContextPath()+"/admin")) {
			User user = (User) SessionUtil.getInstance().getValue(request,"USER");
			if(user != null) {
				if(user.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_permisson&alert=danger");
				}else if(user.getRole().getCode().equals("ADMIN")){
					filterChain.doFilter(request, response);
				}		
			}else {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
			}
			
		}else {
			filterChain.doFilter(request, response);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

}
