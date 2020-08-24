package kr.or.ddit.att_admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.att_admin.dao.IAdminAttDAO;
import kr.or.ddit.att_admin.service.IAdminAttService;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.service.IAdminEmployService;
import kr.or.ddit.login_logout.service.ILoginService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Time_AttendVO;

/**
 * 
 * @author 박혜진
 * @since 2020. 7. 23
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2020. 7. 23      작성자명       최초작성
 * Copyright (c) 2020 by DDIT All right reserved
 * </pre>
 * 
 *    1) 클라언트로부터 촬영된 얼굴 이미지 수신.(50%)
 * 	  2) 해당 이미지의 faceId 추출 (Face Detect API 사용)
 *    3) 추출된 faceId 를 이용해 얼굴과 매칭되는 Person id 식별(Face Identify API 사용)
 *    4) person id 를 이용해 DB 로부터 ID/PASSWORD 조회
 *    5) 조회한 ID/PASSWORD 로 로그인 처리
 */
@Controller
@RequestMapping("/hr/att/faceid")
public class AttFaceIdController {
	@Inject
	IAdminAttDAO dao;
	@Inject
	IAdminAttService service;
	@Inject
	ILoginService loginService;
	
	@Inject
	IAdminEmployService empService;
	
@GetMapping
public String faceIdList(Model model) {
	List<Map<String, Object>> catagCodeList = dao.selectCatagCode();
	model.addAttribute("catagCodes",catagCodeList);
	return "attFaceIdList.hr";
}
	
@PostMapping
@ResponseBody
public Map<String, Object> getFaceIdList(){
	Map<String, Object> mp = new HashMap<String, Object>();
	List<EmployeeVO> list = service.getFaceIdList();
	mp.put("data", list);
	return mp;
}

@GetMapping("/add/{emp_code}") //
public String faceIdAdd(@PathVariable String emp_code, Model model) {
	EmployeeVO empVO = new EmployeeVO();
	empVO.setEmp_code(emp_code);
	empVO = loginService.getEmpInfo(empVO);
	model.addAttribute("empVO",empVO); //스코프에 담음
	return "hr/attFaceIdAdd";
}

//대체얼굴등록 
@PostMapping(value="setSubFaceId", produces = "text/plain;charset=UTF-8")
@ResponseBody
public String subFaceIdAdd(@RequestBody MultipartFile image, String emp_code, String personid) {
	EmployeeVO empVO = new EmployeeVO();
	empVO.setImg1(image);
	empVO.setEmp_code(emp_code);
	empVO.setPersonid(personid);
	//이미지야 service가서 subfaceid로 바꿔담아오렴 ~ 
	ResultState result =service.UpdateSubFaceId(empVO);
	if(result.equals(ResultState.FAIL)) {
		return "등록실패";
	}
	return "등록되었습니다";
}


}
