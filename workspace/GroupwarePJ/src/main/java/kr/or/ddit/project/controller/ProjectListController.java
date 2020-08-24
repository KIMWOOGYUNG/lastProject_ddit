package kr.or.ddit.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.service.IAdminEmployService;
import kr.or.ddit.project.service.IProjectListService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PJ_MemberVO;
import kr.or.ddit.vo.PJ_RgroupVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.TaskVO;

@Controller
public class ProjectListController {
	@Inject
	IProjectListService service;
	
	@Inject
	IAdminEmployService emp_service;
	
	@GetMapping(value="/project/projectlist/{who}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<ProjectVO> ajaxForlist(@PathVariable(name="who") String who,
		@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
		SearchVO searchVO, Model model, HttpSession session
		){
		
		projectList(who, currentPage, searchVO, model, session);
		
		return (PagingVO<ProjectVO>) model.asMap().get("pagingVO");
	}
	
	//프로젝트 목록
	@GetMapping("/project/projectlist/{who}")
	public String projectList(@PathVariable(name="who") String who,
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			SearchVO searchVO, Model model, HttpSession session) {
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser");
	
		PagingVO<ProjectVO> pagingVO = new PagingVO<>(9,5);
		
		if("all".equals(who)) {
			model.addAttribute("title", "전체 프로젝트");
			
		}else if("my".equals(who) ) {
			model.addAttribute("title", "내 프로젝트");
			ProjectVO detailSearch = new ProjectVO();
			String emp_code = employeeVO.getEmp_code();
			detailSearch.setEmp_code(emp_code);
			pagingVO.setDetailSearch(detailSearch);
			
		}
				
		pagingVO.setSearchVO(searchVO);
		pagingVO.setCurrentPage(currentPage);
		
		int totalRecord = service.selectProjectCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		//진척도 세팅
		List<ProjectVO> projectList = service.selectProjectList(pagingVO);
		for(int i = 0; i < projectList.size(); i++) {
			ProjectVO temp = projectList.get(i);
			int project_progress = service.selectPJProgress(temp.getProject_code());
			temp.setProject_progress(project_progress);
			projectList.set(i, temp);
		}
		
		pagingVO.setDataList(projectList);
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("who", who);
		
		return "projectList.project";
	}

	
	//프로젝트 상세보기
	@GetMapping("/project/eachproject/{project_code}")
	public String projectDetail(@PathVariable String project_code, Model model, HttpSession session) {
		EmployeeVO emp = (EmployeeVO) session.getAttribute("authUser");
		EmployeeVO empManage = emp_service.selectEmpmanage(emp.getEmp_code());
		ProjectVO vo = service.selectProject(project_code);
		
		//멤버별 진척도 세팅
		List<PJ_RgroupVO> rgroupList = vo.getPj_rgroupList();
		for(int k = 0; k < rgroupList.size(); k++) {
			PJ_RgroupVO rgroup = vo.getPj_rgroupList().get(k);		
				for(int i = 0; i < rgroup.getPj_memberList().size(); i++) {	//rgroupList
					List<PJ_MemberVO> memberList = rgroup.getPj_memberList();						
					
						for(int j = 0; j < memberList.size(); j++) {									
							PJ_MemberVO temp = rgroup.getPj_memberList().get(j);						
							if(temp.getPj_memcode() != null) {
								int member_progress = service.selectTMProgress(temp.getPj_memcode());		
								temp.setPjm_progress(member_progress);
							}
							memberList.set(j, temp);
						}
					rgroup.setPj_memberList(memberList);
				}
				rgroupList.set(k, rgroup);
			
		}
		
		//월별 진척도 차트
		List<Map<String, String>> monthlyProgress = service.selectMonthlyProgress(project_code);
		
		List<String> month = new ArrayList<>();
		List<String> progress = new ArrayList<>();
		
		for(int i = 0; i < monthlyProgress.size(); i++) {
			month.add(monthlyProgress.get(i).get("MONTH"));
			progress.add(String.valueOf(monthlyProgress.get(i).get("PROJECT_PROGRESS")));
		}
		
		//최근 일감
		List<TaskVO> recentTaskList = service.selectRecentTaskList(project_code);
		
		model.addAttribute("empManage",empManage);
		model.addAttribute("recentTaskList", recentTaskList);
		model.addAttribute("month", month);
		model.addAttribute("progress", progress);
		model.addAttribute("project", vo);
		model.addAttribute("who", emp.getEmp_code());
	
		return "projectDetail.project";
	}

	
	//프로젝트 삭제 (체크박스)
	@PostMapping("/project/delProject")
	public String delProject(@RequestParam String project_code, Model model, HttpSession session) {
		String goPage = null;
		ResultState result = null;
		
		EmployeeVO employeeVO= (EmployeeVO) session.getAttribute("authUser");
		model.addAttribute("who", employeeVO.getEmp_code());
		
		if(project_code.contains(",")) {
			String[] splited = project_code.split(",");
			for(int i = 0; i < splited.length; i++) {
				result = service.deleteProject(splited[i]);
			}
		}else {
			result = service.deleteProject(project_code);
		}
		switch(result) {
		case FAIL : 
			goPage = "redirect:/project/eachproject/"+project_code;
		default : 
			goPage = "redirect:/project/projectlist/"+employeeVO.getEmp_code();
		}
		
		return goPage;
	}
	
}

