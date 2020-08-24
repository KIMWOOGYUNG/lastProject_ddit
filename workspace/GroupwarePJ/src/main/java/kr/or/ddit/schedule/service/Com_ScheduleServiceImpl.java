package kr.or.ddit.schedule.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.schedule.dao.ICom_ScheduleDAO;
import kr.or.ddit.vo.Com_ScheduleVO;
import kr.or.ddit.vo.Com_WorkStdVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class Com_ScheduleServiceImpl implements ICom_ScheduleService {

	@Inject
	ICom_ScheduleDAO comscheduleDAO;
	
	
	@Override
	public List<Com_ScheduleVO> readScheduleList(PagingVO<Com_ScheduleVO> pagingVO) {
		return comscheduleDAO.selectComScheduleList(pagingVO);
	}

	@Override
	public Com_ScheduleVO readSchedule(String cs_code) {

		return comscheduleDAO.selectComSchedule(cs_code);
	}

	@Override
	public int readCom_ScheduleCount(PagingVO<Com_ScheduleVO> pagingVO) {
		return comscheduleDAO.selectCom_scheduleCount(pagingVO);
	}

	@Override
	public ResultState insertCom(Com_ScheduleVO comschedule) {
		int cnt = comscheduleDAO.insertCom(comschedule);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}

	@Override
	public int deleteCom(String cs_code) {
		return comscheduleDAO.deleteCom(cs_code);
	}

	@Override
	public ResultState updateCom(Com_ScheduleVO comschedule) {
		int cnt =  comscheduleDAO.updateCom(comschedule);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}

	@Override
	public List<Com_ScheduleVO> getComList() {
		List<Com_ScheduleVO> list = comscheduleDAO.selectcomlist();
		return list;
	}

}











