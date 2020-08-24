package kr.or.ddit.vo;

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
public class ProjectVO { //������Ʈ

	private int rnum;
	private String project_code;
	private String dept_code;
	private String project_name;
	private String project_content;
	private String project_sum;
	private String project_start;
	private String project_end;
	private Integer project_progress;
	private String project_stat;
	private String project_important;
	private String project_hide;
	
	List<PJ_RgroupVO> pj_rgroupList; //������Ʈ ���ұ���
	List<DepartmentVO> deptList;
	String stat_name; //status
	String import_name; //important
	String dept_name;	//DEPARTMENT TABLE
	String emp_code; // detailSearch용
	
	
	
	
//	List<Dept_ScheduleVO> dept_scheduleList;
//	String pr_name;
	
	
}