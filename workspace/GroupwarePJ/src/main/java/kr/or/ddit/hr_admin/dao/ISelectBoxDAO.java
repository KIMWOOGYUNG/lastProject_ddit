package kr.or.ddit.hr_admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.TeamVO;

@Repository
public interface ISelectBoxDAO {
	public List<Map<String, Object>> selectDeptList();
	public List<TeamVO> selectTeamList(@Param("teamdept") String dept_code);
}
