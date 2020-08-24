package kr.or.ddit.project.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.project.service.IProjectListService;
import kr.or.ddit.project.service.ITaskListService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.TaskVO;

@Controller
public class ProjectTaskController {
	
	@Inject
	ITaskListService service;
	@Inject
	IProjectListService pj_service;
	
	@GetMapping(value="/project/tasklist/{project_code}/{whoseTask}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<TaskVO> ajaxForlist(@PathVariable(name="project_code") String project_code, @PathVariable(name="whoseTask") String whoseTask,
		@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
		SearchVO searchVO, Model model, HttpSession session
		){
		taskList(project_code, whoseTask, currentPage, searchVO, model, session);
		return (PagingVO<TaskVO>) model.asMap().get("pagingVO");
	}
	
	//일감 목록
	@GetMapping("/project/tasklist/{project_code}/{whoseTask}")
	public String taskList(@PathVariable(name="project_code") String project_code, @PathVariable(name="whoseTask") String whoseTask,
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			SearchVO searchVO, Model model, HttpSession session) {

		EmployeeVO employeeVO= (EmployeeVO) session.getAttribute("authUser");
		PagingVO<TaskVO> pagingVO = new PagingVO<>();
		TaskVO detailSearch = new TaskVO();
		String title = null;
		
		 if(project_code.contains("PJ")) {					//선택한 내 프로젝트
			 String project_name = pj_service.selectProject(project_code).getProject_name();
				String emp_code = employeeVO.getEmp_code();
				detailSearch.setProject_code(project_code);
				
				if("allTask".equals(whoseTask)) {	//모든 일감
					whoseTask = "allTask";
					title = project_name + " 전체 일감";
				}else if("myTask".equals(whoseTask) ) {	//내 일감
					whoseTask = "myTask";
					title = project_name + " 내 일감";
					detailSearch.setEmp_code_task(emp_code);
				}
				pagingVO.setDetailSearch(detailSearch);
			}
		 else if("allProject".equals(project_code)){		//모든 프로젝트 
			model.addAttribute("project_code", "allProject");
			
			if("allTask".equals(whoseTask)) {	//모든 일감
				whoseTask = "allTask";
				title = "전체 프로젝트 전체 일감";
				pagingVO.setDetailSearch(detailSearch);
				
			}else if("myTask".equals(whoseTask) ) {	//내 일감
				whoseTask = "myTask";
				title = "전체 프로젝트 내 일감";
				String emp_code = employeeVO.getEmp_code();
				detailSearch.setEmp_code_task(emp_code);
				pagingVO.setDetailSearch(detailSearch);
			}  
		 }
	
		
		pagingVO.setSearchVO(searchVO);
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = service.selectTaskCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<TaskVO> taskList = service.selectTaskList(pagingVO);
		pagingVO.setDataList(taskList);
		
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("project_code", project_code);
		model.addAttribute("whoseTask", whoseTask);
		model.addAttribute("title", title);
		
		return "taskList.project";
	}
	
	
	//일감 상세보기
	@GetMapping("/project/eachtask/{task_code}/{project_code}")
	public String projectDetail(@PathVariable String task_code, Model model, HttpSession session, @PathVariable String project_code) {
		EmployeeVO employeeVO = (EmployeeVO)session.getAttribute("authUser");
		TaskVO vo = service.selectTask(task_code);
		model.addAttribute("task", vo);
		model.addAttribute("authUser",employeeVO);
		
		return "taskDetail.project";
	}
	
	//일감 삭제 (체크박스)
		@PostMapping("/project/delTask")
		public String delProject(@RequestParam String task_code, Model model, HttpSession session) {
			String goPage = null;
			ResultState result = null;
			TaskVO taskVO = new TaskVO();
			if(task_code.contains(",")) {
				String[] splited = task_code.split(",");
				for(int i = 0; i < splited.length; i++) {
					taskVO = service.selectTask(splited[i]);
				}
			}else {
				taskVO = service.selectTask(task_code);
			}
			result = service.deleteTask(taskVO);
			switch(result) {
			case FAIL : 
				goPage = "redirect:/project/eachtask/"+task_code;
			default : 
				goPage = "taskList.project";
			}
			EmployeeVO employeeVO= (EmployeeVO) session.getAttribute("authUser");
			model.addAttribute("who", employeeVO.getEmp_code());
			return goPage;
		}
}
