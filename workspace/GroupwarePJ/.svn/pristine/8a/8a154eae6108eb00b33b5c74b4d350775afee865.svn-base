package kr.or.ddit.work.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.WorkLogVO;

public interface IPublicWorkLogService {
	// 일일업무일지
	
	// 일지 수 
	public int readWorkLogCountday(PagingVO<WorkLogVO> pagingVO);
	
	// 일지 목록
	public List<WorkLogVO> readWorkLogListday(PagingVO<WorkLogVO> pagingVO);
	


//-------------------------------------------------------------------------------
	// 주간업무일지
	
	// 일지 수 
	public int readWorkLogCountweek(PagingVO<WorkLogVO> pagingVO);
	
	// 일지 목록
	public List<WorkLogVO> readWorkLogListweek(PagingVO<WorkLogVO> pagingVO);

}
