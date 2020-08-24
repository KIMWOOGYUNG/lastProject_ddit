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
public class ReviewerGroupVO {
	int rnum;
	private String rg_code;
	private String rg_name;
	private String emp_code;
	private String rg_type; //A:열람권자 , B:참조권자
	
	private List<EmployeeVO> reviewerList;
	public AjaxdataApprLineVO sendData() {
		AjaxdataApprLineVO lineVO = new AjaxdataApprLineVO();
		lineVO.setLine_code(rg_code);
		lineVO.setLine_name(rg_name);
		lineVO.setRnum(rnum);
		
		return lineVO;
	}
	
	List<ReviewerGroupVO> reviewGroupList;
	
	public AjaxdataApprLineVO sendEmpData() {
		AjaxdataApprLineVO lineVO = sendData();
		lineVO.setEmpList(reviewerList);
		return lineVO;
	}

	
}
