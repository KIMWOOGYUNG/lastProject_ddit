package kr.or.ddit.schedule.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Dept_ScheduleVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;

public interface IDep_ScheduleService {
	
	/**
	 * 부서 일정 테이블 리스트 구하기
	 * @param pagingVO
	 * @return
	 */
	public List<Dept_ScheduleVO> readdepScheduleList(PagingVO<Dept_ScheduleVO> pagingVO);
	/**
	 * 부서 일정 상세보기
	 * @param ds_code
	 * @return
	 */
	public Dept_ScheduleVO readdepSchedule(String ds_code);
	/**
	 * 등록된 부서일정 개수 구하기
	 * @param pagingVO
	 * @return
	 */
	public int readdepScheduleCount(PagingVO<Dept_ScheduleVO> pagingVO);
	/**
	 * 부서일정 등록하기
	 * @param deptschedule
	 * @return
	 */
	public ResultState insertDeptschedule(Dept_ScheduleVO deptschedule);
	/**
	 * 부서 일정 삭제하기
	 * @param ds_code
	 * @return
	 */
	public int deleteDeptschedule(String ds_code);
	/**
	 * 부서 일정 수정
	 * @param deptschedule
	 * @return
	 */
	public ResultState updateDeptschedule(Dept_ScheduleVO deptschedule);
	/**
	 * 달력에 부서 일정 띄우기
	 * @return
	 */
	public List<Dept_ScheduleVO> getDepList(String dept_code);

	
	public List<Dept_ScheduleVO> getDepMyList(String emp_code);
	
	
	
	/**프로젝트 등록시 팀원추가에서 조회할 사원들
	 * @param pagingVO
	 * @return
	 */
	
	public List<EmployeeVO>selectEmpList(PagingVO<EmployeeVO> pagingVO);
	
	
	
	///주소록 등록 팀원 추가에서 검색 조건에 맞는 사원수 
	public int readEmpCount(PagingVO<EmployeeVO> pagingVO);
		
	
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
