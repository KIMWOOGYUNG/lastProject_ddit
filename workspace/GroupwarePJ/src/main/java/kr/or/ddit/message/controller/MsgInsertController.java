package kr.or.ddit.message.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.event.MessageEvent;
import kr.or.ddit.hr_admin.service.IAdminDepartService;
import kr.or.ddit.message.dao.IMessageDAO;
import kr.or.ddit.message.service.IMessageService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PushMessageVO;

@Controller
public class MsgInsertController {//쪽지쓰기
	@Inject
	IMessageService service;
	@Inject
	IAdminDepartService deptService;
	@Inject
	IMessageDAO  msgDAO;
	
	@Inject
	WebApplicationContext context;
	
//	@GetMapping("note/writenote")
//	public String writenote() {
//		String goPage="writenote.note";
//		return goPage;
//		
//	}
	
	@GetMapping(value="/note/writenote", produces="application/json;charset=UTF-8")
	@ResponseBody
	public PagingVO<EmployeeVO> ajaxList(@RequestParam(name="page", required=false, defaultValue="1") int currentPage, EmployeeVO detailSearch, Model model) {
		writenote(currentPage, detailSearch, model);
		PagingVO<EmployeeVO> pagingVO = (PagingVO<EmployeeVO>) model.asMap().get("pagingVO");
		return pagingVO;
	}
	
	private void attibuteSetting(Model model){
		model.addAttribute("deptList", deptService.selectDeptList(null));
	}
	
	@GetMapping("/note/writenote")
	public String writenote(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage, EmployeeVO detailSearch, Model model) {
		PagingVO<EmployeeVO> pagingVO = new PagingVO<>();
		pagingVO.setDetailSearch(detailSearch);
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = service.readEmpCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<EmployeeVO> empList = service.selectEmpList(pagingVO);
		pagingVO.setDataList(empList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		attibuteSetting(model);
		
		return "writenote.note";
		
	}

	
	@PostMapping(value = "/note/writenote")
	public String writenote(@Valid @ModelAttribute("writer") MessageVO msgVO,@RequestParam("emp_receivers") String[] emp_receivers ,Errors errors, Model model
			,HttpSession session) {
		System.out.println(msgVO);
		EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
//		String emp_code = empVO.getEmp_kor();
		msgVO.setEmp_sender(empVO.getEmp_code());
		String goPage = null;
		String message = null;
		if(emp_receivers.length >0 && emp_receivers !=null)
			
		if(!errors.hasErrors()) {
			ResultState result = ResultState.SUCCESSES;
				for(String emp_receiver : emp_receivers) {
					msgVO.setEmp_receiver(emp_receiver);
					 result = service.createmsg(msgVO);
				}
			
			switch(result) {
			case FAIL:
				goPage ="writenote.note";
				message ="다시 입력하세요";
				break;
				
				default:
					///push메시지 알림창쪽
					PushMessageVO pushMessageVO = new PushMessageVO();
					pushMessageVO.setTitle(empVO.getEmp_kor()+"님에게서");
					pushMessageVO.setContent("쪽지가 도착하였습니다.");
					pushMessageVO.setReceiver(msgVO.getEmp_receiver());
					pushMessageVO.setType("message");
					MessageEvent event = new MessageEvent(this, pushMessageVO);
					context.publishEvent(event);
					
					goPage="redirect:/note/entirenote";
					message ="쪽지를 보냈습니다.";
				   
			}
		}else {
			goPage="writenote.note";
		}
		model.addAttribute("message", msgVO);
		return goPage;
		
	}
//	@GetMapping("/note/writenote")
//	public List<MessageVO> selectMsg(){
//		List<MessageVO> msgList= service.selectMsgList();
//		return msgList;
//		
//	}
//	@PostMapping
//	public String insertnote(
//			@Validated @ModelAttribute("note") MessageVO msg,
//			BindingResult errors,
//			Model model,
//			@RequestParam(required = false)String currentPage,
//			RedirectAttributes redirectAttributes
//			)throws IllegalStateException, IOException{
//		model.addAttribute("currentAction","/note");
//		String goPage = null;
//		String message=null;
//		if(!errors.hasErrors()) {
//			ResultState result = service.createmsg(msg);
//			switch(result) {
//			case FAIL:
//				message="내용을 작성해주세요";
//				goPage = "note/writenote";
//				break;
//				default:
//					goPage="redirect:/note/"+msg.getEmp_sender();
//					redirectAttributes.addFlashAttribute("lastUpdateNote", msg);
//					break;
//			}
//		}else{
//				goPage="note/writenote";
//			
//		}
//		model.addAttribute("message",message);
//		return goPage;
//
//}
	
}
