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
public class Com_PolicyVO {//회사정책
	private String com_no;
	private String com_name;
	private String com_corp;
	private String corp_no;
	private String com_catag;
	private String com_ceo;
	private String com_zip;
	private String com_add1;
	private String com_add2;
	private String com_phone;
	private String com_fax;
	private String com_mail;
	private String founding_date;
	private String come_time;
	private String leave_time;
	private String mor_half_start;
	private String mor_half_end;
	private String aft_half_start;
	private String aft_half_end;

	List<Image_AttatchVO> imageList;
	

}
