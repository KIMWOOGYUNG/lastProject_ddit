package kr.or.ddit.hr_admin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.dao.IAdminTeamDAO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TeamVO;

@Service
public class AdminTeamServiceImpl implements IAdminTeamService {
	
	@Inject
	IAdminTeamDAO adminteamDAO;

	@Override
	public List<TeamVO> selectTeammanageList(PagingVO<TeamVO> pagingVO) {
		return adminteamDAO.selectTeammanageList(pagingVO);
	}

	@Override
	public int selectTeammanageCount(PagingVO<TeamVO> pagingVO) {
		return adminteamDAO.selectTeammanageCount(pagingVO);
	}

	@Override
	public int deleteteam(String team_code) {
		return adminteamDAO.deleteteam(team_code);
	}

	@Override
	public ResultState insertTeam(TeamVO team) {
		int cnt = adminteamDAO.insertTeam(team);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}

	@Override
	public ResultState updateteam(TeamVO team) {
		int cnt = adminteamDAO.updateteam(team);
		cnt += adminteamDAO.updateteam(team);
		ResultState result = ResultState.FAIL;
		if(cnt>0) result = ResultState.OK;
		return result;
	}

}
