package kr.or.ddit.vo;

import lombok.Data;

@Data
public class Reviewer_StatVO {
	private String rs_code;
	private String draft_code;
	private String emp_code;
	private String rs_read;
	private String rs_type;
	
	EmployeeVO empVO;
}
