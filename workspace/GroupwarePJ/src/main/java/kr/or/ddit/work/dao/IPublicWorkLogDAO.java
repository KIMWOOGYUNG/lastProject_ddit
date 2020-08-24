package kr.or.ddit.work.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.WorkLogVO;

@Repository
public interface IPublicWorkLogDAO {
	// 일일업무일지
	
	// 일지 수
	public int selectWorkLogCountday(PagingVO<WorkLogVO> pagingVO);
	
	// 일지목록
	public List<WorkLogVO> selectWorkLogListday(PagingVO<WorkLogVO> pagingVO);

//------------------------------------------------------------------------------------------------
	// 주간업무 일지

	// 일지 수 
	public int selectWorkLogCountweek(PagingVO<WorkLogVO> pagingVO);
	
	// 일지 목록
	public List<WorkLogVO> selectWorkLogListweek(PagingVO<WorkLogVO> pagingVO);

}