package kr.or.ddit.message.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.message.service.IMessageService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller
public class MsgController {
	@Inject
	IMessageService service;
	
	@GetMapping("/note/noteList")
	public String mymsg() {
		return "noteList.note";
	}
	@GetMapping(value = "/note/{pos}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) //
	@ResponseBody
	public PagingVO<MessageVO> ajaxForlist(@PathVariable(name = "pos") String pos,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			HttpSession session, Model model,SearchVO searchVO
			){
		entirenote(pos, currentPage, session, model,searchVO);
				return (PagingVO<MessageVO>) model.asMap().get("pagingVO");
	}
	
	@GetMapping("/note/{pos}")//전체쪽지리스트 
	public String entirenote(@PathVariable(name  = "pos") String pos,
			@RequestParam(name = "page",required =false,defaultValue = "1")
	int currentPage, HttpSession session, Model model,SearchVO searchVO) {
		PagingVO<MessageVO> pagingVO = new PagingVO<>();
		pagingVO.setSearchVO(searchVO);
		EmployeeVO empVO=(EmployeeVO) session.getAttribute("authUser");
		MessageVO msgVO= new MessageVO();
		if("entirenote".equals(pos)) {
			msgVO.setEmp_receiver(empVO.getEmp_code());
			msgVO.setEmp_sender(empVO.getEmp_code());
			model.addAttribute("title", "전체 쪽지함");
		}else if("receivenote".equals(pos)) {
			msgVO.setEmp_receiver(empVO.getEmp_code());
			model.addAttribute("title", "수신쪽지함");
		}else if("sendnote".equals(pos)) {
			msgVO.setEmp_sender(empVO.getEmp_code());
			model.addAttribute("title", "발신쪽지함");
		}
		pagingVO.setDetailSearch(msgVO);
		pagingVO.setCurrentPage(currentPage);
		
		int totalRecord = service.selectMessageCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<MessageVO> dataList = service.msgList(pagingVO);
		
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO",pagingVO);
		model.addAttribute("pos",pos);
		return "entirenote.note";
	}
//	//상세페이지
	@GetMapping("/note/detailnote/{msg_code}") 
	public String detailnote(@PathVariable(name = "msg_code",required = true)String msg_code,Model model) {
		MessageVO msgVO = service.selectmsg(msg_code);
//		model.addAttribute(msgVO.getEmp_receiver());
		model.addAttribute("msgVO", msgVO);
		return "detailnote.note";
	}
	
	//중요보관함ajax
	@GetMapping(value = "/note/importantnote", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	@ResponseBody
	public PagingVO<MessageVO> ajaxmoveForlist(@Valid @ModelAttribute("msg_code")   @RequestParam(name = "page", required = false, defaultValue = "1")
	int currentPage, MessageVO detailSearch, Model model, HttpSession session){
		importantmsg( currentPage, detailSearch, model, session);
		return (PagingVO<MessageVO>) model.asMap().get("pagingVO");
	}
	//중요보관함 리스트 
	@GetMapping( "/note/importantnote")
	public String importantmsg(@Valid @ModelAttribute("msg_code")   @RequestParam(name = "page", required = false, defaultValue = "1")
	int currentPage, MessageVO detailSearch, Model model, HttpSession session) {
		EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
		PagingVO<MessageVO> pagingVO = new PagingVO<>();
		pagingVO.setDetailSearch(detailSearch);
		String emp_code = empVO.getEmp_code();
		detailSearch.setEmp_receiver(emp_code);
		detailSearch.setEmp_sender(emp_code);
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = service.selectImportCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<MessageVO> empList = service.msgImportantList(pagingVO);
		pagingVO.setDataList(empList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "importantnote.note";
	}
	//삭제쪽지
	@PostMapping("/note/deletenote") 
	public String deletenote(@RequestParam String msg_code, Model model, HttpSession session) {
		if(msg_code.contains(",")) {
			String[] splited = msg_code.split(",");
			for(int i =0; i<splited.length; i++) {
				service.removemsg(msg_code);
			}
		}else {
			service.removemsg(msg_code);
		}
		EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
		model.addAttribute("who",empVO.getMsg_code());
		return "entirenote.note";
		
	}


	
	
	
}