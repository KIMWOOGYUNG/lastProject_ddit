package kr.or.ddit.vo;

import lombok.Data;

/**
 * @author 작성자명
 * @since 2020. 7. 28
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2020. 7. 28      박선정       최초작성
 * Copyright (c) 2020 by DDIT All right reserved
 * </pre>
 */
@Data
public class Address_favoriteVO {///즐겨찾기 
	private String add_favo_code; //즐찾코드
	private String emp_code; //사원코드
	
	private String add_favo_name; //즐찾명
}