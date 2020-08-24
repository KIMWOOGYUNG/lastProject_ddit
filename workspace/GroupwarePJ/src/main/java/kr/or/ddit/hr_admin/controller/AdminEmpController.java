package kr.or.ddit.hr_admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller

public class AdminEmpController {
	
	@Inject
	IAdminEmployService service;
	@Inject
	IEmpinfoStandardDAO infoDAO;
	@Inject
	IAdminEmployDAO empDAO;
	
	@Value("#{appInfo.attatchPath}")
	String attatchPath;
	@Value("#{appInfo.attatchPath}")
	File saveFolder;
	
	
	@GetMapping(value="/hr/employer/entiremanage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<EmployeeVO> ajaxForlist(
		@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
		SearchVO searchVO, Model model
		){
		adminemployList(currentPage, searchVO, model);
		return (PagingVO<EmployeeVO>) model.asMap().get("pagingVO");
	}

	//전 사원 목록
	@GetMapping("/hr/employer/entiremanage")
	public String adminemployList(@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			SearchVO searchVO, Model model) {
		EmployeeVO detailSearch = new EmployeeVO();
		PagingVO<EmployeeVO> pagingVO = new PagingVO<>(10,5);
	
		pagingVO.setDetailSearch(detailSearch);
		pagingVO.setSearchVO(searchVO);
		pagingVO.setCurrentPage(currentPage);

		int totalRecord = service.selectEmpmanageCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<EmployeeVO> empList = service.selectEmpmanageList(pagingVO);
		pagingVO.setDataList(empList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "AdminEmpManage.hr";
	}
	
	
	@GetMapping(value="/hr/employer/retiremanage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<EmployeeVO> ajaxForretirelist(
		@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
		SearchVO searchVO, Model model
		){
		retireempmanage(currentPage, searchVO, model);
		return (PagingVO<EmployeeVO>) model.asMap().get("pagingVO");
	}
	//퇴사자 관리
	@GetMapping("/hr/employer/retiremanage")
	public String retireempmanage(@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
	SearchVO searchVO, Model model) {
		String goPage = "AdminRtrManage.hr";
		
		EmployeeVO detailSearch = new EmployeeVO();
		detailSearch.setRetire_date("y");
		
		PagingVO<EmployeeVO> pagingVO = new PagingVO<>(10,5);
	
		pagingVO.setDetailSearch(detailSearch);
		pagingVO.setSearchVO(searchVO);
		pagingVO.setCurrentPage(currentPage);

		int totalRecord = service.selectEmpmanageCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<EmployeeVO> empList = service.selectEmpmanageList(pagingVO);
		pagingVO.setDataList(empList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return goPage;
	}
	

	
	//사원 이름 클릭 후 사원 상세 정보
	@GetMapping("/hr/employer/detailempinfo/{emp_code}")
	public String detailempmanage(@PathVariable(name = "emp_code") String emp_code, Model model) {
	
		EmployeeVO 	employeevo = service.selectEmpmanage(emp_code);
		employeevo.settingImage(empDAO.selectEmpImg(emp_code));
		model.addAttribute("employ", employeevo);
		model.addAttribute("methodType","PUT");
		model.addAttribute("currentAction","/hr/employer/detailempinfo/"+emp_code+"/empmodify");
		
		
		return "AdminDetailEmp.hr";
	}

	
	//사원 삭제(체크박스)
//	@PostMapping("/hr/employer/deleteemp")
//	public String deleteempinfo(@RequestParam String emp_code, Model model, HttpSession session) {
//		
//		if(emp_code.contains(",")) {
//			String[] splited = emp_code.split(",");
//			for(int i = 0; i < splited.length; i++) {
//				service.deleteEmp(splited[i]);
//			}
//		}else {
//			service.deleteEmp(emp_code);
//		}
//		EmployeeVO employeevo = (EmployeeVO) session.getAttribute("authUser");
//		model.addAttribute("who", employeevo.getEmp_code());
//		return "AdminEmpManage.hr";
//		
//	}
	
	

	
	
//	
//	
//	@GetMapping("form")
//	public String form(@PathVariable(required = true) String emp_code, Model model) {
//		if(!model.containsAttribute("employ")) {
//			EmployeeVO employeevo = service.selectEmpmanage(emp_code);
//			model.addAttribute("employ", employeevo);
//		}
//		return "board/boardForm";
//	}
//	
	
	@ModelAttribute("currentAction")
	private void attributeSetting(Model model) {
		model.addAttribute("departnm", infoDAO.selectDepartname());
		model.addAttribute("teamnm", infoDAO.selectTeamname());
		model.addAttribute("positionnm", infoDAO.selectPosition());
		model.addAttribute("jobnm", infoDAO.selectJobtitle());
	
	}
	
	
	
	//사원 정보 수정
	@PutMapping(value = "/hr/employer/detailempinfo/{emp_code}/empmodify", consumes = "multipart/form-data")
	public String update(
			@PathVariable(name = "emp_code") String emp_code,
		@ModelAttribute("employ") EmployeeVO employeevo, 
		BindingResult errors, Model model,
		RedirectAttributes redirectAttributes,@RequestParam(required = false)MultipartFile img1,@RequestParam(required = false)MultipartFile img2,@RequestParam(required = false)MultipartFile img3
	){
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
		
		
		
		if (!errors.hasErrors()) {
			ResultState result = service.updateEmp(employeevo);
			switch (result) {
			case FAIL:
				message = "쫌따 다시 해보셈.";
				redirectAttributes.addFlashAttribute("employ", employeevo);
				goPage = "redirect:/hr/employer/detailempinfo/{emp_code}";
				break;
			default: // OK
				goPage = "redirect:/hr/employer/detailempinfo/{emp_code}";
				break;
			}
		} else {
			goPage = "redirect:/hr/employer/detailempinfo/{emp_code}";
			redirectAttributes.addFlashAttribute("employ", employeevo);
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

}

