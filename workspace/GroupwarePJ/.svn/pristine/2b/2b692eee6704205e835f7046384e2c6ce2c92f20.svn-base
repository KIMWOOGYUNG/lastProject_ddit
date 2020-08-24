package kr.or.ddit.work.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.PSource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.WorkLogVO;
import kr.or.ddit.vo.Work_ReportVO;
import kr.or.ddit.work.service.IMyReportService;

@Controller
public class MyReportReadController {

	@Inject
	private IMyReportService service;
	
	
	@GetMapping(value = "/work/workreport/myworkreport/report", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<WorkLogVO> ajaxForlistday(@RequestParam(name="page", required = false, defaultValue = "1") int currentPage, SearchVO searchVO, Model model,HttpSession session){
		reportList(currentPage, searchVO, model,session);
		return (PagingVO<WorkLogVO>) model.asMap().get("pagingVO");
	}
	
	@GetMapping("/work/workreport/myworkreport/report")
	public String reportList(@RequestParam(name = "page", required = false, defaultValue = "1")int currentPage, SearchVO searchVO, Model model,HttpSession session) {
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser");
		
		String emp_code = employeeVO.getEmp_code();
		String position_code =employeeVO.getPosition_code();
		
		PagingVO<Work_ReportVO> pagingVO = new PagingVO<>();
		Work_ReportVO reportVO = new Work_ReportVO();
		reportVO.setEmp_reporter(emp_code);
		
		pagingVO.setDetailSearch(reportVO);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSearchVO(searchVO);
		int totalRecord = service.readReportCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<Work_ReportVO> worklogListday = service.readReportList(pagingVO);
		pagingVO.setDataList(worklogListday);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "myreportList.work";		
	}
	
	@GetMapping(value = "/work/workreport/reportview/{report_code}")
	public String reportView(@PathVariable(required = true) String report_code, Model model) {
		Work_ReportVO report = service.readReport(report_code);
		
		model.addAttribute("report", report);
		
		return "myreportView.work";
	}
	
//---------------------------------------------------------------------------------------------------------------
	// 받은 업무보고
	@GetMapping(value = "/work/workreport/receivereport", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<WorkLogVO> ajaxForlist(@RequestParam(name="page", required = false, defaultValue = "1") int currentPage, SearchVO searchVO, Model model, HttpSession session){
		receivereportList(currentPage, searchVO, model, session);
		return (PagingVO<WorkLogVO>) model.asMap().get("pagingVO");
	}
	
	@GetMapping("/work/workreport/receivereport")
	public String receivereportList(@RequestParam(name = "page", required = false, defaultValue = "1")int currentPage, SearchVO searchVO, Model model, HttpSession session) {
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser");
		
		String emp_code = employeeVO.getEmp_code();
		String position_code = employeeVO.getPosition_code();
		
		PagingVO<Work_ReportVO> pagingVO = new PagingVO<>();
		Work_ReportVO reportVO = new Work_ReportVO();
		reportVO.setEmp_target(emp_code);
		
		pagingVO.setDetailSearch(reportVO);
		pagingVO.setSearchVO(searchVO);
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = service.readReportCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<Work_ReportVO> worklogListday = service.readReportList(pagingVO);
		pagingVO.setDataList(worklogListday);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "receivereportList.work";
	}
	
	@GetMapping(value = "/work/workreport/receiveview/{report_code}")
	public String receiveView(@PathVariable(required = true) String report_code, Model model) {
		Work_ReportVO receive = service.readReport(report_code);
		
		model.addAttribute("receive", receive);
		
		return "receivereportView.work";
	}
	
	@PostMapping(value = "/work/workreport/receivereport/{report_code}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String,Object> receiveOK(@PathVariable String report_code, @ModelAttribute("reportVO") Work_ReportVO reportVO ) {
		
		String goPage = "/work/workreport/receiveview/"+report_code;
		
		Map<String,Object> model = new HashMap<>();
		
		model.put("goPage", goPage);
		
		ResultState result = service.completeReceiveReport(reportVO);
		
		model.put("result", result);
		
		switch (result) {
		case FAIL:
			model.put("message", "승인을 실패하셨습니다.");
			break;
		default:
			model.put("message", "승인에 성공하셨습니다.");
			break;
		}
		
		return model;
	}
	
}