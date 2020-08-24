package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class Address_groupVO {//거래처
	
	private String ag_code; //거래처코드
	private String ag_name; //거래처명
	private String emp_code; //사원코드
}
