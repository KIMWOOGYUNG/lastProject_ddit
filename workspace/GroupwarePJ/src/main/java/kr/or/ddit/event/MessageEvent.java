package kr.or.ddit.event;

import org.springframework.context.ApplicationEvent;

import kr.or.ddit.vo.PushMessageVO;
import lombok.Data;

@Data
public class MessageEvent extends ApplicationEvent {

	public MessageEvent(Object source,PushMessageVO pushMessageVO) {
		super(source);
		this.pushMessageVO = pushMessageVO;
	}
	
	private PushMessageVO pushMessageVO;

}
