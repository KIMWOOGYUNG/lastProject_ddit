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

import kr.or.ddit.community.dao.IBoardDAO;
import kr.or.ddit.community.service.IBoardService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller
public class BoardReadController {
	
	@Inject
	IBoardService service;
	
	@Inject
	IBoardDAO dao;
	
	@GetMapping(value = "/board/boardList/{pos}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<BoardVO> ajaxForlist(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage, SearchVO searchVO,
			Model model, HttpSession session, @PathVariable(name="pos") String pos){
		boardList(currentPage, searchVO, model, session, pos);

		model.addAttribute("board_catag", pos);
		model.addAttribute("catagList", dao.selectCatagList());
		
		return (PagingVO<BoardVO>) model.asMap().get("pagingVO");
	}
	
	// 게시글 목록
	@GetMapping("/board/boardList/{pos}")
	private String boardList(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			SearchVO searchVO, Model model, HttpSession session, @PathVariable(name = "pos") String pos) {
		String goPage = null;
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser"); // 회원정보
		PagingVO<BoardVO> pagingVO = new PagingVO<>();
		BoardVO board = new BoardVO();
		board.setEmp_code(employeeVO.getEmp_code());
		
//		BOD100	공지사항	Notice
//		BOD200	자유게시판	Freeboard
//		BOD300	사내동호회	Internalclub
//		BOD400	맛집		Restaurant
//		BOD500	마켓		Market 
		
		if(pos.equals("BOD100")) {
			board.setBoard_catag("BOD100");
			goPage = "boardList.community";
		}else if(pos.equals("BOD200")){
			board.setBoard_catag("BOD200");
			goPage = "boardList.community";
		}else if(pos.equals("BOD300")){
			board.setBoard_catag("BOD300");
			goPage = "boardList.community";
		}else if(pos.equals("BOD400")){
			board.setBoard_catag("BOD400");
			goPage = "boardList.community";
		}else if(pos.equals("BOD500")){
			board.setBoard_catag("BOD500");
			goPage = "boardList.community";
		}else {
			
		}
		pagingVO.setSearchVO(searchVO);
		pagingVO.setDetailSearch(board);
		pagingVO.setCurrentPage(currentPage);
		
		int totalRecord = service.selectBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<BoardVO> boardList = service.selectBoardList(pagingVO);
		pagingVO.setDataList(boardList);
		
		System.out.println(boardList);
		
		model.addAttribute("board", board);
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("board_catag", pos);
		model.addAttribute("catagList", dao.selectCatagList());
		
		return goPage;
		
	}
	
	// 상세보기
	@GetMapping("/board/boardList/boardView/{board_code}/{pos}")
	public String boadDetail(@PathVariable(required = true) String board_code, Model model
			, @PathVariable(name = "pos") String pos){
		BoardVO board = service.selectBoard(board_code);
//		board = dao.selectReply(board_code);
		
		String goPage = null;
		
//		model.addAttribute("replyContent", dao.selectReply(board_parent));
		
		if(pos.equals("BOD400")) {
			board.setBoard_catag("BOD400");
			goPage = "restaurantView.community";
		}else if(pos.equals("BOD100")) {
			board.setBoard_catag("BOD100");
			goPage = "boardView.community";
		}else if(pos.equals("BOD200")){
			board.setBoard_catag("BOD200");
			goPage = "boardView.community";
		}else if(pos.equals("BOD300")){
			board.setBoard_catag("BOD300");
			goPage = "boardView.community";
		}else if(pos.equals("BOD500")){
			board.setBoard_catag("BOD500");
			goPage = "boardView.community";
		}

		model.addAttribute("pos", pos);
		model.addAttribute("board", board);
		if(dao.selectReply(board_code) != null) {
			model.addAttribute("reply", dao.selectReply(board_code).getBoard_content());
		}
//		model.addAttribute("replyContent", dao.selectReply(board_code));
		model.addAttribute("catagList", dao.selectCatagList());
		
		return goPage;
	}
	

	

}

