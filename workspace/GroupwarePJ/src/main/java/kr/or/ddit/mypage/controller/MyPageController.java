package kr.or.ddit.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.dao.IAdminEmployDAO;
import kr.or.ddit.hr_admin.dao.IEmpinfoStandardDAO;
import kr.or.ddit.hr_admin.service.IAdminEmployService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Image_AttatchVO;

@Controller
public class MyPageController {

	
	@Inject
	IAdminEmployService service;
	
	@Inject
	IAdminEmployDAO empDAO;
	
	@Inject
	IEmpinfoStandardDAO infoDAO;
	
	@Value("#{appInfo.attatchPath}")
	String attatchPath;
	@Value("#{appInfo.attatchPath}")
	File saveFolder;
	
	@ModelAttribute("currentAction")
	private void attributeSetting(Model model) {
		model.addAttribute("departnm", infoDAO.selectDepartname());
		model.addAttribute("teamnm", infoDAO.selectTeamname());
		model.addAttribute("positionnm", infoDAO.selectPosition());
		model.addAttribute("jobnm", infoDAO.selectJobtitle());
	
	}
	
	@GetMapping("/mypage/{emp_code}")
	public String MyPageView(@PathVariable String emp_code, Model model) {
		String goPage = null;
		
		EmployeeVO 	employeevo = service.selectEmpmanage(emp_code);
		employeevo.settingImage(empDAO.selectEmpImg(emp_code));
		model.addAttribute("employ", employeevo);
		model.addAttribute("methodType","PUT");
		model.addAttribute("currentAction","/hr/employer/detailempinfo/"+emp_code+"/empmodify");

		goPage = "myPage.mypage";
		
		return  goPage;
	}
	
	@PostMapping("/mypage/{emp_code}")
	public String MypageUpdate(@PathVariable(name = "emp_code") String emp_code,
			@ModelAttribute("employ") EmployeeVO employee, 
			BindingResult errors, Model model,
			RedirectAttributes redirectAttributes,@RequestParam(required = false)MultipartFile img1,@RequestParam(required = false)MultipartFile img2,@RequestParam(required = false)MultipartFile img3
			 ) {
		String goPage = null;
		String message = null;
		
		List<Image_AttatchVO> orgList = empDAO.selectEmpImg(emp_code);
		
		Map<String,MultipartFile> changeMap = new HashMap<String, MultipartFile>();
		changeMap.put("IMG300", img1);
		changeMap.put("IMG200", img2);
		changeMap.put("IMG100", img3);
		
		
		for(Image_AttatchVO vo:empDAO.selectEmpImg(emp_code)) {
			if(vo.getImg_catag().equals("IMG100")) {
				setImage(img3, vo.getEmp_attcode());
				changeMap.remove("IMG100");
			}else if(vo.getImg_catag().equals("IMG200")){
				setImage(img2, vo.getEmp_attcode());
				changeMap.remove("IMG200");
			}else if(vo.getImg_catag().equals("IMG300")) {
				setImage(img1, vo.getEmp_attcode());
				changeMap.remove("IMG300");
			}
		}
		
		for(Entry<String, MultipartFile> entry : changeMap.entrySet()) {
			 MultipartFile realFile = entry.getValue();
			 String tag = entry.getKey();
			 sendImage(realFile,emp_code ,tag);
		}
		
		if(!errors.hasErrors()) {
			ResultState result = service.updateEmp(employee);
			switch (result) {
			case FAIL:
				message = "내정보 수정에 실패 했습니다. 잠시 후 다시 시도하세요";
				redirectAttributes.addFlashAttribute("employ", employee);
				goPage = "redirect:/mypage/{emp_code}";
				break;
			default:
				goPage = "redirect:/mypage/{emp_code}";
				break;
			}
		}else {
			goPage = "redirect:/mypage/{emp_code}";
			redirectAttributes.addFlashAttribute("employ", employee);
		}
		
		model.addAttribute("message", message);
		
		
		return goPage;
	}
	
	private ResultState setImage(MultipartFile multipartFile,String emp_attcode) {
		if(StringUtils.isBlank(multipartFile.getOriginalFilename())) return ResultState.OK;
		
		Image_AttatchVO vo = new Image_AttatchVO();
		vo.setRealFile(multipartFile);
		vo.setFile_path(attatchPath);
		vo.setEmp_attcode(emp_attcode);
		ResultState state = service.updateEmpImage(vo);
		
		Image_AttatchVO imgVO =  service.selectImage(emp_attcode);
		deleteBinary(imgVO.getSave_name());
		
		if(state==ResultState.OK) {
			try {
				multipartFile.transferTo(new File(saveFolder, vo.getSave_name()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return state;
	}
	
	private ResultState sendImage(MultipartFile multipartFile,String emp_code,String img_catag) {
		
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
	
	private void deleteBinary(String delAttSaveName) {
		if(delAttSaveName == null)return;
		try {
				FileUtils.forceDelete(new File(saveFolder, delAttSaveName));
		} catch (Exception e) {
//			throw new RuntimeException(e);
		}
	}
	
	
	@PostMapping(value = "mypage/pwCheck/{emp_code}", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String PWChange(@PathVariable(name = "emp_code") String emp_code, String nowPW, String newPW, String newPWCheck) {
		
		System.out.println("111111111111111111111111     "+nowPW +"--"+ newPW+"--" + newPWCheck);
		
		//정규식 (영문(대소문자 구분), 숫자, 특수문자 조합, 9~12자리)
		String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$";
		Matcher matcher = Pattern.compile(pwPattern).matcher(newPW);
//		System.out.println("***********************************************" + matcher.matches());


		String message = null;
		
		EmployeeVO employee = service.selectEmpmanage(emp_code);
		
		if(!nowPW.equals(employee.getEmp_pw())) {
			message = "비밀번호가 일치하지 않습니다.";
			return message;
		}
		
		if(false == matcher.matches()) {
			System.out.println("=====================================================================================================");
			message = "비밀번호는 영문(대소문자 구분), 숫자, 특수문자 조합, 9~12자리로 입력하세요";
			return message;
		}
		
		if(!newPW.equals(newPWCheck)) {
			message = "새비밀번호와 비밀번호 확인이 일치하지 않습니다.";
			return message;
		}
		
		
		employee.setEmp_pw(newPWCheck);
		
	
		ResultState result = service.updateEmp(employee);
		switch (result) {
		case FAIL:
			message = "비밀번호 수정에 실패 했습니다. 잠시 후 다시 시도하세요";
			break;
		default:
			message = "비밀번호가 성공적으로 변경되었습니다.";
			break;
		}
		
		return message;
	}
	
}
