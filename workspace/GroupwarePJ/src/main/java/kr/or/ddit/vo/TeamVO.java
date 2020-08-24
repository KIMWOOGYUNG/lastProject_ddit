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
public class TeamVO {//��

	private String team_code;
	private String team_name;
	private String dept_code;
	private int team_cnt;
	List<WorkLogVO> worklogList;
	List<EmployeeVO> empList;
	
	
}