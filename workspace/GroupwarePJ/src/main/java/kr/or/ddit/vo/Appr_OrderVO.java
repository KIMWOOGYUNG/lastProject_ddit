package kr.or.ddit.vo;


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
public class Appr_OrderVO {//결재라인순서

	private String appr_order_code;
	private String emp_code;
	private String appr_line_code;
	

	
}