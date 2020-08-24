package kr.or.ddit.project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.PJ_RgroupVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TaskVO;

@Repository
public interface ITaskListDAO {
	/**
	 * 새 일감 추가
	 * @param task
	 * @return
	 */
	public int insertTask(TaskVO task);
	/**
	 * 등록된 일감의 개수 구하기
	 * @param pagingVO
	 * @return
	 */
	public int selectTaskCount(PagingVO<TaskVO> pagingVO);
	/**
	 * 일감 목록을 리스트에 담기
	 * @param pagingVO
	 * @return
	 */
	public List<TaskVO> selectTaskList(PagingVO<TaskVO> pagingVO);
	/**
	 * 일감 하나를 선택해서 상세정보 가져오기
	 * @param task_code
	 * @return
	 */
	public TaskVO selectTask(String task_code);
	/**
	 * 일감 수정
	 * @param task
	 * @return
	 */
	public int updateTask(TaskVO task);
	/**일감 삭제
	 * @param task
	 * @return
	 */
	public int deleteTask(String task_code);
	
	/**일감에 pj_memcode를 넣기위해 사원코드로 구성원 코드를 조회
	 * @param emp_code
	 * @return
	 */
	public String selectPJ_Member(TaskVO task);
	
	/**일감 담당자 설정을 위한 팀원들 조회
	 * @param project_code
	 * @return
	 */
	public PJ_RgroupVO selectProjectMembers(String project_code);
	
	public String selectPrgCode(ProjectVO project);
	
	//일감 캘린더 조회
	public List<TaskVO> selectTaskCal(String project_code);
	
	//캘린더 일정 수정
	public int updateTaskCal(TaskVO task);
	
	//일감 간트 조회
	public List<TaskVO> selectTaskGantt(String project_code);
	
}
