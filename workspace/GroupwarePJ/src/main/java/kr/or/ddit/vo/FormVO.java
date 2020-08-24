package kr.or.ddit.vo;

import javax.validation.constraints.NotNull;

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
public class FormVO {//���

	private int rnum;
	@NotNull
	private String form_code;
	@NotNull
	private String fc_code;
	@NotNull
	private String form_name;
	@NotNull
	private String form_content;
	
	private String fc_name;
	
}
