package kr.or.ddit.project.controller.advice;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import kr.or.ddit.project.service.IProjectListService;
import kr.or.ddit.vo.ProjectVO;

@ControllerAdvice(basePackages = "kr.or.ddit.project.controller")
public class ProjectReadControllerAdvice {
	
	@Inject
	IProjectListService service;
	
	@ModelAttribute(name="projectCommon")
	public ProjectVO asd(@PathVariable(required = false) String project_code) {
		if(project_code != null && !project_code.isEmpty() && !"allProject".equals(project_code)) {
			ProjectVO vo = service.selectProject(project_code);
			return vo;
		}else {
			return null;
			
		}
		
	}
}
