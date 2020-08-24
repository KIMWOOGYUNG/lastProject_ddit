package kr.or.ddit.main.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.main.dao.IindexDAO;

@Service
public class IndexService implements IindexService{
	
	@Inject
	IindexDAO dao;
	

	@Override
	public List<Map<String, Integer>> readNomal(String emp_code) {
		return dao.selectNomal(emp_code);
	}

	@Override
	public List<Map<String, Integer>> readLate(String emp_code) {
		return dao.selectLate(emp_code);
	}

}
