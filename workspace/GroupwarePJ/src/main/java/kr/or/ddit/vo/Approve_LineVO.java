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
public class Approve_LineVO {//결재라인
	private int rnum;
	private String appr_line_code;
	private String appr_line;
	private String emp_code;
	
	private List<EmployeeVO> orderList;
	
	public AjaxdataApprLineVO sendData() {
		AjaxdataApprLineVO lineVO = new AjaxdataApprLineVO();
		lineVO.setLine_code(appr_line_code);
		lineVO.setLine_name(appr_line);
		lineVO.setRnum(rnum);
		return lineVO;
	}
	
	public AjaxdataApprLineVO sendEmpData() {
		AjaxdataApprLineVO lineVO = sendData();
		lineVO.setEmpList(orderList);
		return lineVO;
	}
}
