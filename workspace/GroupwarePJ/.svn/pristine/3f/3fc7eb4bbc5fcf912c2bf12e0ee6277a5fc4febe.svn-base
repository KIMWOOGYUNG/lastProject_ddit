package kr.or.ddit.login_logout.service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.EmployeeVO;

public interface ILoginService {
	public EmployeeVO checkEmployeeCode(EmployeeVO employeeVO);
	
	//face로그인을 위한 회원정보가져오기(emp_code, emp_pass, emp_kor정도) 
	public EmployeeVO getEmpLoginInfo(EmployeeVO employeeVO);
	
    public EmployeeVO checkEmpMail(String emp_code);
	
    public ResultState changeEmpPassword(EmployeeVO employeeVO);
    
    //강현철
    public EmployeeVO getEmpInfo(EmployeeVO employeeVO);
}
