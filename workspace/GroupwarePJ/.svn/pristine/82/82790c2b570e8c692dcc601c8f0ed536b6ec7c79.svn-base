package kr.or.ddit.hr_admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TeamVO;

@Repository
public interface IAdminTeamDAO {

	
	public List<TeamVO> selectTeammanageList(PagingVO<TeamVO>pagingVO);
	
	public int selectTeammanageCount(PagingVO<TeamVO> pagingVO);

	public int deleteteam(String team_code);
	
	public int insertTeam(TeamVO team);
	
	public int updateteam(TeamVO team);
	
	
}
