package kr.or.ddit.hr_admin.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Image_AttatchVO;
import kr.or.ddit.vo.PagingVO;

public interface IAdminEmployService {
	/**
	 * 전 사원 목록을 리스트에 담기
	 * @param pagingVO
	 * @return
	 */
	public List<EmployeeVO> selectEmpmanageList(PagingVO<EmployeeVO>pagingVO);
	/**
	 * 사원 한명을 선택해서 상세정보 가져오기
	 * @param emp_code
	 * @return
	 */
	public EmployeeVO selectEmpmanage(String emp_code);
	/**
	 * 등록된 사원 수 구하기
	 * @param pagingVO
	 * @return
	 */
	public int selectEmpmanageCount(PagingVO<EmployeeVO> pagingVO);
	/**
	 * 신규 사원 등록
	 * @param employeevo
	 * @return
	 */
	public ResultState insertEmp(EmployeeVO employee);
	/**
	 * 사원 삭제
	 * @param emp_code
	 * @return
	 */
//	public int deleteEmp(String emp_code);
	/**
	 * 사원 수정
	 * @param employee
	 * @return
	 */
	public ResultState updateEmp(EmployeeVO employee);
	/**
	 * 사원 등록할때 사원코드 보이기
	 * @param emp_code
	 * @return
	 */
	public String selectCode();
	
	
	
	/**
	 * 사원이미지 등록
	 * @param image_AttatchVO
	 * @return
	 */
	public ResultState insertEmpImage(Image_AttatchVO image_AttatchVO);
	
	
	public ResultState updateEmpImage(Image_AttatchVO image_AttatchVO);
	public ResultState deleteEmpImage(String emp_attcode);
	public Image_AttatchVO selectImage(String emp_attcode);
	
	
	
	
	
	
	
}
