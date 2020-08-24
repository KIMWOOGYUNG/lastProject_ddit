package kr.or.ddit.mypage.service;

import java.util.List;

import kr.or.ddit.vo.Time_AttendVO;
import kr.or.ddit.vo.VacationVO;

public interface IMypageService {
	/**
	 * 출근시간
	 * @param emp_code
	 * @return
	 */
	public List<Time_AttendVO> getStartTime(String emp_code);
	/**
	 * 퇴근시간
	 * @param emp_code
	 * @return
	 */
	public List<Time_AttendVO> getEndTime(String emp_code);
	/**
	 * 내휴가캘린더
	 * @param emp_code
	 * @return
	 */
	public List<VacationVO> getMyVacation(String emp_code);
	/**
	 * 내 부서원들 휴가 캘린더
	 * @param dept_code
	 * @return
	 */
	public List<VacationVO> getTeamVacation(String dept_code);
}
