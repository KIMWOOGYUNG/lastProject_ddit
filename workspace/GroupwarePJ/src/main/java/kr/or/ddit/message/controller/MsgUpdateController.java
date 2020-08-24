package kr.or.ddit.message.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.message.service.IMessageService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.SearchVO;

@Controller
public class MsgUpdateController {
	@Inject
	IMessageService service;
	
	
	//중요보관함으로 이동
		@PostMapping(value = "/note/importantnote") 
		public String updateImportnote(  
		@RequestBody Map<String,List<String>> dataMap, SearchVO searchVO, Model model, HttpSession session,  Errors error
					){
			EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
			String goPage = null;
			String message = null;
			List<String> msg_code = dataMap.get("msg_code");
			if(!error.hasErrors()) {
				ResultState result=null;
				for(String code : msg_code) {
					MessageVO tempVO= service.selectmsg(code);
					MessageVO vo = new MessageVO();
					if(tempVO.getEmp_receiver().equals(empVO.getEmp_code())){
						vo.setMsg_code(code);
						vo.setEmp_receiver(empVO.getEmp_code());
						vo.setMsg_receiver_important("y");
					}else if(tempVO.getEmp_sender().equals(empVO.getEmp_code()) ){
						vo.setMsg_code(code);
						vo.setEmp_sender(empVO.getEmp_code());
						vo.setMsg_sender_important("y");
					}
					result = service.updateImportant(vo);
				}
				switch(result) {
				case FAIL :
					goPage="importantnote.note";
					message="다시 이동버튼을 눌러주세요";
					break;
					
					default:
						goPage="redirect:/note/importantnote";
						message="이동이 완료되었습니다.";
				}
			}else {
				goPage="importantnote.note";
			}
			model.addAttribute("message", message);
			return goPage;
		}	
		
		////중요보관함에서 전체쪽지 리스트로 가기 
		@PostMapping(value = "/note/{pos}") 
		@ResponseBody
		public String updateEntirenote(  
		@RequestBody Map<String,List<String>> dataMap, SearchVO searchVO, Model model, HttpSession session,  Errors error
					){
			EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
			String goPage = null;
			String message = null;
			List<String> msg_code = dataMap.get("msg_code");
			if(!error.hasErrors()) {
				ResultState result=null;
				for(String code : msg_code) {
					MessageVO tempVO= service.selectmsg(code);
					MessageVO vo = new MessageVO();
					if(tempVO.getEmp_receiver().equals(empVO.getEmp_code())){
						vo.setMsg_code(code);
						vo.setEmp_receiver(empVO.getEmp_code());
						vo.setMsg_receiver_important("n");
					}else if(tempVO.getEmp_sender().equals(empVO.getEmp_code()) ){
						vo.setMsg_code(code);
						vo.setEmp_sender(empVO.getEmp_code());
						vo.setMsg_sender_important("n");
					}
					result = service.updateImportant(vo);
				}
				switch(result) {
				case FAIL :
					goPage="importantnote.note";
					message="다시 이동버튼을 눌러주세요";
					break;
					
					default:
						goPage="redirect:/note/entirenote{pos}";
						message="이동이 완료되었습니다.";
				}
			}else {
				goPage="entirenote.note";
			}
			model.addAttribute("message", message);
			return goPage;
		}	
		

}
