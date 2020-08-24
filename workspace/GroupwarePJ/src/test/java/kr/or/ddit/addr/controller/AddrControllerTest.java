package kr.or.ddit.addr.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import kr.or.ddit.addr.service.IaddrService;
import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TeamVO;


public class AddrControllerTest {
	
	@Inject
	IaddrService service;
	
	@Test
	public void test() {
		List<DepartmentVO> deptList = service.readDepartmentList();
		List<Map<String, Object>>sendList = new ArrayList<Map<String,Object>>();
		for(DepartmentVO tempDept : deptList) {
			HashMap<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("title", tempDept.getDept_name());
			dataMap.put("key",tempDept.getDept_code());
			
		  List<TeamVO> teamList = service.readTeamList(tempDept.getDept_code());
		  
		  if(!teamList.isEmpty()) {
			  dataMap.put("isFolder",true);
			  for(TeamVO tempTeam : teamList) {
				  HashMap<String, Object> teamMap = new HashMap<String, Object>();
				 
				  teamMap.put("title", tempTeam.getTeam_name());
				  teamMap.put("key", tempTeam.getTeam_code());
				 
				  	EmployeeVO employeeVO = new EmployeeVO();
					employeeVO.setTeam_code(tempTeam.getTeam_code());
					PagingVO<EmployeeVO> pagingVO = new PagingVO<EmployeeVO>();
					pagingVO.setDetailSearch(employeeVO);
					List<EmployeeVO> empList = service.readAddrList(pagingVO);
					
					if(!empList.isEmpty()) {
						 teamMap.put("isFolder", true);
						 for(EmployeeVO tempEmp : empList) {
							 HashMap<String, Object> empMap = new HashMap<String, Object>();
							 empMap.put("title", tempEmp.getEmp_kor()+"("+tempEmp.getPosition_code()+")");
							 empMap.put("key", tempEmp.getEmp_code());
							 teamMap.put("chlidren",empMap); 
						 }
					}
				dataMap.put("chlidren",teamMap);
			  }
		  }
		  sendList.add(dataMap);
		}
		System.out.println(sendList);
		
	}

}
