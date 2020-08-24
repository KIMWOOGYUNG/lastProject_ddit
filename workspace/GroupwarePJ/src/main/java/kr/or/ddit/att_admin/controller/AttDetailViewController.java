package kr.or.ddit.att_admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.att_admin.dao.IAdminAttDAO;
import kr.or.ddit.att_admin.service.IAdminAttService;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Time_AttendVO;

@Controller
@RequestMapping("/hr/att/detailList")
public class AttDetailViewController {
 
	@Inject
	IAdminAttService service;
	
	@Inject
	IAdminAttDAO dao;
	
	Time_AttendVO timeAttVO = new Time_AttendVO(); // 포맷맞춰주기
	
	@GetMapping
	public String goAttDetailPage(Model model) {
		List<Map<String, Object>> catagCodeList = dao.selectCatagCode();
		model.addAttribute("catagCodes",catagCodeList);
		return "attDetailList.hr";
	}
	@PostMapping
	@ResponseBody
	public Map<String, Object> detailList(@RequestParam(required = false)String selectedDate1,@RequestParam(required = false)String selectedDate2 ) {
		Map<String, Object> mp = new HashMap<String, Object>();
//		String selectedDate1=dateData.get("selectedDate1");
//		String selectedDate2=dateData.get("selectedDate2");
		timeAttVO.setSelectedDate1(selectedDate1.replace("-", "")); 
		timeAttVO.setSelectedDate2(selectedDate2.replace("-", "")); 
		List<Time_AttendVO> list = service.readAttDetail(timeAttVO);
		mp.put("data", list);
		return mp;
	}
	
	@PostMapping(value = "/update",produces = MediaType.TEXT_PLAIN_VALUE) //근태입력 
	@ResponseBody
	public String updateAtt(String emp_code, String ta_catag_code, String cws_code) {
		timeAttVO.setEmp_code(emp_code);
		timeAttVO.setTa_catag_code(ta_catag_code);
		timeAttVO.setCws_code(cws_code);
		ResultState result = service.AddAttendence(timeAttVO);
		if(ResultState.OK.equals(result)) {
			return "OK";
		}else return "FAIL";
	}
	
	
}
