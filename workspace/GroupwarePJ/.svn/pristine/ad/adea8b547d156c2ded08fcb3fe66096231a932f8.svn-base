package kr.or.ddit.event;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationEvent;

import lombok.Data;



public class CredentialEvent extends ApplicationEvent {

	public CredentialEvent(Object source,HttpSession httpSession) {
		super(source);
		this.httpSession = httpSession;
	}
	HttpSession httpSession;
	
	public HttpSession getHttpSession() {
		return httpSession;
	}
	
	
}
