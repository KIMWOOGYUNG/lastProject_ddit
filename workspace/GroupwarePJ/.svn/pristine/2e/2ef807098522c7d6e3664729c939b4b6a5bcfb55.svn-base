package kr.or.ddit.schedule.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.My_ScheduleVO;
import kr.or.ddit.vo.PagingVO;

@Repository
public interface IMy_ScheduleDAO {
	/**
	 * 내 일정 테이블 리스트
	 * @param pagingVO
	 * @return
	 */
	public List<My_ScheduleVO> selectMyScheduleList(PagingVO<My_ScheduleVO> pagingVO);
	/**
	 * 내 일정 상세조회
	 * @param ms_code
	 * @return
	 */
	public My_ScheduleVO selectMySchedule(String ms_code);
	/**
	 * 일정 개수
	 * @param pagingVO
	 * @return
	 */
	public int selectMyScheduleCount(PagingVO<My_ScheduleVO> pagingVO);
	/**
	 * 내 일정 등록
	 * @param myschedule
	 * @return
	 */
	public int insertMyschedule(My_ScheduleVO myschedule);
	/**
	 * 내 일정 수정
	 * @param myschedule
	 * @return
	 */
	public int updateMyschedule(My_ScheduleVO myschedule);
	/**
	 * 내 일정 삭제
	 * @param ms_code
	 * @return
	 */
	public int deleteMyschedule(String ms_code);
	
	
	public List<My_ScheduleVO> selectmylist(String emp_code);
	
	public List<My_ScheduleVO> selectmyimport(My_ScheduleVO my_ScheduleVO);
	

	
}































