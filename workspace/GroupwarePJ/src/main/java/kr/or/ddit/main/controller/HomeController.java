package kr.or.ddit.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.main.dao.IindexDAO;
import kr.or.ddit.main.service.IindexService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.ProjectVO;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Inject
	private IindexService service;
	
	@Inject
	private IindexDAO dao;
	
		@GetMapping("index")
		public String index(HttpSession session, Model model) {
			EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("authUser");
			
			// 근태 바차트
			List<Map<String, Integer>> NomalList = service.readNomal(employeeVO.getEmp_code());
			List<Map<String, Integer>> LateList = service.readLate(employeeVO.getEmp_code());
			
			List<String> nomal = new ArrayList<>();
			List<String> late = new ArrayList<>();
			
			for(int i = 0; i <NomalList.size(); i++ ) {
				nomal.add(String.valueOf(NomalList.get(i).get("COUNT")));
			}
			for(int i = 0; i <LateList.size(); i++ ) {
				late.add(String.valueOf(LateList.get(i).get("COUNT")));
			}
			
			// 공지사항
			List<BoardVO> NoticeList = dao.selectNotice();
//			System.out.println("**************************************************************************"+NoticeList.get(0).toString());
			
			// 내 프로젝트
			ProjectVO project = dao.selectProject(employeeVO.getEmp_code());
			if(project != null) {
				// 진척도
				int progress = dao.selectPJProgress(project.getProject_code());
				project.setProject_progress(progress);
			}
			//정상출근
			model.addAttribute("nomal", nomal);
			//지각
			model.addAttribute("late",late);
			
			//공지사항
			model.addAttribute("NoticeList", NoticeList);
			
			// 내프로젝트, 프로젝트 진척도
			model.addAttribute("project", project);
			
			return "index.index";
		}
		
		@GetMapping("/mail/list")
		public String mailList() {
			return "mailList.mail";
		}
		
	   @GetMapping("/address/list")
	   public String addressList() {
	      return "addressList.address";
	   }
	   @GetMapping("/address/regist")
	   public String addressRegist() {
	      return "addressRegist.address";
	   }
	   @GetMapping("/approval/list")
	   public String approvalList() {
	      return "approvalList.approval";
	   }
	   @GetMapping("/hr/list")
	   public String hrList() {
	      return "hrList.hr";
	   }
	   
	   @GetMapping("/work/list")
	   public String workList() {
	      return "workList.work";
	   }
	   @GetMapping("/project/list")
	   public String projectList() {
	      return "projectList.project";
	   }
	   @GetMapping("/plan/list")
	   public String planList() {
	      return "planList.plan";
	   }
	   @GetMapping("/mypage/list")
	   public String mypageList() {
	      return "mypageList.mypage";
	   }
	   @GetMapping("/note/list")
	   public String noteList() {
	      return "noteList.note";
	   }
	   @GetMapping("/cloud/list")
	   public String cloudList() {
	      return "cloudList.cloud";
	   }
	   @GetMapping("/community/list")
	   public String communityList() {
	      return "commuList.community";
	   }
	   
	   @GetMapping("/noticePopUp")
	   public String showNotice(){
		   
		   return "main/notice";
	   }
	   
	}