package kr.or.ddit.mail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {
	
@GetMapping("/mail/entiremailbox")//전체메일함
 public String MailList() {
	 String goPage="mailList.mail";
	return goPage;
	 
 }
///메일쓰기
@GetMapping("/mail/mailRegist")
public String writemail() {
	String goPage = "mailRegist.mail";
	return goPage;
	
}


@GetMapping("/mail/receivemailbox")//받은메일
public String ReceiveMailList() {
	 String goPage="receivemail.mail";
	return goPage;
	 
}

@GetMapping("/mail/sendmailbox") //보낸메일
public String SendMailList() {
	 String goPage="sendmail.mail";
	return goPage;
	 
}
@GetMapping("/mail/selfmailbox")//내게쓰기
public String SelfMailList() {
	 String goPage="selfmail.mail";
	return goPage;
	 
}
@GetMapping("/mail/temporarymailbox")//임시보관함
public String TempMailList() {
	 String goPage="tempmail.mail";
	return goPage;
	 
}
@GetMapping("/mail/mailtrashbasket") //휴지통
public String DeleteMailList() {
	 String goPage="maildelete.mail";
	return goPage;
	 
}
@GetMapping("/mail/environmentsetting") //환경설정
public String eleteMailList() {
	 String goPage="configurationmail.mail";
	return goPage;
	 
}	
@GetMapping("/mail/environmentsetting/configurationmail") //환경설정 명함
public String ConfigMailList() {
	 String goPage="configurationmail.mail";
	return goPage;
	 
}

@GetMapping("/mail/environmentsetting/template") //환경설정 템플릿
public String TemplateMailList() {
	 String goPage="template.mail";
	return goPage;
	 
}

}
