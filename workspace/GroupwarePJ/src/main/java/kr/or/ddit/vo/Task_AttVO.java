package kr.or.ddit.vo;

import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class Task_AttVO {//일감 첨부파일
	
	public Task_AttVO(MultipartFile realFile) {
		super();
		this.realFile = realFile;
		org_name = realFile.getOriginalFilename();
		save_name = UUID.randomUUID().toString();
		file_size = realFile.getSize();
		mime = realFile.getContentType();
		fancy_size = FileUtils.byteCountToDisplaySize(file_size);
	}

	private String task_attcode;
	private String task_code;
	private String file_path;
	private Long file_size;
	private String org_name;
	private String save_name;
	private String fancy_size;
	private String mime; 
	
	MultipartFile realFile;
}
