package kr.or.ddit.interceptors;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.event.dao.IPushMessageDAO;
import kr.or.ddit.vo.EmployeeVO;

public class AuthenticationHandlerIntercepter extends HandlerInterceptorAdapter{
	@Inject
	IPushMessageDAO dao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean pass = true;
		
		String url = parseRequestURI(request);
		EmployeeVO authUser = (EmployeeVO) request.getSession().getAttribute("authUser");
		
		if(!url.equals("/")&&authUser==null) pass = false;
		if(url.equals("/main/findpassword")&&authUser==null) pass = true;
		if(url.equals("/getImage")&&authUser==null) pass = true;
		
		if(!pass)
			response.sendRedirect(request.getContextPath()+"/");
		
		if(authUser != null) {
			 EmployeeVO empVO = (EmployeeVO)authUser;
			 String emp_code = empVO.getEmp_code();
			 request.setAttribute("pushDraftList", dao.selectDraftPush(emp_code));
			 request.setAttribute("pushDraftCount", dao.selectDraftCount(emp_code));
			 request.setAttribute("pushMessagetList", dao.selectMessagePush(emp_code));
			 request.setAttribute("pushMessageCount", dao.selectMessageCount(emp_code));
		}
		return pass;
		
	}
	public static String parseRequestURI(HttpServletRequest req) {
		String uri = req.getRequestURI().split(";")[0];
		int length = req.getContextPath().length();
		uri = uri.substring(length);
		return uri;
	}
}
