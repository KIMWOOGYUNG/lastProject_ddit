package kr.or.ddit.community.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.Board_AttatchVO;

@Repository
public interface IBoardAttatchDAO {
	/**
	 * 첨부파일 추가
	 * @param board_attatchVO
	 * @return
	 */
	public int insertAttatchs(Board_AttatchVO board_attatchVO);
	/**
	 * 첨부파일 선택
	 * @param board_attcode
	 * @return
	 */
	public Board_AttatchVO selectAttatch(String board_attcode);
	/**
	 * 파일 다운로드 수
	 * @param board_attcode
	 * @return
	 */
//	public int incrementDownCount(String board_attcode);
	/**
	 * 첨부파일 삭제
	 * @param board
	 * @return
	 */
	public int deleteAttatchs(BoardVO board);
}
