package kr.or.ddit.schedule.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.Dept_ScheduleVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TeamVO;

@Repository
public interface IDep_ScheduleDAO {
	/**
	 * 부서 일정 리스트
	 * @param pagingVO
	 * @return
	 */
	public List<Dept_ScheduleVO> selectDeptScheduleList(PagingVO<Dept_ScheduleVO> pagingVO);
	/**
	 * 부서 상세 일정
	 * @param ds_code
	 * @return
	 */
	public Dept_ScheduleVO selectDeptSchedule(String ds_code);
	/**
	 * 일정 개수
	 * @param pagingVO
	 * @return
	 */
	public int selectDept_scheduleCount(PagingVO<Dept_ScheduleVO> pagingVO);
	/**
	 * 부서 일정 등록
	 * @param deptschedule
	 * @return
	 */
	public int insertDeptschedule(Dept_ScheduleVO deptschedule);
	/**
	 * 부서 일정 삭제
	 * @param ds_code
	 * @return
	 */
	public int deleteDeptschedule(String ds_code);
	/**
	 * 부서 일정 수정
	 * @param deptschedule
	 * @return
	 */
	public int updateDeptschedule(Dept_ScheduleVO deptschedule);


	public List<Dept_ScheduleVO> selectdeplist(String dept_code);
	
	
	/**주소록 등록시 팀원추가에서 조회할 사원들
	 * @param pagingVO
	 * @return
	 */
	public List<EmployeeVO>selectEmpList(PagingVO<EmployeeVO> pagingVO);
	
	/** 주소록 등록시 팀원추가에서 검색 조건에 맞는 사원 수 
	 * @param pagingVO
	 * @return
	 */
	public int selectEmpCount(PagingVO<EmployeeVO> pagingVO);
	
	///////////////////////////////////////////////////////////////
	//팀원추가의 부서
	public List<Map<String, Object>> selectDeptList();
			
	//팀원추가의 팀
	public List<TeamVO> selectTeamList(@Param(value = "dept") String dept_code);
	
	//부서 리스트 조회
	public List<DepartmentVO> selectDept();

	//부서내 리스트 조회
	public List<Dept_ScheduleVO> selectMyDept(String emp_code);

	










}
