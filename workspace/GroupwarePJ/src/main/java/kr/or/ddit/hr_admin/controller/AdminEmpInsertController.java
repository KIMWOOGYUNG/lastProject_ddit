package kr.or.ddit.hr_admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.dao.IEmpinfoStandardDAO;
import kr.or.ddit.hr_admin.service.IAdminEmployService;
import kr.or.ddit.hr_admin.service.IImageAttatchService;
import kr.or.ddit.login_logout.service.AzurePersonService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Image_AttatchVO;
/**
 * 
 * @author 작성자명
 * @since 2020. 7. 23
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2020. 7. 20      박기완       최초작성
 * 2020. 7. 22      강현철       수정 및 보완 
 * 2020. 7. 23      박혜진       얼굴인식 파트 추가
 * 
 * Copyright (c) 2020 by DDIT All right reserved
 * </pre>
 */
@Controller
public class AdminEmpInsertController {
	
	@Inject
	private IEmpinfoStandardDAO infoDAO;
	@Inject
	private IAdminEmployService service;
	@Inject
	private IImageAttatchService imageservice;
	@Inject
	private AzurePersonService personService;
	
	@Value("#{appInfo.attatchPath}")
	String attatchPath;
	@Value("#{appInfo.attatchPath}")
	File saveFolder;

	@ModelAttribute("currentAction")
	private String attributeSetting(Model model) {
		model.addAttribute("departnm", infoDAO.selectDepartname());
		model.addAttribute("teamnm", infoDAO.selectTeamname());
		model.addAttribute("positionnm", infoDAO.selectPosition());
		model.addAttribute("jobnm", infoDAO.selectJobtitle());
		return "/hr/employer/empenroll";
	}
	//사원 등록시 사원코드 보이기
	@GetMapping("/hr/employer/empenroll")
	public String form(Model model) {
		String emp_pk = service.selectCode();
		model.addAttribute("emp_pk", emp_pk);
		attributeSetting(model);
		return "AdminEmpEnroll.hr";
	}
	
	@PostMapping(value = "/hr/employer/empenroll" ,consumes = {"multipart/form-data"})
	public String empenroll(@Valid @ModelAttribute("employee") EmployeeVO employeeVO, Errors errors, Model model, HttpSession session
			,@RequestParam(required = false)MultipartFile img2,
			@RequestParam(required = false)MultipartFile img3) throws IOException {
		String goPage = null;
		String message = null;
//		String emp_code = employeeVO.getEmp_code();
//		String personid = (String) createPersonInGroup(emp_code);
//		employeeVO.setPersonid(personid);
		
		if(!errors.hasErrors()) {
			ResultState result = service.insertEmp(employeeVO);
			System.out.println(result);
			switch (result) {
			case FAIL:
				goPage = "AdminEmpEnroll.hr";
				message = "다시 입력하세요";
				break;
			default:
				MultipartFile img1 = employeeVO.getImg1();
				if(img1 != null) { 
					sendImage(img1,employeeVO.getEmp_code(),"IMG300");
				}
				if(img2 != null) { 
					sendImage(img2,employeeVO.getEmp_code(),"IMG200");		
				}
				if(img3 != null) { 
					sendImage(img3,employeeVO.getEmp_code(),"IMG100");
				}
				goPage = "AdminEmpManage.hr";
				message = "insert성공";
				break;
			}
		}else {
			System.out.println(errors.toString());
			goPage = "AdminEmpEnroll.hr";
		}
		model.addAttribute("message", message);
		return goPage;
	}
	
//	@GetMapping("/hr/employer/empenroll")
//	public String download(@PathVariable(required = true) String emp_attcode, Model model) {
//		Image_AttatchVO attatch = imageservice.insertImage(emp_attcode);
//	
//		model.addAttribute("attatch" , attatch);
//		return "ImageDownloadView";
//	}
	
	//이미지처리
	private ResultState sendImage(MultipartFile multipartFile,String emp_code,String img_catag ) {
		if(StringUtils.isBlank(multipartFile.getOriginalFilename()))return ResultState.OK;
		Image_AttatchVO vo = new Image_AttatchVO();
		vo.setRealFile(multipartFile);
		vo.setEmp_code(emp_code);
		vo.setImg_catag(img_catag);
		vo.setFile_path(attatchPath);
		ResultState state = service.insertEmpImage(vo);
		if(state==ResultState.OK) {
			try {
				multipartFile.transferTo(new File(saveFolder, vo.getSave_name()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return state;
	}
}
