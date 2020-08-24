package kr.or.ddit.hr_admin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.dao.IAdminDepartDAO;
import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class AdminDepartServiceImpl implements IAdminDepartService {

	@Inject
	IAdminDepartDAO admindepartDAO;
	
	@Override
	public List<DepartmentVO> selectDepmanageList(PagingVO<DepartmentVO> pagingVO) {
		return admindepartDAO.selectDepmanageList(pagingVO);
	}

	@Override
	public int selectDepmanageCount(PagingVO<DepartmentVO> pagingVO) {
		return admindepartDAO.selectDepmanageCount(pagingVO);
	}


	@Override
	public ResultState insertdept(DepartmentVO department) {
		int cnt = admindepartDAO.insertdept(department);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}

	@Override
	public List<DepartmentVO> selectDeptList(PagingVO<DepartmentVO> pagingVO) {
		return admindepartDAO.selectDeptList(pagingVO);
	}

	@Override
	public int deletedept(String dept_code) {
		return admindepartDAO.deletedept(dept_code);
	}

	@Override
	public ResultState updatedept(DepartmentVO department) {
		int cnt = admindepartDAO.updatedept(department);
		cnt += admindepartDAO.updateteam(department);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}


	
	
	
}
