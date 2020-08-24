package kr.or.ddit.mypage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.mypage.dao.IMypageDAO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Time_AttendVO;
import kr.or.ddit.vo.VacationVO;

@Service
public class MypageServiceImpl implements IMypageService {
	
	@Inject
	IMypageDAO dao;
	
	@Override //출근시간캘린더
	public List<Time_AttendVO> getStartTime(String emp_code) {
		List<Time_AttendVO> attList = dao.selectStartTime(emp_code);
		return attList;
	}

	@Override //퇴근시간캘린더
	public List<Time_AttendVO> getEndTime(String emp_code) {
		List<Time_AttendVO> attList = dao.selectEndTime(emp_code);
		return attList;
	}

	@Override
	public List<VacationVO> getMyVacation(String emp_code) {
		List<VacationVO> vacaList = dao.selectMyVacation(emp_code);
		return vacaList;
	}

	@Override
	public List<VacationVO> getTeamVacation(String dept_code) {
		List<VacationVO> vacaList = dao.selectTeamVacation(dept_code);
		return vacaList;
	}

}
