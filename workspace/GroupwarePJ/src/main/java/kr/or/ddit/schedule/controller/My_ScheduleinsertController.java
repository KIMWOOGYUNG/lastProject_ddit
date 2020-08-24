package kr.or.ddit.schedule.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.schedule.dao.IMyStandardDAO;
import kr.or.ddit.schedule.service.IMy_ScheduleService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.My_ScheduleVO;

@Controller
public class My_ScheduleinsertController {
	
	@Inject
	IMy_ScheduleService service;
	
	@Inject
	IMyStandardDAO stdDAO;
	

	
	private void attributeSetting(Model model) { //스탠다드 세팅 메서드
		System.out.println(stdDAO.selectimportant());
		model.addAttribute("myimportantnm",stdDAO.selectimportant());
		
	}
	
	
	@GetMapping("/plan/MyScheduleEnroll")//등록버튼을 누르면 그 주소로 이동
	public String form(Model model, HttpSession session) {
		attributeSetting(model); //스탠다드 세팅 메서드 호출
		EmployeeVO employ = (EmployeeVO)session.getAttribute("authUser");
		model.addAttribute("authUser", employ);
		return "MyScheduleEnroll.plan";
	}
	
	//새창에서 일정 등록할 때
	@PostMapping(value = "/plan/MyScheduleEnroll" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String myscheduleenrollparam(@Valid @RequestBody My_ScheduleVO myscheduleVO, Errors errors, Model model, HttpSession session) {
		myscheduleenroll(myscheduleVO, errors, model, session);
		return "ok";
	}
		
	//기존 등록창에서 일정 등록할 때	
	@PostMapping(value = "/plan/MyScheduleEnroll")
	public String myscheduleenroll(@Valid @ModelAttribute My_ScheduleVO myscheduleVO, Errors errors, Model model, HttpSession session) {
		System.out.println(myscheduleVO.toString());
		EmployeeVO employ = (EmployeeVO)session.getAttribute("authUser");
		myscheduleVO.setEmp_code(employ.getEmp_code());
		 
		String goPage = null;
		String message = null;
		if(!errors.hasErrors()) {
			ResultState result = service.insertMyschedule(myscheduleVO);
			System.out.println(result);
			switch (result) {
			case FAIL:
				goPage = "MyScheduleEnroll.plan";
				message = "다시 입력하세요";
				break;

			default:
				goPage = "redirect:/plan/myplancalendar/all";
				message = "insert성공";
				break;
			}
			
		}else {
			System.out.println(errors.toString());
			goPage = "MyScheduleEnroll.plan";
		}
		
		model.addAttribute("message", message);
		
		return goPage;
	}
	
	
	
	
	
	
}




