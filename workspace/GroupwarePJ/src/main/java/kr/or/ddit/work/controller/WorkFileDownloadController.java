package kr.or.ddit.work.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.or.ddit.approval.service.IApprovalService;
import kr.or.ddit.vo.CommonsAttatchFileVO;
import kr.or.ddit.vo.Image_AttatchVO;
import kr.or.ddit.vo.Report_AttVO;
import kr.or.ddit.vo.WorkLog_AttatchVO;
import kr.or.ddit.work.service.IMyReportService;
import kr.or.ddit.work.service.IMyWorkLogService;

@Controller
public class WorkFileDownloadController {
	@Inject
	private IMyWorkLogService service;
	
	@Inject
	private IMyReportService reportservice;
	
	@Inject
	IApprovalService apprService;
	
	@GetMapping("/work/file/{wl_attcode}")
	public String download(@PathVariable(required = true) String wl_attcode, Model model) {
		WorkLog_AttatchVO attatch = service.downloadAttatch(wl_attcode);
		
		model.addAttribute("attatch", attatch);
		
		return "worklogDownloadView";
	}

	@GetMapping("/report/file/{report_attcode}")
	public String reportdownload(@PathVariable(required = true) String report_attcode, Model model) {
		Report_AttVO attatch = reportservice.downloadAttatch(report_attcode);
		
		model.addAttribute("attatch", attatch);
		
		return "reportDownloadView";
	}
	
	@GetMapping("/emp/file/{emp_attcode}")
	public String empdownload(@PathVariable(required = true) String emp_attcode, Model model) {
		Image_AttatchVO image_AttatchVO = apprService.getImageAttatch(emp_attcode);
		CommonsAttatchFileVO vo =  image_AttatchVO.sendData();
		model.addAttribute("attatch", vo);
		
		return "attachDownloadView";
	}
}
