package kr.or.ddit.approval.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.approval.service.IApprovalService;
import kr.or.ddit.vo.Approve_LineVO;
import kr.or.ddit.vo.DraftVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller
@RequestMapping("approval")
public class ApprovalLineController {

	@Inject
	IApprovalService service;
	
//	@GetMapping(value="myapproval/apprline", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public List<Approve_LineVO> getMyApprovalLine(@RequestParam String emp_code){
//		PagingVO<Approve_LineVO> pagingVO = new PagingVO<Approve_LineVO>();
//		pagingVO.setCurrentPage(currentPage);
//		return service.getApprLine(emp_code);
//	}
//			
}
