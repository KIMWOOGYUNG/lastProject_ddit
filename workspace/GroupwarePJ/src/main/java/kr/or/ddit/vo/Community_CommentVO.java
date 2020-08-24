package kr.or.ddit.vo;

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
public class Community_CommentVO {//Ŀ�´�Ƽ���

	private String commu_cmt_code;
	private String board_code;
	private String commu_cmt_content;
	private String commu_cmt_date;
	private String commu_cmt_del;
}
