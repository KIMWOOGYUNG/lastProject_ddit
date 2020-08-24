package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;
import lombok.ToString;


/**
 * @author 작성자명
 * @since 2020. 6. 29
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2020. 6. 29      박선정       최초작성
 * Copyright (c) 2020 by DDIT All right reserved
 * </pre>
 */
@Data
@ToString
public class AddressVO {//주소록
	
	private String add_code; //주소록코드
	private String emp_code; //사원코드
	
	private String add_name; //이름
	private String add_title; //직책명

	private String add_add; //주소
	private String add_hp; //핸드폰번호
	private String add_mail; //이메일

	private String add_etc; //비고
	private String ag_code; //주소록그룹코드

	private String ag_name; //소속
	List<Address_groupVO> addressGroupList;
	private String position_name;
	private String position_code;
	private String dept_code;
	private String dept_name;
	private String team_code;
	private String team_name;
	private String co_phone;
	private String add_favo_code;
	
	
	
	public AjaxdataAddressLineVO sendData() {
		AjaxdataAddressLineVO temp = new AjaxdataAddressLineVO();
		temp.setAdd_code(add_code);
		temp.setAddr_name(add_name);//이름
		temp.setAddr_phone(add_hp);//폰번호

		temp.setAddr_email(add_mail);//메일
		temp.setAddr_etc(add_etc); //비고
		temp.setAddr_address(add_add);//주소
		temp.setAddr_position(add_title);//직급
		temp.setAgname(ag_name);
		temp.setAdd_favo_code(add_favo_code);
		return temp;
	}
	
}
