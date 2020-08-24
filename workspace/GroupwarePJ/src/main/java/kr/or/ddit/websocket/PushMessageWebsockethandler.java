package kr.or.ddit.websocket;

import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import kr.or.ddit.event.MessageEvent;
import kr.or.ddit.event.dao.IPushMessageDAO;
import kr.or.ddit.vo.EmployeeVO;

public class PushMessageWebsockethandler extends TextWebSocketHandler{
	@Resource(name="wsSessionList")
	Map<String,WebSocketSession> wsSessionMap;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		EmployeeVO empVO = (EmployeeVO) session.getAttributes().get("authUser");
		String emp_code =empVO.getEmp_code();
		wsSessionMap.put(emp_code,session);
		
		
		System.out.println(empVO.getEmp_code()+"가 접속함");		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		EmployeeVO empVO = (EmployeeVO) session.getAttributes().get("authUser");
		String emp_code =empVO.getEmp_code();
		wsSessionMap.remove(emp_code);
		System.out.println(empVO.getEmp_code()+"가 나감");
	}
	
	
	
}
