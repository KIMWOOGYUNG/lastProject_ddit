package kr.or.ddit.schedule.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.My_ScheduleVO;
import kr.or.ddit.vo.PagingVO;


public interface IMy_ScheduleService {
	
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
	public ResultState insertMyschedule(My_ScheduleVO myschedule);
	/**
	 * 내 일정 수정
	 * @param myschedule
	 * @return
	 */
	public ResultState updateMyschedule(My_ScheduleVO myschedule);
	/**
	 * 내 일정 삭제
	 * @param ms_code
	 * @return
	 */
	public int deleteMyschedule(String ms_code);
	
	public List<My_ScheduleVO> getMyList(String emp_code);
	
	public List<My_ScheduleVO> getmyimport(My_ScheduleVO my_ScheduleVO);
	
	
}

















