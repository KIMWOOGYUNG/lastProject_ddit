package kr.or.ddit.community.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Community_CommentVO;
import kr.or.ddit.vo.PagingVO;

public interface IReplyService {
	/**
	 * 댓글 쓰기
	 * @param reply
	 * @return
	 */
	public ResultState insertReply(Community_CommentVO reply);
	/**
	 * 댓글 수 
	 * @param pagingVO
	 * @return
	 */
	public int selectReplyCount(PagingVO<Community_CommentVO> pagingVO);
	/**
	 * 댓글 목록
	 * @param pagingVO
	 * @return
	 */
	public List<Community_CommentVO> selectReplyList(PagingVO<Community_CommentVO> pagingVO);
	/**
	 * 댓글 수정
	 * @param reply
	 * @return
	 */
	public ResultState updateReply(Community_CommentVO reply);
	/**
	 * 댓글 삭제
	 * @param reply
	 * @return
	 */
	public ResultState deleteReply(Community_CommentVO reply);
}
