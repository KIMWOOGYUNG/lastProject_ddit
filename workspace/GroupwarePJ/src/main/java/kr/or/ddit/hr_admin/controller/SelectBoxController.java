package kr.or.ddit.hr_admin.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.hr_admin.dao.ISelectBoxDAO;
import kr.or.ddit.vo.TeamVO;

@RestController
@RequestMapping(value = "/employ", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SelectBoxController {
	
	

		@Inject
		private ISelectBoxDAO dao;
		
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

	}	


