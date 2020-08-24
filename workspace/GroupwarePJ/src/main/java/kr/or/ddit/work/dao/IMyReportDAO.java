package kr.or.ddit.work.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.WorkLogVO;
import kr.or.ddit.vo.WorkLog_AttatchVO;
import kr.or.ddit.vo.Work_ReportVO;

@Repository
public interface IMyReportDAO {
	// 보고등록
	public int insertReport(Work_ReportVO reportVO);
	
	// 보고상세보기
	public Work_ReportVO selectReport(String report_code);
	
	// 보고 수 
	public int selectReportCount(PagingVO<Work_ReportVO> pagingVO);
	
	// 보고목록
	public List<Work_ReportVO> selectReportList(PagingVO<Work_ReportVO> pagingVO);

	
	
//----------------------------------------------------------------------------------
	// 받은 업무보고	

	// 보고완료(수정)
	public int completeReceiveReport(Work_ReportVO reportVO);
	
	// 팀 업무일지 조회
	public List<WorkLogVO> selectWorkLogList(PagingVO<WorkLogVO> pagingVO);
	
	// 팀 업무일지 수 
	public int selectWorkLogCount(PagingVO<WorkLogVO> pagingVO);
	
	// 팀 업무일지 상세
	public WorkLogVO selectWorkLog (String wl_code);
	
	// 일지 첨부파일
	public WorkLog_AttatchVO selectWlAtt (String wl_attcode);
}