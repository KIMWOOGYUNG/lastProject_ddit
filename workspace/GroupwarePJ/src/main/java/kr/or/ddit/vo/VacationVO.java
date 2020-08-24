package kr.or.ddit.vo;

import java.text.SimpleDateFormat;
import java.util.List;

import com.nimbusds.oauth2.sdk.util.StringUtils;

import lombok.Data;
import lombok.ToString;

/**
 * @author �ۼ��ڸ�
 * @since 2020. 6. 29
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * 
 *      <pre>
 * [[�����̷�(Modification Information)]]
 * ������                          ������               ��������
 * --------     --------    ----------------------
 * 2020. 6. 29      �ڼ���       �����ۼ�
 * Copyright (c) 2020 by DDIT All right reserved
 *      </pre>
 */
@Data
@ToString
public class VacationVO {// �ް�
	
	private String vc_catag;
	private String emp_code;
	private String cws_code;
	private String position_name; // 사용
	private String dept_name;
	private String dept_code;
	private String emp_kor;// 사용
	private String position_code;
	
	private String draft_code;// 사용
	private String draft_stat;// 사용
	private String vc_name;// 사용
	
	List<VacationVO> vacalist;
	
	public CalendarVO sendDate() {
		CalendarVO temp = new CalendarVO();
		// 부서휴가일떄
		if(StringUtils.isNotBlank(dept_code)) {
			temp.setTitle(emp_kor+position_name+"휴가");
			//직급에 따라 다른 색상
			if("PO001".equals(position_code)) {
				temp.setColor("#ebafab");
			}else if("PO002".equals(position_code)) {
				temp.setColor("#86a7db");
			}else if("PO003".equals(position_code)) {
				temp.setColor("#b8e69a");
			}else if("PO004".equals(position_code)) {
				temp.setColor("#e6cf9a");
			}else if("PO005".equals(position_code)) {
				temp.setColor("#c396d9");
			}else {
				temp.setColor("#afbccc");
			}
		}else {// 내휴가일때
			temp.setTitle(emp_kor+"님 휴가");
			temp.setColor("skyblue");
		}
		
		temp.setStart(cws_code);
		temp.setEnd(cws_code);
		return temp;
	}
}