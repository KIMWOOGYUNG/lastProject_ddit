package kr.or.ddit.filter.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 인증된 클라이언트에 대해 현재 요청하고 있는 보호자원에 대한 권한을 소유했는지 여부를 확인.
 * 
 *
 */
public class AuthorizationFilter implements Filter{

//	private Map<String, Set<String>> securedResources;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		if(securedResources==null)
//			securedResources = (Map<String, Set<String>>) request.getServletContext().getAttribute("securedResources");
//		
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse resp = (HttpServletResponse) response;
//		String uri = HandlerMapper.parseRequestURI(req);
//		Set<String> roles = securedResources.get(uri);
//		boolean pass = true;
//		if(roles!=null) {
//			MemberVO authUser = (MemberVO) req.getSession().getAttribute("authUser");
//			Set<String> mem_roles = authUser.getMem_roles();
//			boolean authorized = false;
//			for(String role : roles) {
//				authorized = mem_roles.contains(role);
//				if(authorized) break;
//			}
//			pass = pass && authorized;
//		}
//		if(pass) {
//			chain.doFilter(request, response);
//		}else {
//			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, uri+" 는 접근 할 수 없는 자원입니다.");
//		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
