package kr.or.ddit.vo;

import lombok.Data;

@Data
public class CommonsAttatchFileVO {
	
	private String file_path;
	private Long file_size;
	private String org_name;
	private String save_name;
	private String mime;
	private String fancy_size;
	
}
