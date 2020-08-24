package kr.or.ddit.approval.service;

import java.awt.font.TextMeasurer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.approval.dao.IApprovalDAO;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.event.MessageEvent;
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

@Service
public class ApprovalServiceImpl implements IApprovalService {
	@Inject
	IApprovalDAO dao;
	
	
	@Override
	public List<DraftVO> getTempFolder(PagingVO<DraftVO> pagingVO) {
		return dao.selectTempFolder(pagingVO);
	}

	@Override
	public DraftVO getDraft(String draft_code) {
		return dao.selectDraft(draft_code);
	}

	@Override
	public List<Approve_LineVO> getApprLine(PagingVO<Approve_LineVO> pagingVO) {
		return dao.selectApproveLine(pagingVO);
	}
	
	@Override
	public List<Appr_OrderVO> getApprOrder(String appr_line_code){
		return dao.selectApprOrder(appr_line_code);
	}
	@Override
	public List<Appr_StatVO> getApprLineStat(String draft_code) {
		return dao.selectApproveStat(draft_code);
	}

	@Override
	public int getApproveCount(PagingVO<DraftVO> pagingVO) {
		return dao.selectApproveCount(pagingVO);
	}

	@Override
	public ResultState createApprEmpStat(Appr_StatVO appr_StatVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertApproveStat(appr_StatVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState createApprLine(Approve_LineVO approve_LineVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertApproveLine(approve_LineVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState createApprEmpOrder(Appr_OrderVO appr_OrderVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertApproveOrder(appr_OrderVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState createDraft(DraftVO draftVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertDraft(draftVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState createDraftAttatch(Draft_AttatchVO attatchVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertDraftAttatch(attatchVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState setDarft(DraftVO draftVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.updateDraft(draftVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	

	@Override
	public ResultState setApprEmpStat(Appr_StatVO appr_StatVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.updateApproveStat(appr_StatVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}
	
	@Override
	public ResultState setApproveGroup(Approve_LineVO approve_LineVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.updateApproveGroup(approve_LineVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}
		return state;
	}
	

	@Override
	public ResultState removeDraft(String draft_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteDraft(draft_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeDraftAttatch(String draft_attcode) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteDraftAttatch(draft_attcode);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeAllDraftAttatch(String draft_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteAllDraftAttatch(draft_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}



	@Override
	public int getApprLineCount(PagingVO<Approve_LineVO> pagingVO) {
		return dao.selectApprLineCount(pagingVO);
	}

	@Override
	public List<ReviewerGroupVO> getReviewerGroup(PagingVO<ReviewerGroupVO> pagingVO) {
		return dao.selectReviewerGroup(pagingVO);
	}

	@Override
	public int getReviewerGroupCount(PagingVO<ReviewerGroupVO> pagingVO) {
		return dao.selectReviewerGroupCount(pagingVO);
	}
	
	@Override
	public List<ReviewerVO> getReviewer(String rg_code) {
		return dao.selectReviewer(rg_code);
	}


	@Override
	public List<EmployeeVO> getEmpSortList(String emp_codeStr) {
		return dao.selectEmpSortList(emp_codeStr);
	}

	@Override
	public ResultState createReviewerGroup(ReviewerGroupVO reviewerGroupVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertReviewerGroup(reviewerGroupVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState createReviewerLine(ReviewerVO reviewerVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertReviewerLine(reviewerVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState createReviewerStat(Reviewer_StatVO reviewer_StatVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertReviewerStat(reviewer_StatVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState setReviewerGroup(ReviewerGroupVO reviewerGroupVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.updateReviewerGroup(reviewerGroupVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	

	@Override
	public ResultState setReviewerStat(Reviewer_StatVO reviewer_StatVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.updateReviewerStat(reviewer_StatVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}


	@Override
	public Approve_LineVO getModifyApprLineInfo(Approve_LineVO approve_LineVO) {
		return dao.selectModifyApprLineInfo(approve_LineVO);
	}

	@Override
	public ReviewerGroupVO getModifyReviewerLineInfo(ReviewerGroupVO reviewerGroupVO) {
		return dao.selectModifyReviewerLineInfo(reviewerGroupVO);
	}

	
	@Override
	public List<Approve_LineVO> getMyApprGroup(String emp_code) {
		return dao.selectMyApprGroup(emp_code);
	}

	@Override
	public List<ReviewerGroupVO> getMyReviewerGroup(ReviewerGroupVO groupVO) {
		return dao.selectMyReviewerGroup(groupVO);
	}

	@Override
	public ResultState removeAllApproveOrder(String appr_line_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteAllApproveOrder(appr_line_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeApproveOrder(Appr_OrderVO appr_OrderVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteApproveOrder(appr_OrderVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeApproveLine(String appr_line_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteApproveLine(appr_line_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeReviewerGroup(String rg_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteReviewerGroup(rg_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeAllReviewerOrder(String rg_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteAllReviewerOrder(rg_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeReviewerOrder(ReviewerVO reviewerVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteReviewerOrder(reviewerVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}


	@Override
	public List<Reviewer_StatVO> getReviewerStatList(Reviewer_StatVO reviewer_StatVO) {
		return dao.selectReviewerStatList(reviewer_StatVO);
	}

	@Override
	public Draft_AttatchVO getDraftAttach(String draft_attcode) {
		return dao.selectDraftAttatch(draft_attcode);
	}

	@Override
	public Image_AttatchVO getImageAttatch(String emp_attcode) {
		return dao.selectImageAttatch(emp_attcode);
	}

	@Override
	public List<String> getDraftAttachList(String draft_code) {
		return dao.selectDraftAttachList(draft_code);
	}

	@Override
	public ResultState removeApproveStat(String draft_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteApproveStat(draft_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeRevieweStat(String draft_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteRevieweStat(draft_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState setDraftDelete(DraftVO draftVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.updateDraftDelete(draftVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	public void deleteFiles(String draft_code) {
		
		List<String> att_codeList = dao.selectDraftAttachList(draft_code);
		for(String code :att_codeList) {
			Draft_AttatchVO attatchVO =  dao.selectDraftAttatch(code);
			String saveFolder = attatchVO.getFile_path();
			String delName = attatchVO.getSave_name();
			try {
				FileUtils.forceDelete(new File(saveFolder, delName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<DraftVO> getDraftList(PagingVO<DraftVO> pagingVO, String state) {
		if("all".equals(state)) {
			return dao.selectTotalDraftList(pagingVO);
		}else if("draft".equals(state)) {
			return dao.selectAllDraftList(pagingVO);
		}else if("prog".equals(state)){
			return dao.selectProgDraftList(pagingVO);
		}else if("attr".equals(state)) {
			return dao.selectAttrDraftList(pagingVO);
		}else if("comp".equals(state)) {
			return dao.selectCompDraftList(pagingVO);
		}
		return null;
	}

	@Override
	public int getDraftCount(PagingVO<DraftVO> pagingVO, String state) {
		if("all".equals(state)) {
			return dao.selectTotalDraftCount(pagingVO);
		}else if("draft".equals(state)) {
			return dao.selectAllDraftCount(pagingVO);
		}else if("prog".equals(state)){
			return dao.selectProgDraftCount(pagingVO);
		}else if("attr".equals(state)) {
			return dao.selectAttrDraftCount(pagingVO);
		}else if("comp".equals(state)) {
			return dao.selectCompDraftCount(pagingVO);
		}
			
		return 0;
	}

	@Override
	public List<String> getInsteadList(String emp_code) {
		return dao.selectInsteadList(emp_code);
	}

	@Override
	public Appr_StatVO getApproveStatInfo(String appr_stat_code) {
		return dao.selectApproveStatInfo(appr_stat_code);
	}

	@Override
	public String getAppringInfo(String draft_code) {
		return dao.selectAppringInfo(draft_code);
	}

	@Override
	public String getInsteadInfo(DraftVO draftVO) {
		return dao.selectInsteadInfo(draftVO);
	}

	@Override
	public ResultState createComment(CommentVO commentVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertComment(commentVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState setComment(CommentVO commentVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.updateComment(commentVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeComment(String cmt_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteComment(cmt_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public List<CommentVO> getCommentList(String draft_code) {
		return dao.selectCommentList(draft_code);
	}

	@Override
	public CommentVO getCommentInfo(String cmt_code) {
		return dao.selectCommentInfo(cmt_code);
	}

	@Override
	public String getApprCheck(Appr_StatVO appr_StatVO) {
		return dao.selectApprCheck(appr_StatVO);
	}

	@Override
	public List<String> getWorkedDateList(Map<String, String> sendData) {
		return dao.selectWorkedDateList(sendData);
	}

	@Override
	public ResultState createVacation(VacationVO vacationVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertVacation(vacationVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeVacation(String draft_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteVacation(draft_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState createInsteadInfo(Instead_AuthVO authVO) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.insertInsteadInfo(authVO);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState removeInsteadInfo(String draft_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.deleteInsteadInfo(draft_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState setVacation(String dratf_code) {
		ResultState state = ResultState.FAIL;
		int cnt = dao.updateVacation(dratf_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public ResultState setInsteadInfo(String dratf_code) {
		ResultState state = ResultState.FAIL;

		int cnt = dao.updateInsteadInfo(dratf_code);
		if (cnt > 0) {
			state = ResultState.SUCCESSES;
		}

		return state;
	}

	@Override
	public List<VacationVO> getVacationList(String draft_code) {
		return dao.selectVactionList(draft_code);
	}

	@Override
	public List<StandardVO> getVacationInfo() {
		return dao.selectVacationInfo();
	}

	
	
	public List<PushMessageVO> sendDraftPushMessage(DraftVO draftVO) {
		List<PushMessageVO> pushList = new ArrayList<PushMessageVO>();
		String draft_code = draftVO.getDraft_code();
		String title = "("+draft_code+")"+draftVO.getDraft_title()+"이 ";
		String content = draftVO.getDraft_stat().equals("APP001") ? "승인되었습니다.":"반려되었습니다.";
		List<Appr_StatVO> apprList = dao.selectApproveStat(draft_code);
		
		pushList.add(settingData(draftVO.getEmp_code(),title,content));
		
		Reviewer_StatVO reviewer_StatVO = new Reviewer_StatVO();
		reviewer_StatVO.setDraft_code(draft_code);
		
		reviewer_StatVO.setRs_type("1");
		List<Reviewer_StatVO> rg1List = dao.selectReviewerStatList(reviewer_StatVO);

		reviewer_StatVO.setRs_type("2");
		List<Reviewer_StatVO> rg2List = dao.selectReviewerStatList(reviewer_StatVO);
		
		if(apprList != null && apprList.size()>0)
		for (Appr_StatVO temp : apprList) {
			pushList.add(settingData(temp.getEmp_code(),title,content));
		}
		
		if(rg1List != null && rg1List.size()>0)
		for (Reviewer_StatVO temp : rg1List) {
			pushList.add(settingData(temp.getEmp_code(),title,content));
		}
		
		if(rg2List != null && rg2List.size()>0)
		for (Reviewer_StatVO temp : rg2List) {
			pushList.add(settingData(temp.getEmp_code(),title,content));
		}
		
		return pushList;
	}
	
	private PushMessageVO settingData(String receiver,String title,String content) {
		PushMessageVO msgVO = new PushMessageVO();
		msgVO.setReceiver(receiver);
		msgVO.setType("draft");
		msgVO.setTitle(title);
		msgVO.setContent(content);
		return msgVO;
	}

}
