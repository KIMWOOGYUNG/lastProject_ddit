package kr.or.ddit.vo;

import java.util.List;

import com.nimbusds.oauth2.sdk.util.StringUtils;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @author 박혜진
 * @since 2020. 7. 23
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2020. 7. 23      박혜진       최종수정
 * Copyright (c) 2020 by DDIT All right reserved
 * </pre>
 */
@Data
@ToString
public class Com_WorkStdVO {//근무기준

	private String cws_code;
	private String year;
	private String month;
	private String day;
	private String cws_name;
	private String cws_subname;
	private String cws_catag;
	private String cws_etc;
	private String standard_name;
	List<Com_WorkStdVO> comVacaList;
	
	public CalendarVO sendDate() {
		CalendarVO temp = new CalendarVO();
		if(StringUtils.isNotBlank(cws_subname)) {
			temp.setTitle(cws_name+","+cws_subname);
		}else {
			temp.setTitle(cws_name);
		}
		if("CWS300".equals(cws_catag)) {//공휴일일때
			temp.setColor("#ed7289");
			temp.setId(standard_name);
		}else {
			temp.setColor("#7698de");
			temp.setId(standard_name);
		}
		temp.setStart(year+"-"+month+"-"+day);
		temp.setEnd(year+"-"+month+"-"+day);
		
		return temp;
	}
	
}
