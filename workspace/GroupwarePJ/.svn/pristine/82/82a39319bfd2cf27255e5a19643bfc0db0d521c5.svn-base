package kr.or.ddit.project.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PJ_MemberVO;
import kr.or.ddit.vo.PJ_RgroupVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.Project_roleVO;
import kr.or.ddit.vo.TaskVO;

public interface IProjectListService {
//프로젝트 추가---------------------------------------------------------------------------------
	
	public ResultState insertProject(ProjectVO project);	//새 프로젝트 추가
	public List<Project_roleVO>selectRoleList();	//역할 조회
	
//팀 멤버 관리----------------------------------------------------------------------------------
	
	public List<PJ_RgroupVO>selectPJ_Rgroup(String project_code);	//프로젝트의 역할 구성 조회
	
	public int readEmpCount(PagingVO<EmployeeVO> pagingVO);	//사원 수
	public List<EmployeeVO>selectEmpList(PagingVO<EmployeeVO> pagingVO);	//멤버로 추가하기 위해 사원 리스트 조회
	
	public ResultState insertPJ_Member(PJ_MemberVO pjMember);	//멤버 추가
	public String selectPJ_MemCode(PJ_MemberVO pj_member);	//삭제할 멤버의 pj_memcode 조회
	public ResultState deletePJ_Member(String pj_memcode);	//멤버 삭제
	
//프로젝트 목록 조회------------------------------------------------------------------------------

	public int selectProjectCount(PagingVO<ProjectVO> pagingVO);	//프로젝트의 개수 구하기
	public List<ProjectVO> selectProjectList(PagingVO<ProjectVO> pagingVO);	//프로젝트 목록 조회
	public int selectPJProgress(String project_code);	//프로젝트 진척도 조회
	
//프로젝트 상세 조회------------------------------------------------------------------------------

	public ProjectVO selectProject(String project_code);	//해당 프로젝트 상세 조회
	public int selectTMProgress(String pj_memcode);	//멤버별 진척도 조회
	public List<Map<String, String>> selectMonthlyProgress(String project_code); //월별 진척도 차트
	public List<TaskVO> selectRecentTaskList(String project_code);	//프로젝트의 최근 일감 조회

//프로젝트 수정---------------------------------------------------------------------------------
	
	public ResultState updateProject(ProjectVO project);
	
//프로젝트 삭제---------------------------------------------------------------------------------

	public ResultState deleteProject(String project_code);
	
//사원의 프로젝트 목록-----------------------------------------------------------------------------
	
	public List<ProjectVO>selectProjectListForTask(String emp_code);	//일감 등록시 사원의 프로젝트 목록 조회
	
}
