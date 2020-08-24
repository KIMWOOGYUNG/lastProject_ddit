package kr.or.ddit.hr_admin.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TeamVO;

public interface IAdminTeamService {
	/**
	 * 팀 현황 목록 테이블
	 * @param pagingVO
	 * @return
	 */
	public List<TeamVO> selectTeammanageList(PagingVO<TeamVO>pagingVO);
	/**
	 * 등록된 팀 개수 구하기
	 * @param pagingVO
	 * @return
	 */
	public int selectTeammanageCount(PagingVO<TeamVO> pagingVO);
	
	
	public int deleteteam(String team_code);
	
	
	public ResultState insertTeam(TeamVO team);
	
	public ResultState updateteam(TeamVO team);
}
