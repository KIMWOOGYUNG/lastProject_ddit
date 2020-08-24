package kr.or.ddit.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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
public class Work_ReportVO {//��������

	private int rnum;
	private String report_code;
	private String report_title;
	private String emp_reporter;
	private String emp_target;
	private String report_date;
	private String wl_code;
	private String team_code;
	private String report_stat;
	private String report_content;
	
	
	private String report_sign;
	private String target_sign;
	
	List<Report_AttVO> report_attList;
	
	List<WorkLog_AttatchVO> wlattList;
	private MultipartFile[] re_files;
	
	
	public void setRe_files(MultipartFile[] re_files) {
		this.re_files = re_files;
		if(re_files == null || re_files.length == 0) return;
		report_attList = new ArrayList<>();
		for(MultipartFile reFile : re_files) {
			if(StringUtils.isBlank(reFile.getOriginalFilename())) continue;
			report_attList.add(new Report_AttVO(reFile));
		}
	}


	private String[] deleteAttatches;
	
}