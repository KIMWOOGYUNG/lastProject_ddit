package kr.or.ddit.community.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.community.service.IBoardService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller
public class CommunityController {
	
	@Inject
	IBoardService service;
	
	@GetMapping(value = "/board/boardList/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<BoardVO> ajaxForlist(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage, SearchVO searchVO,
			Model model, HttpSession session){
		communityList(currentPage, searchVO, model, session);

		return (PagingVO<BoardVO>) model.asMap().get("pagingVO");
	}
	
	@GetMapping("/board/boardlist/all")
	public String communityList(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			SearchVO searchVO, Model model, HttpSession session) {
		
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser"); // 회원정보
		PagingVO<BoardVO> pagingVO = new PagingVO<>();
		BoardVO board = new BoardVO();
		board.setEmp_code(employeeVO.getEmp_code());
		
		pagingVO.setSearchVO(searchVO);
		pagingVO.setDetailSearch(board);
		pagingVO.setCurrentPage(currentPage);
		
		int totalRecord = service.selectBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<BoardVO> boardList = service.selectBoardList(pagingVO);
		pagingVO.setDataList(boardList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "commuList.community";
	}
	
	 
}