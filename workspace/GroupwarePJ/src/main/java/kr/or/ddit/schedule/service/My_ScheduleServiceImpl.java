package kr.or.ddit.schedule.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.schedule.dao.IMy_ScheduleDAO;
import kr.or.ddit.vo.My_ScheduleVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class My_ScheduleServiceImpl implements IMy_ScheduleService {
	
	@Inject
	IMy_ScheduleDAO myscheduleDAO;

	@Override
	public List<My_ScheduleVO> selectMyScheduleList(PagingVO<My_ScheduleVO> pagingVO) {
		return myscheduleDAO.selectMyScheduleList(pagingVO);
	}

	@Override
	public My_ScheduleVO selectMySchedule(String ms_code) {
		return myscheduleDAO.selectMySchedule(ms_code);
	}

	@Override
	public int selectMyScheduleCount(PagingVO<My_ScheduleVO> pagingVO) {
		return myscheduleDAO.selectMyScheduleCount(pagingVO);
	}

	@Override
	public ResultState insertMyschedule(My_ScheduleVO myschedule) {
		int cnt = myscheduleDAO.insertMyschedule(myschedule);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}

	@Override
	public ResultState updateMyschedule(My_ScheduleVO myschedule) {
		int cnt = myscheduleDAO.updateMyschedule(myschedule);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}

	@Override
	public int deleteMyschedule(String ms_code) {
		return myscheduleDAO.deleteMyschedule(ms_code);
	}

	@Override
	public List<My_ScheduleVO> getMyList(String emp_code) {
		List<My_ScheduleVO> list = myscheduleDAO.selectmylist(emp_code);
		return list;
	}

	@Override
	public List<My_ScheduleVO> getmyimport(My_ScheduleVO my_ScheduleVO) {
		return myscheduleDAO.selectmyimport(my_ScheduleVO);
	}

	
	
	
}
