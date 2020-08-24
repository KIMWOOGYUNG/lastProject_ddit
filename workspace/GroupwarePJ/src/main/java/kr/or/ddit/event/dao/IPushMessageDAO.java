package kr.or.ddit.event.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PushMessageVO;

@Repository
public interface IPushMessageDAO {
	int insertPushMessage(PushMessageVO messageVO);
	List<PushMessageVO> selectMessagePush(String emp_code);
	int selectMessageCount(String emp_code);
	List<PushMessageVO> selectDraftPush(String emp_code);
	int selectDraftCount(String emp_code);
	String selectType (PushMessageVO messageVO);	
	
	int deleteAllMessage(String push_code);
	int deleteAllDraft(String push_code);
	int deletePush(PushMessageVO messageVO);
	
}
