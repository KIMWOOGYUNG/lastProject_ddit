package kr.or.ddit.schedule.service;



import java.util.List;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Com_ScheduleVO;
import kr.or.ddit.vo.PagingVO;

public interface ICom_ScheduleService {
	/**
	 * 회사 일정 테이블 리스트 구하기
	 * @param pagingVO
	 * @return
	 */
	public List<Com_ScheduleVO> readScheduleList(PagingVO<Com_ScheduleVO> pagingVO);
	/**
	 * 회사 일정 상세 보기
	 * @param cs_code
	 * @return
	 */
	public Com_ScheduleVO readSchedule(String cs_code);
	/**
	 * 등록된 회사일정 개수 구하기
	 * @param pagingVO
	 * @return
	 */
	public int readCom_ScheduleCount(PagingVO<Com_ScheduleVO> pagingVO);
	/**
	 * 회사 일정 등록하기
	 * @param comschedule
	 * @return
	 */
	public ResultState insertCom(Com_ScheduleVO comschedule);
	/**
	 * 회사 일정 삭제
	 * @param cs_code
	 * @return
	 */
	public int deleteCom(String cs_code);
	/**
	 * 회사 일정 수정
	 * @param comschedule
	 * @return
	 */
	public ResultState updateCom(Com_ScheduleVO comschedule);
	/**
	 * 달력에 회사 일정 띄우기
	 * @return
	 */
	public List<Com_ScheduleVO> getComList();
	
	
	
	
	
	
}
