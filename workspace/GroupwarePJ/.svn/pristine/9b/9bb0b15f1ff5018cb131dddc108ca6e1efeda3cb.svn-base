package kr.or.ddit.approval.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.addr.service.IaddrService;
import kr.or.ddit.approval.service.IApprovalService;
import kr.or.ddit.vo.CommonsAttatchFileVO;
import kr.or.ddit.vo.Draft_AttatchVO;
import kr.or.ddit.vo.Image_AttatchVO;
import kr.or.ddit.vo.Report_AttVO;
import lombok.Getter;



@Controller
@RequestMapping("approval")
public class FIleDownloadController {

	@Inject
	IApprovalService service;
		
	@GetMapping("/download/{position}/{attcode}")
	public String reportdownload(@PathVariable(required = true) String attcode,@PathVariable(required = true) String position, Model model) {
		
		CommonsAttatchFileVO attatch = null;
		if("att".equals(position)) {
			Draft_AttatchVO draft_AttatchVO = service.getDraftAttach(attcode);
			attatch = draft_AttatchVO.sendData();
		}else if("emp".equals(position)) {
			Image_AttatchVO image_AttatchVO = service.getImageAttatch(attcode);
			attatch = image_AttatchVO.sendData();
		}else {
			
		}
		
		model.addAttribute("attatch", attatch);
		
		return "attachDownloadView";
	}
}
