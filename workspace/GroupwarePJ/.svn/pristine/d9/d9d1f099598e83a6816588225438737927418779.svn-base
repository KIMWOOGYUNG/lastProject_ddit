package kr.or.ddit.addr.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.addr.service.IaddrService;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.EmployeeVO;

@Controller
public class MyaddressInsertController {
	@Inject
	IaddrService service;
	
	
	

	@PutMapping(value = "/address/myaddress")
	public String insertaddress(@Valid @ModelAttribute AddressVO addressVO, HttpSession session) {
		EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
		addressVO.setEmp_code(empVO.getEmp_code());
		
		service.insertEmp(addressVO);
		
		return "redirect:/address/cusomeraddrList";
		
	}
	
	
	
	
}
