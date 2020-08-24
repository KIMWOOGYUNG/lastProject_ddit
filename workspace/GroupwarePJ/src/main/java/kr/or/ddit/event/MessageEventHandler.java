package kr.or.ddit.event;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.event.dao.IPushMessageDAO;
import kr.or.ddit.vo.PushMessageVO;

@Component
public class MessageEventHandler {
	@Inject
	IPushMessageDAO dao;
	
	@Resource(name="wsSessionList")
	Map<String,WebSocketSession> wsSessionMap;
	
	@Async
	@EventListener(classes = MessageEvent.class)
	public void sendMessage(MessageEvent event) throws IOException {	
		PushMessageVO msgVO= event.getPushMessageVO();
		String receiver = msgVO.getReceiver();
		WebSocketSession session = wsSessionMap.get(receiver);
		
			dao.insertPushMessage(msgVO);
		
			ObjectMapper om = new ObjectMapper();
			if(session != null) {
				try {
					String jsonData = om.writeValueAsString(msgVO);
						session.sendMessage(new TextMessage(jsonData));
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
			}
			
		
	}
}