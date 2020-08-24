package kr.or.ddit.work.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.WorkLogVO;
import kr.or.ddit.work.service.IMyWorkLogService;

@Controller
public class TeamDiaryReadController {
	
	@Inject
	private IMyWorkLogService service;
	
	
	@GetMapping(value = "/work/teamwork/{pos}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<WorkLogVO> ajaxForlistday(@RequestParam(name="page", required = false, defaultValue = "1") int currentPage, SearchVO searchVO, Model model, HttpSession session, @PathVariable(name = "pos") String pos){
		daiaryList(currentPage, searchVO, model, session, pos);
		return (PagingVO<WorkLogVO>) model.asMap().get("pagingVO");
	}
	
	@GetMapping("/work/teamwork/{pos}")
	public String daiaryList(@RequestParam(name = "page", required = false, defaultValue = "1")int currentPage, SearchVO searchVO, Model model, HttpSession session, @PathVariable(name = "pos") String pos) {
		String goPage = null;
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser");
		
		String team_code = employeeVO.getTeam_code();
		String position_code = employeeVO.getPosition_code();
		
		WorkLogVO worklog = new WorkLogVO();
		
		worklog.setEmp_code(employeeVO.getEmp_code());
		
		if(pos.equals("diary")) {
			goPage = "teamdiaryList.work";
		}else if(pos.equals("teamtrashbasket")){
			worklog.setWl_del("Y");
			goPage = "teamtrashbasket.work";
		}
		
		PagingVO<WorkLogVO> pagingVO = new PagingVO<>();
//		pagingVO.setSearchVO(searchVO);
		
		pagingVO.setDetailSearch(worklog);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSearchVO(searchVO);

		int totalRecord = service.readWorkLogCountteam(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<WorkLogVO> worklogListday = service.readWorkLogListteam(pagingVO);
		pagingVO.setDataList(worklogListday);
		
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("wl_team", "teamwork");
		return goPage;		
	}
	
	@GetMapping(value = "/work/teamwork/diaryView/{wl_code}")
	public String diaryView(@PathVariable(required = true)String wl_code, Model model) {
		WorkLogVO worklog = service.readWorkLogteam(wl_code);
		
		model.addAttribute("worklog", worklog);
		
		return "mydaydiaryView.work";
	}
	
}