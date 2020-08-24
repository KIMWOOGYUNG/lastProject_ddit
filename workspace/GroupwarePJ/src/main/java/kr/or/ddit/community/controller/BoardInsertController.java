package kr.or.ddit.community.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.community.dao.IBoardDAO;
import kr.or.ddit.community.service.IBoardService;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.EmployeeVO;

@Controller
public class BoardInsertController {
	@Inject
	IBoardService service;
	
	@Inject
	private IBoardDAO dao;
	
	@GetMapping("/board/boardList/insertForm/{pos}")
	public String boardForm(@ModelAttribute("board") BoardVO board, Model model, @PathVariable(name = "pos") String pos) {
		String goPage = null;
		
		model.addAttribute("state", "insertForm");
		model.addAttribute("board_catag", pos);
		model.addAttribute("catagList", dao.selectCatagList());
		
		if(pos.equals("BOD400")) {
			board.setBoard_catag("BOD400");
			goPage = "restaurantForm.community";
		}else if(pos.equals("BOD100")) {
			board.setBoard_catag("BOD100");
			goPage = "boardForm.community";
		}else if(pos.equals("BOD200")){
			board.setBoard_catag("BOD200");
			goPage = "boardForm.community";
		}else if(pos.equals("BOD300")){
			board.setBoard_catag("BOD300");
			goPage = "boardForm.community";
		}else if(pos.equals("BOD500")){
			board.setBoard_catag("BOD500");
			goPage = "boardForm.community";
		}
		
		return goPage;
	}
	
	@PostMapping(value = "/board/boardList/insertForm/{pos}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String insert(
			@Valid@ModelAttribute("board_code") BoardVO board, Errors errors, Model model, HttpSession session
			, @PathVariable(name = "pos") String pos
			) {
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser");
		
		String emp_code = employeeVO.getEmp_code();
		board.setEmp_code(emp_code);
	
		String goPage = null;
		String message = null;
		
		if(!errors.hasErrors()) {
			ResultState result = service.insertBoard(board);
			switch(result) {
			case FAIL:
				if(pos.equals("BOD400")) {
					board.setBoard_catag("BOD400");
					goPage = "restaurantForm.community";
				}else if(pos.equals("BOD100")) {
					board.setBoard_catag("BOD100");
					goPage = "boardForm.community";
				}else if(pos.equals("BOD200")){
					board.setBoard_catag("BOD200");
					goPage = "boardForm.community";
				}else if(pos.equals("BOD300")){
					board.setBoard_catag("BOD300");
					goPage = "boardForm.community";
				}else if(pos.equals("BOD500")){
					board.setBoard_catag("BOD500");
					goPage = "boardForm.community";
				}
				
				message = "다시";
				break;
			default:
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
				break;
			}
		}else {
			System.out.println();
			if(pos.equals("BOD400")) {
				board.setBoard_catag("BOD400");
				goPage = "restaurantForm.community";
			}else if(pos.equals("BOD100")) {
				board.setBoard_catag("BOD100");
				goPage = "boardForm.community";
			}else if(pos.equals("BOD200")){
				board.setBoard_catag("BOD200");
				goPage = "boardForm.community";
			}else if(pos.equals("BOD300")){
				board.setBoard_catag("BOD300");
				goPage = "boardForm.community";
			}else if(pos.equals("BOD500")){
				board.setBoard_catag("BOD500");
				goPage = "boardForm.community";
			}
			
		}
		
		model.addAttribute("message", message);
		model.addAttribute("board_catag", pos);
		model.addAttribute("catagList", dao.selectCatagList());
		
		return goPage;
	}

	
}
