package kr.or.ddit.mypage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.Time_AttendVO;
import kr.or.ddit.vo.VacationVO;


@Repository
public interface IMypageDAO {
	/**
	 * 출근시간 구하기 
	 * @param emp_code
	 * @return
	 */
	public List<Time_AttendVO> selectStartTime(String emp_code); 
	
	/**
	 * 퇴근시간 구하기 
	 * @param emp_code
	 * @return
	 */
	public List<Time_AttendVO> selectEndTime(String emp_code);
	/**
	 * 나의 휴가 구하기 
	 * @param emp_code
	 * @return
	 */
	public List<VacationVO> selectMyVacation(String emp_code);
	/**
	 * 우리 부서 휴가 구하기 
	 * @param dept_code
	 * @return
	 */
	public List<VacationVO> selectTeamVacation(String dept_code);
	

}
