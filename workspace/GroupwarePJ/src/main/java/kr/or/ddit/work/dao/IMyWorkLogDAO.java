package kr.or.ddit.work.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.WorkLogVO;
import kr.or.ddit.vo.WorkLog_AttatchVO;

@Repository
public interface IMyWorkLogDAO {
	// 일일업무일지
	
	// 일지등록
	public int insertWorkLogday(WorkLogVO worklogVO);
	
	// 일지 상세보기
	public WorkLogVO selectWorkLogday(WorkLogVO worklogVO);
	
	// 일지 수 
	public int selectWorkLogCountday(PagingVO<WorkLogVO> pagingVO);
	
	// 일지 목록
	public List<WorkLogVO> selectWorkLogListday(PagingVO<WorkLogVO> pagingVO);
	
	// 일지 수정
	public int updateWorkLogday(WorkLogVO worklogVO);
	
	// 일지삭제 
	public int deleteWorkLogday(String wl_code);

//------------------------------------------------------------------------------------------------

	// 삭제함
	
	// 일지 영구삭제
	public int deleteWorkLogtrash(String wl_code);
	
	// 일지복구
	public int backWorkLogtrash(WorkLogVO worLogVO);
	
//--------------------------------------------------------------------------------------------------
	// 팀 업무일지
	
	// 일지등록
	public int insertWorkLogteam(WorkLogVO worklogVO);
	
	// 일지 상세보기
	public WorkLogVO selectWorkLogteam(String wl_code);
	
	// 일지 수 
	public int selectWorkLogCountteam(PagingVO<WorkLogVO> pagingVO);
	
	// 일지 목록
	public List<WorkLogVO> selectWorkLogListteam(PagingVO<WorkLogVO> pagingVO);
	
	// 일지 수정
	public int updateWorkLogteam(WorkLogVO worklogVO);

	

	public List<WorkLog_AttatchVO> selectAttList(String wl_code);
	
}
