package kr.or.ddit.vo;

import java.util.UUID;

import javax.validation.constraints.NotNull;

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
public class Board_AttatchVO {//�Խù� ÷������
	
	public Board_AttatchVO(MultipartFile realFile) {
		super();
		this.realFile = realFile;
		org_name = realFile.getOriginalFilename();
		save_name = UUID.randomUUID().toString();
		mime = realFile.getContentType();
		file_size = realFile.getSize();
		fancy_size = FileUtils.byteCountToDisplaySize(file_size);
	}

	private MultipartFile realFile;
	
	@NotNull
	private String board_attcode;
	@NotNull
	private String board_code;
	@NotNull
	private String file_path;
	@NotNull
	private Long file_size;
	@NotNull
	private String org_name;
	@NotNull
	private String save_name;
	
	private String fancy_size;
	
	private String mime; 
}
