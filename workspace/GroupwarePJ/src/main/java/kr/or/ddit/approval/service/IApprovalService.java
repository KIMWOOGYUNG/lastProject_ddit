package kr.or.ddit.approval.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Appr_OrderVO;
import kr.or.ddit.vo.Appr_StatVO;
import kr.or.ddit.vo.Approve_LineVO;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.DraftVO;
import kr.or.ddit.vo.Draft_AttatchVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Image_AttatchVO;
import kr.or.ddit.vo.Instead_AuthVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PushMessageVO;
import kr.or.ddit.vo.ReviewerGroupVO;
import kr.or.ddit.vo.ReviewerVO;
import kr.or.ddit.vo.Reviewer_StatVO;
import kr.or.ddit.vo.StandardVO;
import kr.or.ddit.vo.VacationVO;

public interface IApprovalService {
	List<DraftVO> getTempFolder(PagingVO<DraftVO> pagingVO);// 기안서를 상태에따라 읽어온다.
	DraftVO getDraft(String draft_code);//기안서의 상세페이지를 읽어온다
	List<String> getDraftAttachList(String draft_code);
	Draft_AttatchVO getDraftAttach(String draft_attcode);
	Image_AttatchVO getImageAttatch(String emp_attcode);
	List<String> getInsteadList(String emp_code);
	
	List<Approve_LineVO> getApprLine(PagingVO<Approve_LineVO> pagingVO);//사원의 결제라인을 불러온다.
	List<Appr_OrderVO> getApprOrder(String appr_line_code);
	List<Appr_StatVO> getApprLineStat(String draft_code);//해당 결제라인의 사원이 결제를 진행했는지 확인
	Appr_StatVO getApproveStatInfo(String appr_stat_code);
	int getApproveCount(PagingVO<DraftVO> pagingVO);
	int getApprLineCount(PagingVO<Approve_LineVO> pagingVO);
	List<ReviewerGroupVO> getReviewerGroup(PagingVO<ReviewerGroupVO> pagingVO);//검토자 그룹 호출
	int getReviewerGroupCount(PagingVO<ReviewerGroupVO> pagingVO);// 검토자 그룹 숫자 호출
	List<ReviewerVO> getReviewer(String rg_code);//그룹에 속한 검토자 리스트출력
	
	List<EmployeeVO> getEmpSortList(String emp_codeStr);
	
	
	List<Approve_LineVO> getMyApprGroup(String emp_code);
	List<ReviewerGroupVO> getMyReviewerGroup(ReviewerGroupVO groupVO);
	List<Reviewer_StatVO> getReviewerStatList(Reviewer_StatVO reviewer_StatVO);// 리뷰어 상태 조회
	Approve_LineVO getModifyApprLineInfo(Approve_LineVO approve_LineVO);
	ReviewerGroupVO getModifyReviewerLineInfo(ReviewerGroupVO reviewerGroupVO);
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	List<DraftVO> getDraftList(PagingVO<DraftVO> pagingVO,String state);
	int getDraftCount(PagingVO<DraftVO> pagingVO,String state);
	///////////////////////////////////////////////////////////////////////////////////////////////////
	String getAppringInfo(String draft_code);
	String getInsteadInfo(DraftVO draftVO);
	
	
	ResultState createApprLine(Approve_LineVO approve_LineVO);
	ResultState createApprEmpStat(Appr_StatVO appr_StatVO);//결재진행시 생성됨
	ResultState createApprEmpOrder(Appr_OrderVO appr_OrderVO);//결재 그룹에 사원 추가
	ResultState createDraft(DraftVO draftVO);
	ResultState createDraftAttatch(Draft_AttatchVO attatchVO);//////////////////
	ResultState createReviewerGroup(ReviewerGroupVO reviewerGroupVO);
	ResultState createReviewerLine(ReviewerVO reviewerVO); // 
	ResultState createReviewerStat(Reviewer_StatVO reviewer_StatVO);
	
	ResultState setReviewerGroup(ReviewerGroupVO reviewerGroupVO);
	ResultState setReviewerStat(Reviewer_StatVO reviewer_StatVO);
	ResultState setDarft(DraftVO draftVO);
	ResultState setDraftDelete(DraftVO draftVO);
	ResultState setApprEmpStat(Appr_StatVO appr_StatVO);//결재 상태 수정
	ResultState setApproveGroup(Approve_LineVO approve_LineVO);
	
	ResultState removeDraft(String draft_code);
	ResultState removeDraftAttatch(String draft_attcode);
	ResultState removeAllDraftAttatch(String draft_code);
	
	ResultState removeAllApproveOrder(String appr_line_code);//결제라인의 순서 전체삭제
	ResultState removeApproveOrder(Appr_OrderVO appr_OrderVO);//결제라인의 순서 부분삭제
	ResultState removeApproveStat(String draft_code);
	ResultState removeApproveLine(String appr_line_code);//결재라인 삭제
	ResultState removeReviewerGroup(String rg_code);//검토자 라인 삭제
	ResultState removeAllReviewerOrder(String rg_code);//검토자 라인 전체삭제
	ResultState removeRevieweStat(String draft_code);
	ResultState removeReviewerOrder(ReviewerVO reviewerVO);//검토자 그룹삭제
	
	void deleteFiles(String draft_attcode);
	
	////////////////
	ResultState createComment(CommentVO commentVO);
	ResultState setComment(CommentVO commentVO);
	ResultState removeComment(String cmt_code);
	List<CommentVO> getCommentList(String draft_code);
	CommentVO getCommentInfo(String cmt_code);
	///////////////
	String getApprCheck(Appr_StatVO appr_StatVO);
	List<String> getWorkedDateList(Map<String, String> sendData);
	ResultState createVacation(VacationVO vacationVO);
	ResultState setVacation(String dratf_code);
	ResultState removeVacation(String draft_code);
	ResultState createInsteadInfo(Instead_AuthVO authVO);
	ResultState setInsteadInfo(String dratf_code);
	ResultState removeInsteadInfo(String draft_code);
	List<VacationVO> getVacationList(String draft_code);
	List<StandardVO> getVacationInfo();
	 List<PushMessageVO> sendDraftPushMessage(DraftVO draftVO);
}