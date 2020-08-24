package kr.or.ddit.main.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.ProjectVO;

@Repository
public interface IindexDAO {
	// 근태 정상출근 통계
	public List<Map<String, Integer>> selectNomal(String emp_code);
	
	// 근태 지각 통계 
	public List<Map<String, Integer>> selectLate(String emp_code);
	
	// 공지사항 최근 4개만 가져오기
	public List<BoardVO> selectNotice();
	
	// 내 최근 프로젝트 가져오기
	public ProjectVO selectProject(String project_code);
	
	// 진척도
	public int selectPJProgress(String project_code);
	
}
