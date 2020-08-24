package kr.or.ddit.schedule.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.Com_ScheduleVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.StandardVO;

@Repository
public interface ICom_ScheduleDAO {
	/**
	 * 회사 일정 리스트
	 * @param pagingVO
	 * @return
	 */
	public List<Com_ScheduleVO> selectComScheduleList(PagingVO<Com_ScheduleVO>pagingVO);
	/**
	 * 회사 상세 일정
	 * @param cs_code
	 * @return
	 */
	public Com_ScheduleVO selectComSchedule(String cs_code);
	/**
	 * 일정 개수
	 * @param pagingVO
	 * @return
	 */
	public int selectCom_scheduleCount(PagingVO<Com_ScheduleVO> pagingVO);
	/**
	 * 일정 등록
	 * @param comschedule
	 * @return
	 */
	public int insertCom(Com_ScheduleVO comschedule);
	/**
	 * 일정 삭제
	 * @param cs_code
	 * @return
	 */
	public int deleteCom(String cs_code);
	/**
	 * 일정 수정
	 * @param comschedule
	 * @return
	 */
	public int updateCom(Com_ScheduleVO comschedule);
	
	
	public List<Com_ScheduleVO> selectcomlist();
	
	public List<StandardVO> selectcomcatag();

}
