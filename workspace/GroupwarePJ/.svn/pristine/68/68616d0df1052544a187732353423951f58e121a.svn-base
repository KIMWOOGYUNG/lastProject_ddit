package kr.or.ddit.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exception.DataNotFoundException;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.project.dao.IProjectListDAO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PJ_MemberVO;
import kr.or.ddit.vo.PJ_RgroupVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.Project_roleVO;
import kr.or.ddit.vo.TaskVO;

@Service
public class ProjectListServiceImpl implements IProjectListService {
	@Inject
	IProjectListDAO dao;
	
//프로젝트 등록----------------------------------------------------------------------------
	@Transactional
	@Override
	public ResultState insertProject(ProjectVO project) {
		ResultState result = null;
		
		//pj_rgroup의 pk세팅
		int prg_pk = dao.selectPRG_PK();		
		List<PJ_RgroupVO> pj_rgroupList = project.getPj_rgroupList();	
		if(pj_rgroupList != null) {
			for(int i = 0; i < pj_rgroupList.size(); i++) {
				pj_rgroupList.get(i).setPrg_code(String.format("PG%03d", prg_pk++));
			}
		}
		
		//프로젝트 insert
		int cnt = dao.insertProject(project);
		
		if(cnt > 0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		return result;
	}

//프로젝트 목록 조회--------------------------------------------------------------------------
	@Override
	public int selectProjectCount(PagingVO<ProjectVO> pagingVO) {
		return dao.selectProjectCount(pagingVO);
	}

	@Override
	public List<ProjectVO> selectProjectList(PagingVO<ProjectVO> pagingVO) {
		return dao.selectProjectList(pagingVO);
	}
	
	@Override
	public int selectPJProgress(String project_code) {
		return dao.selectPJProgress(project_code);
	}

//프로젝트 상세조회--------------------------------------------------------------------------
	@Override
	public ProjectVO selectProject(String project_code) {
		ProjectVO vo = dao.selectProject(project_code);
		if(vo == null) {
			throw new DataNotFoundException(project_code + "에 해당하는 프로젝트는 없음");
		}
		return vo;
	}

	@Override
	public int selectTMProgress(String pj_memcode) {
		return dao.selectTMProgress(pj_memcode);
	}

//프로젝트 수정-----------------------------------------------------------------------------
	@Transactional
	@Override
	public ResultState updateProject(ProjectVO project) {
		ResultState result = null;
		int cnt = dao.updateProject(project);
		//기존, 새거 비교해서 new의 pr_code가 old에 없다면 insert, old의 pr_code가 new에 없다면 delete
		
		//구성원 비교
		List<String> newRgroupList = new ArrayList<>();
		if(project.getPj_rgroupList() != null) {
			for(int i = 0; i < project.getPj_rgroupList().size(); i++) {
				newRgroupList.add(project.getPj_rgroupList().get(i).getPr_code());
			}
		}
		
		List<String> oldRgroupList = new ArrayList<>();
		List<PJ_RgroupVO> rgroupList = dao.selectProject(project.getProject_code()).getPj_rgroupList();
		for(int i = 0; i < rgroupList.size(); i++) {
			oldRgroupList.add(rgroupList.get(i).getPr_code());
		}
		
		//추가
		for(String newPr_code : newRgroupList) {
			if(!oldRgroupList.contains(newPr_code)) {
				PJ_RgroupVO newRgroup = new PJ_RgroupVO();
				newRgroup.setPr_code(newPr_code);
				newRgroup.setProject_code(project.getProject_code());
				cnt += dao.insertPJ_Rgroup(newRgroup);
			}
		}
		
		//삭제
		boolean memExist = false;
		for(String oldPr_code : oldRgroupList) {
			if(oldPr_code != null) {
				if(!newRgroupList.contains(oldPr_code)) {
					Map<String, String> map = new HashedMap<>();
					map.put("pr_code", oldPr_code);
					map.put("project_code", project.getProject_code());
					String pj_memcode = dao.selectPJ_Member(map);	//역할에 사원이 배정되었는지 확인
					if(pj_memcode == null) {
						cnt += dao.deletePJ_Rgroup(map);
					}else {
						memExist = true;
					}
				}
			}
		}
		
		if(memExist == true) {
			result = ResultState.CANNOTDELETE;
		}else {
			if(cnt > 0){
				result = ResultState.OK;
			}else {
				result = ResultState.FAIL;
			}
		}
		
		return result;
	}

//프로젝트 삭제
	@Override
	public ResultState deleteProject(String project_code) {
		ResultState result = null;
		int cnt = dao.deleteProject(project_code);
		if(cnt > 0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		return result;
	}

	@Override
	public List<ProjectVO> selectProjectListForTask(String emp_code) {
		return dao.selectProjectListForTask(emp_code);
	}

	@Override
	public List<EmployeeVO> selectEmpList(PagingVO<EmployeeVO> pagingVO) {
		return dao.selectEmpList(pagingVO);
	}

	@Override
	public int readEmpCount(PagingVO<EmployeeVO> pagingVO) {
		return dao.selectEmpCount(pagingVO);
	}

	@Override
	public List<Project_roleVO> selectRoleList() {
		return dao.selectRoleList();
	}

//팀 멤버 관리
	
	@Override
	public List<PJ_RgroupVO> selectPJ_Rgroup(String project_code) {
		return dao.selectPJ_Rgroup(project_code);
	}
	
	@Override
	public ResultState insertPJ_Member(PJ_MemberVO pjMember) {
		ResultState result = null;
		int cnt = 0;
		int exist = dao.memExist(pjMember);
		
		if(exist > 0) {
			cnt = dao.reinsertPJ_Member(pjMember);
		}else {
			cnt = dao.insertPJ_Member(pjMember);
		}
		
		if(cnt > 0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		return result;
	}

	@Override
	public String selectPJ_MemCode(PJ_MemberVO pj_member) {
		String result = null;
		String pj_memcode = dao.selectPJ_MemCode(pj_member);
		if(pj_memcode == null) {
			result = "해당하는 팀 멤버는 없습니다.";
		}else {
			result = pj_memcode;
		}
		return result;
	}

	@Override
	public ResultState deletePJ_Member(String pj_memcode) {
		ResultState result = null;
		int cnt = dao.outPJ_Member(pj_memcode);
		
		if(cnt > 0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		return result;
	}

	@Override
	public List<Map<String, String>> selectMonthlyProgress(String project_code) {
		return dao.selectMonthlyProgress(project_code);
	}

	@Override
	public List<TaskVO> selectRecentTaskList(String project_code) {
		return dao.selectRecentTaskList(project_code);
	}

}
