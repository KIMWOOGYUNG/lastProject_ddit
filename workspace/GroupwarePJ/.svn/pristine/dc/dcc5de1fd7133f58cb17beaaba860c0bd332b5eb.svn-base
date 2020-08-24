package kr.or.ddit.listener;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.event.dao.IPushMessageDAO;

/**
 * Application Lifecycle Listener implementation class TotalEventListener
 *
 */
@WebListener
public class TotalEventListener implements ServletContextListener, HttpSessionListener, ServletRequestListener, HttpSessionAttributeListener{
	private Logger logger = LoggerFactory.getLogger(TotalEventListener.class);
	

	
//	4. application scope
//	5. session scope
//	6. request scope
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
//		String attrName = event.getName();
//		if("authUser".equals(attrName)) {
//			MemberVO authUser = (MemberVO) event.getValue();
//			logger.info("�늻媛� 濡쒓렇�씤�뻽�굹??? {}", authUser.getMem_name());
//			Set<MemberVO> userList = (Set<MemberVO>) event.getSession().getServletContext().getAttribute("userList");
//			userList.add(authUser);
//			ServletContext application= event.getSession().getServletContext();
//			sendUserListToWebSocket(application,userList);
//		}
	}
	
//	private void sendUserListToWebSocket(ServletContext application,Set<MemberVO> userList) {
//		WebApplicationContext rootContext = (WebApplicationContext) application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		List<WebSocketSession> wSessions = rootContext.getBean("wsSessionList",List.class);
//		
//		try {
//		ObjectMapper mapper =new ObjectMapper();
//		String jsonMsg = mapper.writeValueAsString(userList);
//		for(WebSocketSession wsSession:wSessions) {
//			wsSession.sendMessage(new TextMessage(jsonMsg));
//		}
//		}catch(Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
//		String attrName = event.getName();
//		if("authUser".equals(attrName)) {
//			MemberVO authUser = (MemberVO) event.getValue();
//			logger.info("�늻媛� 濡쒓렇�븘�썐�뻽�굹??? {}", authUser.getMem_name());
//			Set<MemberVO> userList = (Set<MemberVO>) event.getSession().getServletContext().getAttribute("userList");
//			userList.remove(authUser);
//			ServletContext application= event.getSession().getServletContext();
//			sendUserListToWebSocket(application,userList);
//		}
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
	}
	
//	3. request lifecycle
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
//		logger.info("{} 로부터 {} 요청 발생.", sre.getServletRequest().getRemoteAddr(), new Date());
//		long startTime = System.currentTimeMillis();
//		sre.getServletRequest().setAttribute("startTime", startTime);
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
//		long startTime = (Long) sre.getServletRequest().getAttribute("startTime");
//		long endTime = System.currentTimeMillis();
//		logger.info("{} 요청의 소요 시간 {}ms", sre.getServletRequest().getRemoteAddr(), (endTime-startTime));
	}
	
//	2. session lifecycle
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("{} 세션 생성  ", se.getSession().getId());
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.info("{} 세션 소멸 ", se.getSession().getId());
	}
	
//	1. context lifecycle
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("{} 컨텍스트 시작", sce.getServletContext().getContextPath());
		ServletContext application = sce.getServletContext();
		application.setAttribute("cPath", application.getContextPath());
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("{} 컨텍스트 소멸", sce.getServletContext().getContextPath());
		
	}
	
}
