package kr.or.ddit.att_admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.att_admin.dao.IAdminAttDAO;
import kr.or.ddit.att_admin.service.IAdminAttService;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.Com_WorkStdVO;
import kr.or.ddit.vo.StandardVO;

@Controller
@RequestMapping("/hr/att/holiday")
public class AttHolidayController {
	@Inject
	IAdminAttService service;
	
	@Inject
	IAdminAttDAO dao;
	@GetMapping
	public String holidayCalendar(Model model) {
		List<StandardVO> cwsCodes = dao.selectCwsCode();
		model.addAttribute("cwsCodes", cwsCodes);
		String goPage = "attHolidayCalendar.hr";
		return goPage;
	}
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<CalendarVO> holidaySetting(RedirectAttributes redirectAttributes) {
		List<CalendarVO> dataList = new ArrayList<CalendarVO>();
		List<Com_WorkStdVO> comvacaList = service.getComVacaList();
		for(Com_WorkStdVO temp : comvacaList) {
			dataList.add(temp.sendDate());
		}
		return dataList;
	}
	@PostMapping("/update")
	public @ResponseBody ResultState modifyHoliday(String cws_code, String cws_name, 
			String standard_code, String repeat) {
		Com_WorkStdVO vo = new Com_WorkStdVO();
		vo.setCws_catag(standard_code);
			if("yearly".equals(repeat)) {//매년반복되게
				cws_code=cws_code.replace("-", "").substring(4,8);
				vo.setCws_name(cws_name);
				vo.setCws_code(cws_code);
				vo.setCws_etc(repeat); 
			}else { //반복X
				vo.setCws_code(cws_code.replace("-", ""));
				vo.setCws_name(cws_name);
				vo.setCws_etc(""); 
			}
		ResultState result = service.AddHoliday(vo);
		return result;
	}
	
	@PostMapping("/delete")
	public @ResponseBody ResultState deleteHoliday(String cws_code, 
			String standard_code, String repeat, String del ) {
		Com_WorkStdVO vo = new Com_WorkStdVO();
		if(del.equals("y")) { //삭제
			vo.setCws_catag(standard_code);
			vo.setCws_code(cws_code.replace("-", ""));
			vo.setCws_name("");
		}
		ResultState result = service.AddHoliday(vo);
		return result;
	}
}
