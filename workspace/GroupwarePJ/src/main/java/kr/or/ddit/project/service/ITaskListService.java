package kr.or.ddit.project.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TaskVO;
import kr.or.ddit.vo.Task_AttVO;

public interface ITaskListService {
	
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
	 * 새 일감 추가
	 * @param task
	 * @return
	 */
	public ResultState insertTask(TaskVO task);
	
	/**
	 * 일감 수정
	 * @param task
	 * @return
	 */
	public ResultState updateTask(TaskVO task);
	
	/**일감 삭제
	 * @param task
	 * @return
	 */
	public ResultState deleteTask(TaskVO taskVO);
	
	/**일감에 pj_memcode를 넣기위해 사원코드로 구성원 코드를 조회
	 * @param emp_code
	 * @return
	 */
	public String selectPJ_Member(TaskVO taskVO);
	
	/**첨부파일 다운로드
	 * @param att_no
	 * @return
	 */
	public Task_AttVO downloadAttatch(String task_attcode);
	
	public String selectPrgCode(ProjectVO project);
	
	//일감캘린더
	public List<TaskVO> selectTaskCal(String project_code);
	
	//캘린더 일정 수정
	public ResultState updateTaskCal(TaskVO task);
	
	//일감 간트 조회
	public List<TaskVO> selectTaskGantt(String project_code);
}
