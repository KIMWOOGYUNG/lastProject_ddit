package kr.or.ddit.community.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.or.ddit.community.service.IBoardService;
import kr.or.ddit.vo.Board_AttatchVO;

@Controller
public class BoardFileDownloadController {
	@Inject
	IBoardService service;
	
	@GetMapping("/board/file/{board_attcode}")
	public String download(@PathVariable(required = true) String board_attcode, Model model) {
		Board_AttatchVO attatch = service.downloadAttatch(board_attcode);
		model.addAttribute("attatch", attatch);
		return "DownloadView";
	}

}