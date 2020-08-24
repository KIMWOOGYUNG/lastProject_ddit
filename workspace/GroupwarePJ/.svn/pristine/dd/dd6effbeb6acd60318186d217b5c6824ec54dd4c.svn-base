package kr.or.ddit.work.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.WorkLogVO;
import kr.or.ddit.work.service.IPublicWorkLogService;

@Controller
public class PublicDiaryReadController {
	
	@Inject
	private IPublicWorkLogService service;
	
	// 공용 업무일지
	
	@GetMapping(value = "/work/publicwork/{pos}/{team_code}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<WorkLogVO> ajaxForlistday(@RequestParam(name="page", required = false, defaultValue = "1") int currentPage, 
												@PathVariable(name = "team_code", required = false) String team_code, SearchVO searchVO, Model model, @PathVariable(name = "pos") String pos){
		daydaiaryList(currentPage,team_code, searchVO, model, pos);
		return (PagingVO<WorkLogVO>) model.asMap().get("pagingVO");
	}
	
	@GetMapping("/work/publicwork/{pos}/{team_code}")
	public String daydaiaryList(@RequestParam(name = "page", required = false, defaultValue = "1")int currentPage,
								@PathVariable(name = "team_code", required = false) String team_code, SearchVO searchVO, Model model, @PathVariable(name = "pos") String pos) {
		
		String goPage = null;
		
		PagingVO<WorkLogVO> pagingVO = new PagingVO<>();
		WorkLogVO worklog = new WorkLogVO();
		
		
		if(!team_code.equals("all")) {
			worklog.setTeam_code(team_code);
		}
		
		if(pos.equals("daydiary")) {
			worklog.setWl_catag("WLC100");
			goPage = "publicdaydiaryList.work";
		}else if(pos.equals("weekdiary")) {
			worklog.setWl_catag("WLC200");
			goPage = "publicweekdiaryList.work";
			
		}
		
		pagingVO.setDetailSearch(worklog);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSearchVO(searchVO);
		int totalRecord = service.readWorkLogCountday(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<WorkLogVO> worklogListday = service.readWorkLogListday(pagingVO);
		pagingVO.setDataList(worklogListday);
		
		
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("team_code", team_code);
		
		return goPage;		
	}

	
	
}
