package kr.or.ddit.schedule.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.schedule.dao.IDep_ScheduleDAO;
import kr.or.ddit.vo.Dept_ScheduleVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class Dep_ScheduleServiceImpl implements IDep_ScheduleService {
	
	@Inject
	IDep_ScheduleDAO depscheduleDAO;

	@Override
	public List<Dept_ScheduleVO> readdepScheduleList(PagingVO<Dept_ScheduleVO> pagingVO) {
			return depscheduleDAO.selectDeptScheduleList(pagingVO);
	}

	@Override
	public Dept_ScheduleVO readdepSchedule(String ds_code) {
		return depscheduleDAO.selectDeptSchedule(ds_code);
	}

	@Override
	public int readdepScheduleCount(PagingVO<Dept_ScheduleVO> pagingVO) {
		return depscheduleDAO.selectDept_scheduleCount(pagingVO);
	}

	@Override
	public ResultState insertDeptschedule(Dept_ScheduleVO deptschedule) {
		int cnt = depscheduleDAO.insertDeptschedule(deptschedule);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}

	@Override
	public int deleteDeptschedule(String ds_code) {
		return depscheduleDAO.deleteDeptschedule(ds_code); 
	
	}

	@Override
	public ResultState updateDeptschedule(Dept_ScheduleVO deptschedule) {
		int cnt = depscheduleDAO.updateDeptschedule(deptschedule);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}

	@Override
	public List<Dept_ScheduleVO> getDepList(String dept_code) {
		List<Dept_ScheduleVO> list = depscheduleDAO.selectdeplist(dept_code);
		return list;
	}

	@Override
	public List<EmployeeVO> selectEmpList(PagingVO<EmployeeVO> pagingVO) {
		return depscheduleDAO.selectEmpList(pagingVO);
	}

	@Override
	public int readEmpCount(PagingVO<EmployeeVO> pagingVO) {
		return depscheduleDAO.selectEmpCount(pagingVO);
	}

	@Override
	public List<Dept_ScheduleVO> getDepMyList(String emp_code) {
		return depscheduleDAO.selectMyDept(emp_code);
	}
	
	

}
