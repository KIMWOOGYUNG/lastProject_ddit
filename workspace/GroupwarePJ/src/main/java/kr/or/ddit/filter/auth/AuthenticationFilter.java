package kr.or.ddit.filter.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 보호 자원에 대한 요청에 대해 현재 요청을 발생시킨 클라이언트가 인증된 클라이언트인지 확인.
 * 인증된 클라이언트? 자원 제공
 * 인증전 클라이언트? 로그인 폼으로 이동
 *
 */
public class AuthenticationFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);
//	private Map<String, Set<String>> securedResources;
//	private IResourceDAO resourceDAO = new ResourceDAOImpl();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		securedResources = new LinkedHashMap<>();
//		filterConfig.getServletContext().setAttribute("securedResources", securedResources);
//		// 데이터베이스로부터 조회 후 Map 완성.
//		List<ResourceVO> resouceList = resourceDAO.selectResourceList();
//		for(ResourceVO res :  resouceList) {
//			securedResources.put(res.getRes_url(), res.getRoles());
//		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		boolean pass = true;
		
		String url = parseRequestURI(req);
		Object authUser = req.getSession().getAttribute("authUser");
		if(!url.equals("/")&&authUser==null) pass = false;
		
		if(pass) {
			chain.doFilter(request, response);
		}else {
			resp.sendRedirect(req.getContextPath()+"/");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public static String parseRequestURI(HttpServletRequest req) {
		String uri = req.getRequestURI().split(";")[0];
		int length = req.getContextPath().length();
		uri = uri.substring(length);
		return uri;
	}
}
