package agence.backoffice;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthControlFilter implements Filter {

	public AuthControlFilter() {}

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String auth = (String) session.getAttribute("authenticated");
		if (auth != null && auth.equals("1")) {
			chain.doFilter(request, response);
		} else {
//			session.setAttribute(arg0, arg1);
			httpResponse.sendRedirect(httpResponse.encodeRedirectURL("../"));
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
