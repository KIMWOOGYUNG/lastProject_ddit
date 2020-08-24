package kr.or.ddit.approval.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.approval.service.IApprovalService;
import kr.or.ddit.vo.DraftVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller
@RequestMapping("approval")
public class TotalDraftManagementController {
	
	@Inject
	IApprovalService service;
	
	@GetMapping("entiremanage")
	public String printentireList(Model model) {
		String goPage = "totalList.approval";
//			System.out.println("cate값"+cate);
//		if(cate.equals("my")) {
//			model.addAttribute("title", "내가 쓴 기안서");
//		}else if(cate.equals("temp")){
//			model.addAttribute("title", "임시보관함");
//		}else if(cate.equals("delete")){
//			model.addAttribute("title", "삭제함");
//		}else {
//			//아무것도 아닐경우
//		}
		return goPage;
	}
	
	@GetMapping(value = "entiremanage/{state}" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<DraftVO> ajaxSendDate(Model model,@PathVariable(name = "state")String state,HttpSession httpSession
			,@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			 SearchVO searchVO){
		printdata(model,state,httpSession,currentPage,searchVO);
		return (PagingVO<DraftVO>) model.asMap().get("pagingVO");
	}
	
	@GetMapping("entiremanage/{state}")
	public String printdata(Model model,@PathVariable(name = "state")String state,HttpSession httpSession
			,@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			 SearchVO searchVO) {
		String goPage = "totalList.approval";
		EmployeeVO employeeVO = (EmployeeVO) httpSession.getAttribute("authUser");
		model.addAttribute("state", state);
		PagingVO<DraftVO> pagingVO = new PagingVO<DraftVO>();
		DraftVO detailSearch = makeDraftSearchVo(searchVO);
		pagingVO.setDetailSearch(detailSearch);
		pagingVO.setCurrentPage(currentPage);
		
		
		detailSearch.setEmp_code(employeeVO.getEmp_code());
		int totalRecord = service.getDraftCount(pagingVO, state);
		pagingVO.setTotalRecord(totalRecord);
		List<DraftVO> dataList = service.getDraftList(pagingVO, state);
		pagingVO.setDataList(dataList);
		
		
		model.addAttribute("pagingVO", pagingVO);
		
		return goPage;
	}
	
	private DraftVO makeDraftSearchVo(SearchVO searchVO) {
		DraftVO draftVO = new DraftVO();
		String type = searchVO.getSearchType();
		
		if(!StringUtils.isBlank(type)) {
			String data = searchVO.getSearchWord();
			if("no".equals(type)) {
				draftVO.setDraft_code(data);
			}else if("title".equals(type)){
				draftVO.setDraft_title(data);
			}else if("state".equals(type)){
				draftVO.setDraft_stat(data);
			}
		}
		
		return draftVO;
	}
}
