package kr.or.ddit.att_admin.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.att_admin.service.IAdminAttService;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Com_PolicyVO;
import kr.or.ddit.vo.Com_WorkStdVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Time_AttendVO;

@Controller
public class AttCheckController {
	
	@Inject
	IAdminAttService service;
	
//	//접속 IP 가져오기 
//	private String getIp(HttpServletRequest request) {
//        String ip = request.getHeader("X-Forwarded-For");
//        if (ip == null) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null) {
//            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
//        }
//        if (ip == null) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null) {
//            ip = request.getRemoteAddr();
//        }
//        return ip;
//    }


//	메인의 출퇴근 체크 
	 @PostMapping(value="/attCheck.do" ,produces = "application/text; charset=utf8")
	 @ResponseBody //이걸 써야 브라우저가 알아먹을 수 있는 데이터로 보내줌, 스트링도 마찬가지
	 public String attCheck(HttpSession session, 
			 @RequestParam String cws_code, String checkTime, HttpServletRequest request)  {
		 //세션에서 emp_code랑 이름 구하기
		 String message = "";
		 EmployeeVO empInfoSession =(EmployeeVO) session.getAttribute("authUser");
		 String emp_code = empInfoSession.getEmp_code();
		 String emp_kor = empInfoSession.getEmp_kor();
		 
		 //출퇴근 체크 가능한 IP인지 확인, 불가할 경우 출퇴근체크가 불가능한 IP로 접속하셨습니다 return
//	 	 String userIp = getIp(request);
//	     String dbIP = empInfoSession.getEmp_ip();
//	 	 String dbIP2 = empInfoSession.getEmp_ip2();
//	 	 if (userIp.equals(dbIP)|| userIp.equals(dbIP2)){ //IP합격
		 	 //에이작스로 받은 cws_code(ex.20200701)VO에 담아주기 
			 Time_AttendVO timeAttVO = new Time_AttendVO();
			 timeAttVO.setEmp_code(emp_code);
			 timeAttVO.setCws_code(cws_code);
			 //출근체크 여부를 확인하기 위해 select문으로 먼저 보냄 
			 Time_AttendVO attVO = service.readEmpAtt(timeAttVO,checkTime);
			 if(attVO==null) {
				 message = "출퇴근 체크 실패";
				 return message;
			 }else {
				 message = emp_kor+"근태체크 완료";
				 return message;
			 }
//		 }else {
//	 		 //IP두개중 어느거와도 같지않을때
//	 		 message="출퇴근체크가 불가능한 IP로 접속하셨습니다";
//	 		 return message;
//	 	 }
//	 	 
	 	 
	 }

}
