package kr.or.ddit.message.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.PagingVO;

public interface IMessageService {

	//쪽지쓰기 
	public ResultState createmsg(MessageVO msgVO);
	
	//전체쪽지리스트 조회 
	public List<MessageVO> msgList(PagingVO<MessageVO> pagingVO);
		
	//삭제함 리스트 조회 
//	public List<MessageVO> delmsgList(PagingVO<MessageVO> pagingVO);
	
	//쪽지 상세보기 
	public MessageVO selectmsg(String msg_code);
	
	//임시보관함이동
//	public MessageVO movemsg(String msg_code);
	
	//검색조건에 맞는 쪽지 수량 출력
	public int selectMessageCount(PagingVO<MessageVO> pagingVO);
	
	//중요보관함 리스트
	public  List<MessageVO> msgImportantList(PagingVO<MessageVO> pagingVO); 
	//중요보관함 쪽지 수량
	public int selectImportCount(PagingVO<MessageVO> pagingVO);
	
	//중요보관함에서 재 이동?
	public ResultState updateImportant(MessageVO msg_code);
	
	//삭제(삭제된거는 삭제함에서 보여짐)
	//완전삭제 
	public ResultState removemsg(String msg_code);

	
	////주소록 선택
//	public List<MessageVO> selectMsgList();
	
	
	/**프로젝트 등록시 팀원추가에서 조회할 사원들
	 * @param pagingVO
	 * @return
	 */
	
	public List<EmployeeVO>selectEmpList(PagingVO<EmployeeVO> pagingVO);
	
	
	
	///주소록 등록 팀원 추가에서 검색 조건에 맞는 사원수 
	public int readEmpCount(PagingVO<EmployeeVO> pagingVO);
		
	
			
		
}
