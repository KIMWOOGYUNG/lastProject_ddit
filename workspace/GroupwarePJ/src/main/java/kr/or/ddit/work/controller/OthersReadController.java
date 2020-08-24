package kr.or.ddit.work.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.TeamVO;
import kr.or.ddit.work.dao.IOthersDAO;

@RestController
@RequestMapping(value = "/work", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OthersReadController {

	@Inject
	private IOthersDAO dao;
	
	@GetMapping("getDeptList")
	public List<Map<String, Object>> getDeptList(){
		List<Map<String, Object>> deptList = dao.selectDeptList();
		
		return deptList;
	}
	
	@GetMapping("getTeamList")
	public List<TeamVO> getTeamList(@RequestParam(required = false) String dept_code){
		List<TeamVO> teamList = dao.selectTeamList(dept_code);
		return teamList;
	}

	@GetMapping("getEmpList")
	public List<EmployeeVO> getempList(@RequestParam(required = false) String dept_code){
		List<EmployeeVO> empList = dao.selectEmployee(dept_code);
		return empList;
	}
	
}
