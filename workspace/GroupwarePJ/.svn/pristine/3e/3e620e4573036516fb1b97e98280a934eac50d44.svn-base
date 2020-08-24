package kr.or.ddit.community.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.Community_CommentVO;
import kr.or.ddit.vo.PagingVO;

@Repository
public interface IReplyDAO {
	/**
	 * 댓글 쓰기
	 * @param reply
	 * @return
	 */
	public int insertReply(Community_CommentVO reply);
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
	public int updateReply(Community_CommentVO reply);
	/**
	 * 댓글 삭제
	 * @param reply
	 * @return
	 */
	public int deleteReply(Community_CommentVO reply);
}
