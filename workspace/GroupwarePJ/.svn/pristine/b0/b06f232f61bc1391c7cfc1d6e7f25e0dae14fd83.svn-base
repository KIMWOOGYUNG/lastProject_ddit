package kr.or.ddit.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import lombok.Data;
import lombok.ToString;


/**
 * @author �ۼ��ڸ�
 * @since 2020. 6. 29
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[�����̷�(Modification Information)]]
 * ������                          ������               ��������
 * --------     --------    ----------------------
 * 2020. 6. 29      �ڼ���       �����ۼ�
 * Copyright (c) 2020 by DDIT All right reserved
 * </pre>
 */
@Data
@ToString
public class My_ScheduleVO {//������

	private String ms_code;
	private String ms_title;
	private String ms_content;
	private String emp_code;
	private String ms_startdate;
	private String ms_enddate;
	private String ms_important;
	
	private String emp_kor;
	
	
	List<ProjectVO> projectList;
	


	public CalendarVO sendDate() {
		CalendarVO temp = new CalendarVO();
		
			temp.setTitle(ms_title);
			temp.setId(emp_kor);
			temp.setStart(ms_startdate);
			
//			temp.setEnd(ms_enddate.replace("00:00:00.0", "23:59:59.0"));
			
			Calendar date = Calendar.getInstance();
			int year = Integer.parseInt(ms_enddate.substring(0, 4));
			int month = Integer.parseInt(ms_enddate.substring(5, 7))-1;
			int day = Integer.parseInt(ms_enddate.substring(8, 10));
			date.set(year, month, day);
			
			date.set(Calendar.DATE, date.get(Calendar.DAY_OF_MONTH)+1);
			SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			ms_enddate = format1.format(date.getTime());
			
			temp.setEnd(ms_enddate);
			
			temp.setMs_important(ms_important);
			temp.setContent(ms_content);
			if(ms_important.equals("IMP100")) {
				temp.setColor("#fa6c5c");
			}else if(ms_important.equals("IMP200")) {
				temp.setColor("#fff345");
			}else {
				temp.setColor("#30b0ff");
			}
			return temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
