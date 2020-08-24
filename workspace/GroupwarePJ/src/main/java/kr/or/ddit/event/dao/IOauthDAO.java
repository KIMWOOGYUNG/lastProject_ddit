package kr.or.ddit.event.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface IOauthDAO {
	public String selectCode(String emp_code);
	public String selectId(String emp_code);
	public int modifyCode(Map<String,String> code);
}
