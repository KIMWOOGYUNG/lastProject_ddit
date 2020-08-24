package kr.or.ddit.approval.dao;

import kr.or.ddit.vo.CommonsAttatchFileVO;

public interface IPublicFormAttatchDAO {
	public int insertAttatchs(CommonsAttatchFileVO commensAttatchVO);
	
	public CommonsAttatchFileVO selectAttatch(String form_attcode);
}
