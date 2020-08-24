package kr.or.ddit.project.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.TaskVO;
import kr.or.ddit.vo.Task_AttVO;

@Repository
public interface ITaskAttatchDAO {
	public int insertAttatchs(Task_AttVO task_attVO);
	public Task_AttVO selectAttatch(String task_attcode);
	public int deleteAttatches(TaskVO task);
}
