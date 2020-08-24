package kr.or.ddit.work.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.Report_AttVO;
import kr.or.ddit.vo.WorkLogVO;
import kr.or.ddit.vo.WorkLog_AttatchVO;
import kr.or.ddit.vo.Work_ReportVO;

public interface IMyReportService {
	// 보고등록
	public ResultState createReport(Work_ReportVO reportVO);
	
	// 보고상세보기
	public Work_ReportVO readReport(String report_code);
	
	// 보고 수
	public int readReportCount(PagingVO<Work_ReportVO> pagingVO);
	
	// 보고목록
	public List<Work_ReportVO> readReportList(PagingVO<Work_ReportVO> pagingVO);

//-----------------------------------------------------------------------------------
	// 받은보고 

	// 보고승인(업데이트)
	public ResultState completeReceiveReport(Work_ReportVO reportVO);
	
	// 보고첨부파일 다운로드
	public Report_AttVO downloadAttatch(String report_attcode);
	
	
}