package kr.or.ddit.work.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.WorkLogVO;
import kr.or.ddit.work.dao.IMyWorkLogDAO;
import kr.or.ddit.work.dao.IPublicWorkLogDAO;

@Service
public class PublicWorkLogServiceImpl implements IPublicWorkLogService{

	@Inject
	private IPublicWorkLogDAO dao;
	
	// 일일업무일지

	@Override
	public int readWorkLogCountday(PagingVO<WorkLogVO> pagingVO) {
		return dao.selectWorkLogCountday(pagingVO);
	}

	@Override
	public List<WorkLogVO> readWorkLogListday(PagingVO<WorkLogVO> pagingVO) {
		return dao.selectWorkLogListday(pagingVO);
	}


//-----------------------------------------------------------------------------------------------
	// 주간업무일지

	@Override
	public int readWorkLogCountweek(PagingVO<WorkLogVO> pagingVO) {
		return dao.selectWorkLogCountweek(pagingVO);
	}

	@Override
	public List<WorkLogVO> readWorkLogListweek(PagingVO<WorkLogVO> pagingVO) {
		return dao.selectWorkLogListweek(pagingVO);
	}


}