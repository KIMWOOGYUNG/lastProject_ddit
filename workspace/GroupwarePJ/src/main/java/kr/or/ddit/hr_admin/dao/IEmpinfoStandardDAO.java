package kr.or.ddit.hr_admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.JobtitleVO;
import kr.or.ddit.vo.PositionVO;
import kr.or.ddit.vo.TeamVO;

@Repository
public interface IEmpinfoStandardDAO {

	//부서명 선택
	public List<DepartmentVO> selectDepartname();
	
	//팀명 선택
	public List<TeamVO> selectTeamname();
	
	//직급명
	public List<PositionVO> selectPosition();
	
	//직책명
	public List<JobtitleVO> selectJobtitle();
	

}
