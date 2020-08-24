package kr.or.ddit.schedule.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.StandardVO;

@Repository
public interface IDepStandardDAO {

	//중요도 선택
		public List<StandardVO> selectimportant();
		
	//담당자 선택
		public List<EmployeeVO> selectmanager();
		
	
}
