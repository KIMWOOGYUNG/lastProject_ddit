package kr.or.ddit.project.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.or.ddit.project.service.ITaskListService;
import kr.or.ddit.vo.Task_AttVO;

@Controller
public class TaskFileDownloadController {
	
	@Inject
	ITaskListService service;
	
	@GetMapping("/task/file/{task_attcode}")
	public String download(@PathVariable(required = true) String task_attcode, Model model)  {
		Task_AttVO attatch = service.downloadAttatch(task_attcode);
		
		model.addAttribute("attatch", attatch);
		
		return "downLoadView";
	}
}
