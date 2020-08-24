package kr.or.ddit.work.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.WorkLogVO;
import kr.or.ddit.work.dao.IStandardDAO;
import kr.or.ddit.work.service.IMyWorkLogService;

@Controller
public class MyDiaryInsertController {
	
	@Inject
	private IStandardDAO stddDao;
	
	@Inject
	private IMyWorkLogService service;
	
	@ModelAttribute("currentAction")
	private void attributeSetting(Model model) {
		model.addAttribute("typeList", stddDao.selectType());
		model.addAttribute("deptList", stddDao.selectDept());
		model.addAttribute("teamList", stddDao.selectTeam());
	}
	
	@GetMapping("/work/mywork/insertdiary/{wl_catag}")
	public String form(Model model, @PathVariable String wl_catag) {
//		attributeSetting(model);
		model.addAttribute("state", "insertdiary");
		model.addAttribute("wl_catag", wl_catag);
		return "mydiaryForm.work";
	}
	
	@PostMapping(value = "/work/mywork/insertdiary/{wl_catag}" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String diaryinsert(@Valid @ModelAttribute("worklog") WorkLogVO worklogVO, Errors errors, Model model, HttpSession session, @PathVariable String wl_catag) {
		System.out.println(worklogVO.toString());
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser");
		
		String emp_code = employeeVO.getEmp_code();
		worklogVO.setEmp_code(emp_code);
		 
		String goPage = null;
		String message = null;
		if(!errors.hasErrors()) {
			ResultState result = service.createWorkLogday(worklogVO);
			System.out.println(result);
			switch (result) {
			case FAIL:
				goPage = "mydiaryForm.work";
				message = "다시 입력하세요";
				break;

			default:
				if(wl_catag.equals("daydiary")) {
					goPage = "mydaydiaryList.work";
				}else {
					goPage = "myweekdiaryList.work";
				}
				message = "insert성공";
				break;
			}
			
		}else {
			System.out.println(errors.toString());
			goPage = "mydiaryForm.work";
		}
		
		model.addAttribute("message", message);
	
		return goPage;
	}
//-----------------------------------------------------------------------------------------------------------------------------------------------------	
	@GetMapping("/work/mywork/insertdiary")
	public String teamform(Model model) {
		return "teamForm.work";
	}
	
	@PostMapping(value = "/work/mywork/insertdiary" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String teamdiaryinsert(@Valid @ModelAttribute("worklog") WorkLogVO worklogVO, Errors errors, Model model, HttpSession session) {
		System.out.println(worklogVO.toString());
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser");
		
		String emp_code = employeeVO.getEmp_code();
		worklogVO.setEmp_code(emp_code);
		 
		String goPage = null;
		String message = null;
		if(!errors.hasErrors()) {
			ResultState result = service.createWorkLogteam(worklogVO);
			System.out.println(result);
			switch (result) {
			case FAIL:
				goPage = "teamForm.work";
				message = "다시 입력하세요";
				break;

			default:
				goPage = "teamdiaryList.work";
				message = "insert성공";
				break;
			}
			
		}else {
			System.out.println(errors.toString());
			goPage = "teamForm.work";
		}
		
		model.addAttribute("message", message);
		
		return goPage;
	}
	
	
	
}
