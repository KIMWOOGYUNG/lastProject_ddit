package kr.or.ddit.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hpsf.Date;

import com.nimbusds.oauth2.sdk.util.StringUtils;

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
public class Com_ScheduleVO {//회사일정

	private String cs_code;
	private String cs_catag;
	private String cs_title;
	private String cs_content;
	private String cs_startdate;
	private String cs_enddate;
	private String emp_code;
	private String cs_important;
	
	private String emp_kor;

	public CalendarVO sendDate() {
		CalendarVO temp = new CalendarVO();
			
			temp.setCs_catag(cs_catag);
			temp.setCs_important(cs_important);
			temp.setTitle(cs_title);
			temp.setId(emp_kor);
			temp.setStart(cs_startdate);
			temp.setContent(cs_content);
			

			
			Calendar date = Calendar.getInstance();
			int year = Integer.parseInt(cs_enddate.substring(0, 4));
			int month = Integer.parseInt(cs_enddate.substring(5, 7))-1;
			int day = Integer.parseInt(cs_enddate.substring(8, 10));
			date.set(year, month, day);
			
			date.set(Calendar.DATE, date.get(Calendar.DAY_OF_MONTH)+1);
			
			SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			cs_enddate = format1.format(date.getTime());
			
			temp.setEnd(cs_enddate);
			
			if(cs_important.equals("IMP100")) {
				temp.setColor("#fa6c5c");
			}else if(cs_important.equals("IMP200")) {
				temp.setColor("#fff345");
			}else {
				temp.setColor("#30b0ff");
			}
			return temp;
	}
	
}