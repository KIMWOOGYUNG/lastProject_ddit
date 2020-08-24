package kr.or.ddit.addr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.addr.service.IaddrService;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.Address_favoriteVO;
import kr.or.ddit.vo.Address_groupVO;
import kr.or.ddit.vo.AjaxdataAddressLineVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller
public class MycustomerController {
	@Inject
	IaddrService service;
	
	
	//내주소록 left ajax(거래처)
	@PostMapping(value ="/address/mycustomeraddr",produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseBody
	public List<Address_groupVO> leftajax2(HttpSession session) {
		EmployeeVO empVO =   (EmployeeVO) session.getAttribute("authUser");
		List<Address_groupVO> empList = service.mycustomergroupaddr(empVO.getEmp_code());
		return empList;
	}
	//내 주소록 거래처 리스트 ajax paging처리
		@GetMapping(value = "/address/cusomeraddrList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		public PagingVO<Address_favoriteVO> myaddajaxForlist(
			@RequestParam(name = "page",required = false, defaultValue = "1")
			int currentPage, SearchVO searchVO, Model model, HttpSession session, AddressVO detailSearch
				){
			myaddressList(currentPage,searchVO,model,session);
			return (PagingVO<Address_favoriteVO>) model.asMap().get("pagingVO");
		}
		//내 주소록 거래처 리스트 출력
		@GetMapping("/address/cusomeraddrList")
		public String myaddressList(@RequestParam(name = "page", required = false, defaultValue = "1")
		int currentPage, SearchVO searchVO, Model model, HttpSession session
				){
			EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
			PagingVO<AddressVO> pagingVO = new PagingVO<>(6,5);
			pagingVO.setSearchVO(searchVO);
			pagingVO.setCurrentPage(currentPage);
			//emp_code셋팅
			AddressVO detailSearch = new AddressVO();
			detailSearch.setEmp_code(empVO.getEmp_code());
			pagingVO.setDetailSearch(detailSearch);
			int totalCount = service.customerCount(pagingVO);
			pagingVO.setTotalRecord(totalCount);
			List<AddressVO> dataList = service.customerList(pagingVO);
			pagingVO.setDataList(dataList);
			
		
			//leftmenu담기
			List<AddressVO> addr = service.leftAddr();
		
			
			model.addAttribute("DeptTeamList", addr);
			model.addAttribute("pagingVO", pagingVO);
			
			return "mycustomeraddr.address";
		}
		
		//vo변환받기
		 private void addData(int currentPage, int totalRecord, List<AjaxdataAddressLineVO> dataList,Model model ) {
				PagingVO<AjaxdataAddressLineVO> vo = new PagingVO<AjaxdataAddressLineVO>();
				vo.setCurrentPage(currentPage);
				vo.setTotalRecord(totalRecord);
				vo.setDataList(dataList);
				model.addAttribute("pagingVO", vo);
		 }
		
		 ////내 주소록 상세보기 
		 @GetMapping("/address/myaddressDetail/{add_code}") 
			public String Detailaddress(@PathVariable String add_code,Model model) {
				AddressVO addVO = service.myselectAddress(add_code);
				
				
				model.addAttribute("address", addVO);
				//left메뉴고정
				List<AddressVO> addr = service.leftAddr();
				
				
				model.addAttribute("DeptTeamList", addr);
				
				return "myaddressDetail.address";
			}
		 
		 @PutMapping(value = "/address/myaddressDetail/{add_code}")
		 public String updateCostom(@PathVariable String add_code, @ModelAttribute AddressVO addressVO) {
			 String resulte = "ok";
			 
			ResultState state  = service.updateCustomAddr(addressVO);
			 
			 return "redirect:/address/myaddressDetail/"+add_code;
		 }
		
		 ///거래처 주소록 삭제
		 @PostMapping("/address/deletemycustomer")
		 public String deletemycustomer(@RequestParam String add_code,Model model, HttpSession session) {
			if(add_code.contains(",")) {
				String[] splited = add_code.split(",");
				for(int i =0; i<splited.length; i++) {
					service.deleteMyaddress(add_code);
				}
			}else {
				service.deleteMyaddress(add_code);
			}
			EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
			model.addAttribute("who",empVO.getAdd_code());
			return "mycustomeraddr.address";
			
		 	}
			 
		 }

