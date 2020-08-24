package kr.or.ddit.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * 
 * @author 박혜진
 * @since 2020. 7. 27
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2020. 7. 27      박혜진        FACEID추가
 * Copyright (c) 2020 by DDIT All right reserved
 * </pre>
 */
@Data
@ToString
@EqualsAndHashCode(of = { "emp_code","emp_pw" })
@NoArgsConstructor
public class EmployeeVO {//���
	private int rnum; //글번호
	
	public EmployeeVO(String emp_code, String emp_pw) {
	super();
	this.emp_code = emp_code;
	this.emp_pw = emp_pw;
	}
	
	private String emp_code;
	private String emp_pw;
	private String emp_kor;
	private String emp_eng;
	private String emp_reg1;
	private String emp_reg2;
	private String emp_mail;
	private String emp_hp;
	private String co_phone;
	private String emp_zip;
	private String emp_add1;
	private String emp_add2;
	private String emp_startdate;
	private String team_code;
	private String emp_ip;
	private String emp_ip2;
	private Integer emp_sal;
	private String long_vacation;
	private String retire_date;
	private Integer vaction_cnt;
	private String dept_code;
	private String dept_name; //부서명
	private String jobtitle_code;
	private String position_code;
	private String position_name; // 직책명 
	private String emp_arbitrary;
	private String jobtitle_name;//직위명
	private String team_name;//팀명
	
	private String img100;//도장주소
	private String img200;//사인주소
	private String img300;//사진주소
	
	private String personid; //얼굴인식 로그인을 위한 personid 
	private String persistedfaceid; //얼굴인식 로그인을 위한 faceid 
	private String subfaceid; //대체얼굴등록
	
	private String faceid1; //faceid유무
	private String faceid2; //대체얼굴유무
	private String emp_attcode; //faceid상세페이지에서 회원얼굴보여주기위함
	private String msg_code;
	private String add_etc;
	private String add_code;
	
	
	public void settingImage(List<Image_AttatchVO> imgList) {
		if(imgList != null)
		for(Image_AttatchVO vo :imgList) {
			if(vo.getImg_catag().equals("IMG100")) img100 = vo.getEmp_attcode();
			else if(vo.getImg_catag().equals("IMG200")) img200 = vo.getEmp_attcode();
			else if(vo.getImg_catag().equals("IMG300")) img300 = vo.getEmp_attcode();
		}
	}
	
	List<Approve_LineVO> approve_LineList;
	List<ReviewerGroupVO> reviewerGroupList;
	
	List<Image_AttatchVO> image_attList;
	
	private MultipartFile[] image_file;
	
	public void setimage_file(MultipartFile[] image_file) {
		this.image_file = image_file;
		if(image_file == null || image_file.length == 0) return;
		image_attList = new ArrayList<>();
		for(MultipartFile image_file1 : image_file) {
			if(StringUtils.isBlank(image_file1.getOriginalFilename())) continue;
			image_attList.add(new Image_AttatchVO());
		}
	}
	
	private MultipartFile img1;
	
	
}