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
public class Ta_CatagVO {//근태카테고리

	private String ta_catag_code;
	private String ta_catag_name;
}
