package kr.or.ddit.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.project.service.ITaskListService;
import kr.or.ddit.vo.TaskVO;

@Controller
public class ProjectGanttController {
	@Inject
	ITaskListService service;
	
	//간트 페이지
	@GetMapping("/project/projectplan/{project_code}/ganttchart")
	public String projectGantt(@PathVariable String project_code, Model model) {
		List<TaskVO> taskList = service.selectTaskGantt(project_code);
		model.addAttribute("taskList", taskList);
		return "projectGantt.project";
	}
	
	//일감 리스트 조회
	@PostMapping(value="/project/projectplan/{project_code}/ganttList")
	@ResponseBody
	public List<TaskVO> ganttList(@PathVariable String project_code ) {
		List<TaskVO> taskList = service.selectTaskGantt(project_code);
		return taskList;
	}
	
	//일감 상세조회
	@GetMapping(value="/project/projectplan/{project_code}/ganttEach", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public TaskVO ganttEach(String task_code, @PathVariable String project_code) {
		TaskVO task = service.selectTask(task_code);
		return task;
	}
	
	//드래그시 일정 업데이트
	@PostMapping(value="/project/projectplan/{project_code}/updateGantt", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String modifyDate(String task_code, String task_start, String task_end) {
		String returnStr = null;
		
		TaskVO task = service.selectTask(task_code);
		task.setTask_start(task_start);
		task.setTask_end(task_end);
		ResultState result = service.updateTaskCal(task);
		if(result == ResultState.OK) {
			returnStr = "일정이 변경되었습니다.";
		}else if (result == ResultState.FAIL) {
			returnStr = "일정 변경에 실패하였습니다. 잠시 후 다시 시도해주세요.";
		}
		return returnStr;
	}
}
