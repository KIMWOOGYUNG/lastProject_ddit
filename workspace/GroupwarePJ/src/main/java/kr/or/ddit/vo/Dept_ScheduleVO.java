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
public class Dept_ScheduleVO {//�μ�����

	private String ds_code;
	private String ds_title;
	private String ds_content;
	private String writer;
	private String manager;
	private String ds_start;
	private String ds_end;
	private String ds_important;
	private String project_code;
	
	
	private String writer_name;
	private String manager_name;
	private String dept_code;
	
	private String emp_kor;
	
	List<ProjectVO> projectList;
	
	
	public CalendarVO sendDate() {
		CalendarVO temp = new CalendarVO();
		
			temp.setTitle(ds_title);
			temp.setId(emp_kor);
			temp.setStart(ds_start);
			
			Calendar date = Calendar.getInstance();
			int year = Integer.parseInt(ds_end.substring(0, 4));
			int month = Integer.parseInt(ds_end.substring(5, 7))-1;
			int day = Integer.parseInt(ds_end.substring(8, 10));
			date.set(year, month, day);
			
			date.set(Calendar.DATE, date.get(Calendar.DAY_OF_MONTH)+1);
			
			SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			ds_end = format1.format(date.getTime());
			
			temp.setEnd(ds_end);
			
			temp.setContent(ds_content);
			temp.setDs_important(ds_important);
			temp.setManager(manager);
			temp.setManager_name(manager_name);
			if(ds_important.equals("IMP100")) {
				temp.setColor("#fa6c5c");
			}else if(ds_important.equals("IMP200")) {
				temp.setColor("#fff345");
			}else {
				temp.setColor("#30b0ff");
			}
			return temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
