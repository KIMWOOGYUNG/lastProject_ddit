package kr.or.ddit.project.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.project.dao.IPJStandardDAO;
import kr.or.ddit.project.service.IProjectListService;
import kr.or.ddit.project.service.ITaskListService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TaskVO;

@Controller
public class TaskModifyController {
	
	@Inject
	ITaskListService service;
	@Inject
	IPJStandardDAO stdDao;
	@Inject
	IProjectListService pjService;
	
	private void attibuteSetting(Model model){
		model.addAttribute("deptList", stdDao.selectDept());
		model.addAttribute("impList", stdDao.selectImportant());
		model.addAttribute("sttList", stdDao.selectStatus());
		model.addAttribute("tskList", stdDao.selectTaskType());  
	}
	
	@ModelAttribute("methodType")
	public String methodName() {
		return "put";
	}
	
	//일감 수정 폼
	@GetMapping("/project/editTask/{task_code}/{project_code}")
	public String editProject(@PathVariable String task_code, Model model, HttpSession session, @ModelAttribute(name="projectCommon") ProjectVO projectVO,
			@PathVariable String project_code) {
		attibuteSetting(model);
		
		TaskVO vo = service.selectTask(task_code);
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser");
//		PJ_RgroupVO pj_rgroupVO = service.selectProjectMembers(projectVO.getProject_code());
		
		model.addAttribute("task", vo);
		model.addAttribute("authUser", employeeVO);
		model.addAttribute("project", projectVO);
//		model.addAttribute("rgroupList", pj_rgroupVO);
		model.addAttribute("state","updateTask");
		
		return "newTask.project";
	}
	
	//일감 수정
	@PutMapping(value="/project/updateTask", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String update(
		@Valid @ModelAttribute("task") TaskVO task, 
		BindingResult errors, Model model,
		RedirectAttributes redirectAttributes
		, @RequestParam String prg_code, HttpSession session
	){
		EmployeeVO emp = (EmployeeVO)session.getAttribute("authUser");
		String goPage = null;
		String message = null;
		if (!errors.hasErrors()) {
			
			task.setEmp_code_task(emp.getEmp_code());
			task.setPj_memcode(service.selectPJ_Member(task));
			System.out.println("@@"+task.toString());
			System.out.println("##prg_code"+service.selectPJ_Member(task));
			ResultState result = service.updateTask(task);
			switch (result) {
			case FAIL:
				message = "수정에 실패하였습니다.";
				redirectAttributes.addFlashAttribute("task", task);
				goPage = "redirect:/project/editTask/"+task.getTask_code()+"/"+task.getProject_code();
				break;
			default: // OK
				goPage = "redirect:/project/eachtask/"+task.getTask_code()+"/"+task.getProject_code();
				break;
			}
		} else {
			goPage = "redirect:/project/editTask/"+task.getTask_code()+"/"+task.getProject_code();
			redirectAttributes.addFlashAttribute("task", task);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.board", errors);
		}

		model.addAttribute("message", message);

		return goPage;
		
	}
}
