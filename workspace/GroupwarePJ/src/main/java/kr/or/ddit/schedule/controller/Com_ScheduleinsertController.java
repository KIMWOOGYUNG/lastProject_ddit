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
import kr.or.ddit.schedule.dao.IComStandardDAO;
import kr.or.ddit.schedule.service.ICom_ScheduleService;
import kr.or.ddit.vo.Com_ScheduleVO;
import kr.or.ddit.vo.EmployeeVO;

@Controller
public class Com_ScheduleinsertController {

	@Inject
	ICom_ScheduleService service;
	
	@Inject
	IComStandardDAO stdDAO;
	
	private void attributeSetting(Model model) { //스탠다드 세팅 메서드
		System.out.println(stdDAO.selectcatag().toString());
		model.addAttribute("comschedulenm", stdDAO.selectcatag());
		model.addAttribute("comimportantnm",stdDAO.selectimportant());
	}
	
	@GetMapping("/plan/companyplan/complanenroll")//등록버튼을 누르면 그 주소로 이동
	public String form(Model model, HttpSession session) {
		attributeSetting(model); //스탠다드 세팅 메서드 호출
		EmployeeVO employ = (EmployeeVO)session.getAttribute("authUser");
		model.addAttribute("authUser", employ);
		return "ComScheduleEnroll.plan";
	}
	
	//새창에서 일정 등록할 때
	@PostMapping(value = "/plan/companyplan/complanenroll" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_PLAIN_VALUE )
	@ResponseBody
	public String comscheduleenrollparam(@Valid @RequestBody Com_ScheduleVO comscheduleVO, Errors errors, Model model, HttpSession session) {
	 comscheduleenroll(comscheduleVO, errors, model, session);
	 return "ok";
	}
	
	//기존 등록창에서 일정 등록할 때
	@PostMapping(value = "/plan/companyplan/complanenroll" )
	public String comscheduleenroll(@Valid @ModelAttribute Com_ScheduleVO comscheduleVO, Errors errors, Model model, HttpSession session) {
		System.out.println(comscheduleVO.toString());
		EmployeeVO employ = (EmployeeVO)session.getAttribute("authUser");
		comscheduleVO.setEmp_code(employ.getEmp_code());
		
		 
		String goPage = null;
		String message = null;
		if(!errors.hasErrors()) {
			ResultState result = service.insertCom(comscheduleVO);
			System.out.println(result);
			switch (result) {
			case FAIL:
				goPage = "ComScheduleEnroll.plan";
				message = "다시 입력하세요";
				break;

			default:
				goPage = "redirect:/plan/complancalendar";
		
				message = "insert성공";
				break;
			}
			
		}else {
			System.out.println(errors.toString());
			goPage = "ComScheduleEnroll.plan";
		}
		
		model.addAttribute("message", message);
		
		return goPage;
	}
	
}
