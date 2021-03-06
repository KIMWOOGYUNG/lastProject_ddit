package kr.or.ddit.message.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.message.dao.IMessageDAO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class MessageServiceImpl implements IMessageService {
	@Inject
	IMessageDAO dao;

	@Override//쪽지쓰기
	public ResultState createmsg(MessageVO msgVO) {
		ResultState result = ResultState.FAIL;
		int cnt =dao.insertMessage(msgVO);
		if(cnt>0) {
			result=ResultState.SUCCESSES;
		}
		return result;
	}

	@Override//쪽지리스트 출력
	public List<MessageVO> msgList(PagingVO<MessageVO> pagingVO) {
		return dao.MessageList(pagingVO);
	}
	
	@Override//상세보기
	public MessageVO selectmsg(String msg_code) {
		return dao.selectmsg(msg_code);
	}

	@Override //쪽지수량출력
	public int selectMessageCount(PagingVO<MessageVO> pagingVO) {
		return dao.selectMessageCount(pagingVO);
	}

	@Override//쪽지삭제
	public ResultState removemsg(String msg_code) {
		ResultState result = ResultState.FAIL;
		
		int cnt =dao.deleteMessage(msg_code);
		if(cnt>0) {
			result=ResultState.SUCCESSES;
		}
		return result;
	}

	//주소록 리스트 
	@Override
	public List<EmployeeVO> selectEmpList(PagingVO<EmployeeVO> pagingVO) {
		return dao.selectEmpList(pagingVO);
	}
	//주소록 사원수
	@Override
	public int readEmpCount(PagingVO<EmployeeVO> pagingVO) {
		return dao.selectEmpCount(pagingVO);
	}
   
	//중요보관함 리스트 
	@Override
	public List<MessageVO> msgImportantList(PagingVO<MessageVO> pagingVO) {
		return  dao.msgImportantList(pagingVO);
	}
	
	//중요보관함 쪽지 수 
	@Override
	public int selectImportCount(PagingVO<MessageVO> pagingVO) {
		return dao.updateImportCount(pagingVO);
	}
	//중요보관함 재이동
	@Override
	public ResultState updateImportant(MessageVO msg_code) {
		ResultState result = ResultState.FAIL;
		int cnt = dao.updateImportant(msg_code);
		if(cnt>0) {
			result=result.SUCCESSES;
		}
		return result;
	}

}
