package kr.or.ddit.login_logout.controller;

import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.login_logout.service.LoginServiceImpl;
import kr.or.ddit.vo.EmployeeVO;

@Controller
@RequestMapping("/main/findpassword")
public class FindPasswordController {

	@Inject
	LoginServiceImpl service;
	
	@GetMapping //화면이동
    public String findPassword() {
    	return "main/findPassword";  
	}

	@PostMapping
	public String emailCheck(RedirectAttributes redirectAttributes,
			@RequestParam(required = false) String emp_code, 
			@RequestParam(required = false) String emp_mail) {
		String goPage= null;
		String message= null;
		if(StringUtils.isBlank(emp_code) || StringUtils.isBlank(emp_mail) ) {
			message = "사원번호,이메일 공란없이 모두 입력해주세요.";
			goPage = "redirect:findpassword"; //redirect로 붙으면 URL을 써준다
		}else {
			String dbMail = service.checkEmpMail(emp_code).getEmp_mail();
			if(emp_mail.equals(dbMail)) {
				String tempPassword = mailSender(emp_mail);
				//DB에 보낼 정보 VO에 담기 
				EmployeeVO employeeVO = new EmployeeVO();
				employeeVO.setEmp_code(emp_code);
				employeeVO.setEmp_pw(tempPassword);
				//DB에 입력
				ResultState result =service.changeEmpPassword(employeeVO);
				if(result.equals(ResultState.FAIL)) { //임시비번 DB저장 실패했을 경우 
					message= "정상처리되지 않았습니다. 다시시도해주세요.";
					goPage = "redirect:findpassword";
				}
				redirectAttributes.addFlashAttribute("tempPassword", "tempPassword");//세션에 임시비밀번호 상황 저장 , jsp에서 꺼내쓸것
				goPage="redirect:/";// MailSender Controller로 가도록! 가면 메일 보내주니깐...!
			}else {
				message = "입력하신 이메일과 등록된 이메일이 일치하지 않습니다.";
				goPage = "redirect:findpassword"; //새로고침 
			}
			//두개가 같은 경우 해당 email로 인증번호 전송되도록처리하기!
		}
			redirectAttributes.addFlashAttribute("message", message); 
			return goPage;
	}
	
	public String mailSender(String emp_mail) {
		// 네이버일 경우 smtp.naver.com 을 입력합니다. 
				// Google일 경우 smtp.gmail.com 을 입력합니다.
				String host = "smtp.naver.com"; 
				final String username = "jinniyah04"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요. 
				final String password = "eoejrdlswo123"; //네이버 이메일 비밀번호를 입력해주세요.
				int port=465; //포트번호
				//메일 내용
				String reciever = emp_mail; //받는 사람 메일 주소 
				String subject = "GroupWare 로그인 임시비밀번호"; //메일 제목
				//임시비밀번호 생성 
				String tempPassword = setPassword(8); 
				String body = "임시비밀번호는 "+tempPassword+"입니다."; //메일 내용 입력 
				Properties props = System.getProperties(); //정보를 담기 위한 객체 생성 
				//SMTP 서버 정보 설정 
				props.put("mail.smtp.host", host); 
				props.put("mail.smtp.port", port); 
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.ssl.enable", "true"); 
				props.put("mail.smtp.ssl.trust", host);
				//Session 생성 (왜?)
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					String un = username;
					String pw = password;
					protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
						return new javax.mail.PasswordAuthentication(un, pw);
					}
				});
				session.setDebug(true); //for debug (왜...?ㅠㅠ)
				Message mimeMessage = new MimeMessage(session); 
				try {
					mimeMessage.setFrom(new InternetAddress("jinniyah04@naver.com"));
					//발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
					//수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
					mimeMessage.setSubject(subject); //제목셋팅 
					mimeMessage.setText(body); //내용셋팅 
					Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				//잘 보내지면 예외가 null 이다! 
				//SMTP가 유효성 검사를 해서 예외에 안된다고 메시지를 보내준다.(badrequest response를 보내준다?!)
				//사원정보에서 비밀번호를 임시비밀번호로 변경하기 
			return tempPassword;
	}
			//임시비밀번호 생성 코드 
			public String setPassword(int length) { 
				int index = 0; 
				char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
				'w', 'x', 'y', 'z'}; 
				StringBuffer sb = new StringBuffer(); 
				for (int i = 0; i < length; i++) { 
				index = (int) (charArr.length * Math.random()); 
				sb.append(charArr[index]); 
				} 
				return sb.toString(); 
			} 
}