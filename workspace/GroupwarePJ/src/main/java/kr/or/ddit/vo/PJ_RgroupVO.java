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
public class PJ_RgroupVO {//������Ʈ ���ұ���
	
	private String prg_code;
	private String pr_code;
	private String project_code;
	
	
	private String pr_name;	//ROLE_NAME
	List<PJ_MemberVO> pj_memberList;
	
	
}
