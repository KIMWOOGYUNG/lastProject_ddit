package kr.or.ddit.hr_admin.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.dao.IEmpinfoStandardDAO;
import kr.or.ddit.hr_admin.service.IAdminTeamService;
import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.TeamVO;

@Controller
public class AdminTeamController {

	@Inject
	IAdminTeamService service;
	
	@Inject
	private IEmpinfoStandardDAO infoDAO;
	
	@GetMapping(value="/hr/teammanage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<TeamVO> ajaxForlist(
		@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
		SearchVO searchVO, Model model
		){
		adminteamList(currentPage, searchVO, model);
		return (PagingVO<TeamVO>) model.asMap().get("pagingVO");
	}
	
	@GetMapping("/hr/teammanage")
	public String adminteamList(@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			SearchVO searchVO, Model model) {
		PagingVO<TeamVO> pagingVO = new PagingVO<>(5,3);
		pagingVO.setSearchVO(searchVO);
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = service.selectTeammanageCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<TeamVO> teamList = service.selectTeammanageList(pagingVO);
		pagingVO.setDataList(teamList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "AdminTeamManage.hr";
	}
	
	//팀 삭제(체크박스)
	@PostMapping("/hr/employer/deleteteam")
	public String deleteteam(@RequestParam String team_code, Model model, HttpSession session) {
	
		if(team_code.contains(",")) {
			String[] splited = team_code.split(",");
			for(int i = 0; i < splited.length; i++) {
				service.deleteteam(splited[i]);
			}
		}else {
			service.deleteteam(team_code);
		}
		return "AdminTeamManage.hr";
	}
	
	
	
	@PostMapping(value = "/hr/employer/teamenroll" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String teamenroll(@Valid @ModelAttribute("team") TeamVO team, Errors errors, Model model, HttpSession session) {
		System.out.println(team.toString());
//		DepartmentVO department = (DepartmentVO) session.getAttribute();
//		depart.setDept_code(department.getDept_code());
		 
		String goPage = null;
		String message = null;
		if(!errors.hasErrors()) {
			ResultState result = service.insertTeam(team);
			System.out.println(result);
			switch (result) {
			case FAIL:
				goPage = "AdminTeamEnroll.hr";
				message = "다시 입력하세요";
				break;

			default:
				goPage = "AdminTeamManage.hr";
				message = "insert성공";
				break;
			}
			
		}else {
			System.out.println(errors.toString());
			goPage = "AdminTeamEnroll.hr";
		}
		
		model.addAttribute("message", message);
		
		return goPage;
	}
	
	
	
	
}
