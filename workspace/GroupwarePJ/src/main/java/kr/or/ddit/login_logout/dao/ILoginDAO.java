package kr.or.ddit.login_logout.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.EmployeeVO;

/**
 * 
 * @author 박혜진
 * @since 2020. 7. 25
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2020. 7. 25      박혜진         추가
 * Copyright (c) 2020 by DDIT All right reserved
 * </pre>
 */
@Repository
public interface ILoginDAO {
	public EmployeeVO selectEmpLoginCheck(EmployeeVO employeeVO); //넘겨줄것
	
	public EmployeeVO selectEmpMail(String emp_code); //비밀번호찾기 
	
	public int updateEmpPassword(EmployeeVO employeeVO); //임시비밀번호로 변경해주기
	
	public EmployeeVO selectEmpLoginInfo(String personId); //얼굴인식로그인

	public EmployeeVO selectEmployee(EmployeeVO employeeVO); //강현철
}