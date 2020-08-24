package kr.or.ddit.community.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.community.dao.IReplyDAO;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Community_CommentVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class ReplyServiceImpl implements IReplyService {

	@Inject
	IReplyDAO dao;
	
	@Override
	public ResultState insertReply(Community_CommentVO reply) {
		ResultState result = null;
		int cnt = dao.insertReply(reply);

		if(cnt>0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		return result;
	}

	@Override
	public int selectReplyCount(PagingVO<Community_CommentVO> pagingVO) {
		return dao.selectReplyCount(pagingVO);
	}

	@Override
	public List<Community_CommentVO> selectReplyList(PagingVO<Community_CommentVO> pagingVO) {
		return dao.selectReplyList(pagingVO);
	}

	@Override
	public ResultState updateReply(Community_CommentVO reply) {
		ResultState result = null;
		int cnt = dao.updateReply(reply);
		if(cnt>0){	
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		return result;
	}

	@Override
	public ResultState deleteReply(Community_CommentVO reply) {
		ResultState result = null;
		int cnt = dao.deleteReply(reply);
		if(cnt>0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		
		return result;
	}

}
