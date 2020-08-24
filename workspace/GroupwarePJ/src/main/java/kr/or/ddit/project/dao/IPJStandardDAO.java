package kr.or.ddit.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.StandardVO;
import kr.or.ddit.vo.TeamVO;

@Repository
public interface IPJStandardDAO {
	
	//중요도
	public List<StandardVO> selectImportant();
	
	//상태
	public List<StandardVO> selectStatus(); 
	
	//유형
	public List<StandardVO> selectTaskType();
	
	//팀원추가의 부서
	public List<Map<String, Object>> selectDeptList();
	
	//팀원추가의 팀
	public List<TeamVO> selectTeamList(@Param(value = "dept") String dept_code);
	
	//부서 리스트 조회
	public List<DepartmentVO> selectDept();
}