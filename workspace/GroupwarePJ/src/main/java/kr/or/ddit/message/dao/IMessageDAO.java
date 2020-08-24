package kr.or.ddit.message.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TeamVO;

@Repository
public interface IMessageDAO {

	//쪽지쓰기
	public int insertMessage(MessageVO msgVO); 
	
	//쪽지리스트 조회
	public List<MessageVO> MessageList(PagingVO<MessageVO> pagingVO);
	
	//상세보기
	public MessageVO selectmsg(String msg_code);

	//검색조건에 맞는 쪽지 수량 출력
	public int selectMessageCount(PagingVO<MessageVO> pagingVO);

	//삭제함리스트 조회  
//	public List<MessageVO> msgdeleteList(PagingVO<MessageVO> pagingVO);
	
	//중요보관함 리스트 
	public List<MessageVO> msgImportantList(PagingVO<MessageVO>pagingVO);
	//중요보관함 쪽지 수량
	public int updateImportCount(PagingVO<MessageVO> pagingVO);
	//중요보관함에서 다시 이동?(중요보관함)
	public int updateImportant(MessageVO msg_code);
	//완전삭제
	public int deleteMessage(String msg_code);
	
	
	/**주소록 등록시 팀원추가에서 조회할 사원들
	 * @param pagingVO
	 * @return
	 */
	public List<EmployeeVO>selectEmpList(PagingVO<EmployeeVO> pagingVO);
	
	/** 주소록 등록시 팀원추가에서 검색 조건에 맞는 사원 수 
	 * @param pagingVO
	 * @return
	 */
	public int selectEmpCount(PagingVO<EmployeeVO> pagingVO);
	
	///////////////////////////////////////////////////////////////
	//팀원추가의 부서
	public List<Map<String, Object>> selectDeptList();
			
	//팀원추가의 팀
	public List<TeamVO> selectTeamList(@Param(value = "dept") String dept_code);
	
	//부서 리스트 조회
	public List<DepartmentVO> selectDept();
	
	
}
