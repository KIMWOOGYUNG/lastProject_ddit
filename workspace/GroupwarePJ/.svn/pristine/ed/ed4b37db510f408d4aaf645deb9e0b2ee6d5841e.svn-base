package kr.or.ddit.schedule.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.dao.IAdminDepartDAO;
import kr.or.ddit.hr_admin.service.IAdminDepartService;
import kr.or.ddit.hr_admin.service.IAdminEmployService;
import kr.or.ddit.schedule.dao.IDepStandardDAO;
import kr.or.ddit.schedule.dao.IDep_ScheduleDAO;
import kr.or.ddit.schedule.service.IDep_ScheduleService;
import kr.or.ddit.vo.Dept_ScheduleVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;

	@Controller
	public class Dep_ScheduleinsertController {
	
	@Inject
	IDep_ScheduleService service;
	
	@Inject
	IDepStandardDAO stdDAO;
	
	@Inject
	IAdminDepartService deptService;
	
	@Inject
	IAdminEmployService empService;
	
	
	
	@GetMapping(value="/plan/depplanenroll", produces="application/json;charset=UTF-8")
	@ResponseBody
	public PagingVO<EmployeeVO> ajaxList(@RequestParam(name="page", required=false, defaultValue="1") int currentPage, EmployeeVO detailSearch, Model model) {
		deptmodal(currentPage, detailSearch, model);
		PagingVO<EmployeeVO> pagingVO = (PagingVO<EmployeeVO>) model.asMap().get("pagingVO");
		return pagingVO;
	}
	
	
	
	private void attributeSetting(Model model) { //스탠다드 세팅 메서드
		System.out.println(stdDAO.selectimportant().toString());
		model.addAttribute("depimportantnm",stdDAO.selectimportant());
		model.addAttribute("deptList", deptService.selectDeptList(null));
	}
	
	
	@GetMapping("/plan/depplanenroll/manager")
	public String deptmodal(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage, EmployeeVO detailSearch, Model model) {
		PagingVO<EmployeeVO> pagingVO = new PagingVO<>();
		pagingVO.setDetailSearch(detailSearch);
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = service.readEmpCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<EmployeeVO> empList = service.selectEmpList(pagingVO);
		pagingVO.setDataList(empList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		attributeSetting(model);
		return "DepScheduleEnroll.plan";
		
		
		
	}
	
	
	
	
	@GetMapping("/plan/depplanenroll")//등록버튼을 누르면 그 주소로 이동
	public String form(Model model, HttpSession session) {
		attributeSetting(model); //스탠다드 세팅 메서드 호출
		EmployeeVO employ = (EmployeeVO)session.getAttribute("authUser");
		model.addAttribute("authUser", employ);
		return "DepScheduleEnroll.plan";
	}
	
	//새창에서 일정 등록할 때
	@PostMapping(value = "/plan/depplanenroll" , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_PLAIN_VALUE )
	@ResponseBody
	public String depscheduleenrollparam(@Valid @RequestBody Dept_ScheduleVO deptscheduleVO, Errors errors, Model model, HttpSession session) {
		depscheduleenroll(deptscheduleVO, errors, model, session);
		return "ok";
	}
	
	//기존 등록창에서 일정 등록할 때
	@PostMapping(value = "/plan/depplanenroll")
	public String depscheduleenroll(@Valid @ModelAttribute Dept_ScheduleVO deptscheduleVO, Errors errors, Model model, HttpSession session) {
		System.out.println(deptscheduleVO.toString());
		EmployeeVO employ = (EmployeeVO)session.getAttribute("authUser");
		deptscheduleVO.setWriter(employ.getEmp_code());
		 
		String goPage = null;
		String message = null;
		if(!errors.hasErrors()) {
			ResultState result = service.insertDeptschedule(deptscheduleVO);
			System.out.println(result);
			switch (result) {
			case FAIL:
				goPage = "DepScheduleEnroll.plan";
				message = "다시 입력하세요";
				break;

			default:
				goPage = "redirect:/plan/depplancalendar/all";
				message = "insert성공";
				break;
			}
			
		}else {
			System.out.println(errors.toString());
			goPage = "DepScheduleEnroll.plan";
		}
		
		model.addAttribute("message", message);
		
		return goPage;
	}
	
}
	
	
	

