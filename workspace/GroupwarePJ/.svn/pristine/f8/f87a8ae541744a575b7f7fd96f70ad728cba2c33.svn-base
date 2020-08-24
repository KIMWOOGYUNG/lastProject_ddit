package kr.or.ddit.hr_admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.PagingVO;

@Repository
public interface IAdminDepartDAO {

	public List<DepartmentVO>selectDepmanageList(PagingVO<DepartmentVO>pagingVO);
	
	public int selectDepmanageCount(PagingVO<DepartmentVO> pagingVO);
	
	public List<DepartmentVO>selectDeptList(PagingVO<DepartmentVO>pagingVO);
	
	public int insertdept(DepartmentVO department);
	
	public int deletedept(String dept_code);
	
	public int updatedept(DepartmentVO department);
	
	public int updateteam(DepartmentVO department);
	
}


