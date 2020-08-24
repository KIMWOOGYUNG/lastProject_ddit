package kr.or.ddit.att_admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.att_admin.dao.IAdminAttDAO;
import kr.or.ddit.att_admin.service.IAdminAttService;
import kr.or.ddit.vo.Time_AttendVO;

@Controller
@RequestMapping("/hr/att/monthlyList")
public class AttMonthlyListController {
	@Inject
	IAdminAttService service;
	@Inject
	IAdminAttDAO dao;
	
	@GetMapping
	public String goPage() {
		return "attMonthlyList.hr";
		
	}
	@PostMapping
	@ResponseBody
	public Map<String,Object> attmontlyList(
			@RequestParam(required = false)String selectedYear,
			@RequestParam(required = false)String selectedMonth
			){
		Map<String, Object> mp = new HashMap<String, Object>();
		Time_AttendVO attVO = new Time_AttendVO();
		attVO.setSelectedYear(selectedYear);
		attVO.setSelectedMonth(selectedMonth);
		List<Time_AttendVO> list = service.readAttMonthlyList(attVO);
		mp.put("data",list);
		return mp;
	}
}
