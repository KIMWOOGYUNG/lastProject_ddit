package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;
import lombok.ToString;


/**
 * @author 작성자명
 * @since 2020. 6. 29
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2020. 6. 29      박선정       최초작성
 * Copyright (c) 2020 by DDIT All right reserved
 * </pre>
 */
@Data
@ToString
public class DraftVO {//기안서

	private String draft_code;
	private String draft_date;
	private String emp_code;
	private String preserve_period;
	private String draft_title;
	private String draft_content;
	private String draft_stat;
	private String draft_pos;
	private String draft_instead_emp;
	private String emp_kor;
	private String form_code;
	private String fc_code;
	EmployeeVO empVO;
	EmployeeVO insteadEmpVO;
	
	private String appr_stat_catag;
	
	List<Draft_AttatchVO> attatchList;
	
	List<Appr_StatVO> apprList;
	List<Reviewer_StatVO> rg1List;
	List<Reviewer_StatVO> rg2List;
	
}
