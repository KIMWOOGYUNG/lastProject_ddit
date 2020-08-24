package kr.or.ddit.hr_admin.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.dao.IEmpinfoStandardDAO;
import kr.or.ddit.hr_admin.service.IAdminDepartService;
import kr.or.ddit.vo.DepartmentVO;



@Controller
public class AdminDepInsertController {

	@Inject
	private  IAdminDepartService service;
	
	@Inject
	private IEmpinfoStandardDAO infoDAO;
	
	@ModelAttribute("currentAction")
	private String attributeSetting(Model model) {
		model.addAttribute("departnm", infoDAO.selectDepartname());
		return "/hr/employer/depenroll";
				
	}
	
	
	@PostMapping(value = "/hr/employer/depenroll" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String depenroll(@Valid @ModelAttribute("department") DepartmentVO depart, Errors errors, Model model, HttpSession session) {
		System.out.println(depart.toString());
//		DepartmentVO department = (DepartmentVO) session.getAttribute();
//		depart.setDept_code(department.getDept_code());
		 
		String goPage = null;
		String message = null;
		if(!errors.hasErrors()) {
			ResultState result = service.insertdept(depart);
			System.out.println(result);
			switch (result) {
			case FAIL:
				goPage = "AdminDepEnroll.hr";
				message = "다시 입력하세요";
				break;

			default:
				goPage = "AdminDepManage.hr";
				message = "insert성공";
				break;
			}
			
		}else {
			System.out.println(errors.toString());
			goPage = "AdminDepEnroll.hr";
		}
		
		model.addAttribute("message", message);
		
		return goPage;
	}
	
	
	
}
