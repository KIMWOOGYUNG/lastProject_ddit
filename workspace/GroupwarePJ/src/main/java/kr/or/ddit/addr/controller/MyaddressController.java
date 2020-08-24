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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.addr.service.IaddrService;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.Address_favoriteVO;
import kr.or.ddit.vo.Address_groupVO;
import kr.or.ddit.vo.AjaxdataAddressLineVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller
public class MyaddressController {
	
	@Inject
	IaddrService service;
	//내주소록 left ajax(즐찾)
	@PostMapping(value ="/address/myaddress/myaddrfavorites1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseBody
	public List<Address_favoriteVO> leftajax(HttpSession session) {
		EmployeeVO empVO =   (EmployeeVO) session.getAttribute("authUser");
		List<Address_favoriteVO> empList = service.myfavoriteList(empVO.getEmp_code());
		return empList;
	}
	//내 주소록 그룹 리스트 ajax
	@GetMapping(value = "/address/favoList/{add_favo_code}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<Address_favoriteVO> myaddajaxForlist(
		@RequestParam(name = "page",required = false, defaultValue = "1")
		int currentPage, SearchVO searchVO, Model model, HttpSession session, AddressVO detailSearch
				,@PathVariable String add_favo_code	){
		myaddressList(currentPage,searchVO,model,session,add_favo_code);
		return (PagingVO<Address_favoriteVO>) model.asMap().get("pagingVO");
	}
	//내 주소록 그룹 리스트 출력
	@GetMapping("/address/favoList/{add_favo_code}")
	public String myaddressList(@RequestParam(name = "page", required = false, defaultValue = "1")
	int currentPage, SearchVO searchVO, Model model, HttpSession session,@PathVariable String add_favo_code	){
		EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
		//vo변환
		ArrayList<AjaxdataAddressLineVO> sendDataList= new ArrayList<AjaxdataAddressLineVO>();
		PagingVO<AjaxdataAddressLineVO> pagingVO = new PagingVO<>(6,5);
		pagingVO.setSearchVO(searchVO);
		pagingVO.setCurrentPage(currentPage);
		
		//emp_code셋팅
		AjaxdataAddressLineVO detailSearch = new AjaxdataAddressLineVO();
		detailSearch.setEmp_code(empVO.getEmp_code());
		detailSearch.setAdd_favo_code(add_favo_code);
		pagingVO.setDetailSearch(detailSearch);  
		int totalRecord = service.selectmyaddCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<AjaxdataAddressLineVO> dataList = service.myaddressList(pagingVO);
		//변환된 데이터를 담아줌
		pagingVO.setDataList(dataList);
		//leftmenu담기
		List<AddressVO> addr = service.leftAddr();
		System.out.println(addr);
		model.addAttribute("pagingVO",pagingVO);
		model.addAttribute("DeptTeamList", addr);
		
		return "myaddressList.address";
	}
	//vo변환받기
	 private void addData(int currentPage, int totalRecord, List<AjaxdataAddressLineVO> dataList,Model model ) {
			PagingVO<AjaxdataAddressLineVO> vo = new PagingVO<AjaxdataAddressLineVO>();
			vo.setCurrentPage(currentPage);
			vo.setTotalRecord(totalRecord);
			vo.setDataList(dataList);
			model.addAttribute("pagingVO", vo);
	 }
	 ////즐겨찾기 그룹반환 기능메서드
//	 @GetMapping(value = "/address/myaddress/myaddrfavorites",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	 @ResponseBody
//	 public List<Address_favoriteVO> myaddrGroup(HttpSession session) {
//		EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
//		 return service.myfavoriteList(empVO.getEmp_code());
//	 }
//	 ///거래처 그룹반환 기능메서드
//	 @GetMapping(value = "/address/myaddress/mycustomgroup",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	 @ResponseBody
//	 public List<Address_groupVO> mycustomerGroupaddr(HttpSession session){
//		 	EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
//		 return service.mycustomergroupaddr(empVO.getEmp_code());
//	 }	
	 //내주소록  ajax(즐찾)
//		@PostMapping(value ="/address/mygroupDetail{add_code}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
//		@ResponseBody
//		public List<AjaxdataAddressLineVO> ajax(@PathVariable String add_code,
//				HttpSession session,SearchVO searchVO,Model model ) {
//			Detailaddress(add_code,searchVO,model,session);
////			List<AjaxdataAddressLineVO> empList = (List<AjaxdataAddressLineVO>) service.readGroupList(add_code);
//			return (List<AjaxdataAddressLineVO>) model.asMap().get("add_code");
//		}
//	 
	 ////내 주소록 상세보기 
	 @GetMapping("/address/mygroupDetail/{add_code}") 
	public String Detailaddress(@PathVariable String add_code, Model model, HttpSession session) {
//			AddressVO addVO = service.myselectAddress(add_code);
		 	AjaxdataAddressLineVO addVO = service.readGroupList(add_code);
			model.addAttribute("address", addVO);
			
			//left메뉴고정
			List<AddressVO> addr = service.leftAddr();
			System.out.println(addr);
			model.addAttribute("DeptTeamList", addr);
			
			return "mygroupDetail.address";
		}
	 
	 //내주소록 삭제하기 
	 @PostMapping("/address/myaddressList/{add_code}")
	 public String deleteMyaddress(@RequestParam String add_code,Model model, HttpSession session) {
		 if(add_code.contains(",")) {
			 String[]splited = add_code.split(",");
			 for(int i=0; i<splited.length; i++) {
				 service.deleteMyaddress(add_code);
			 }
		 }else {
			 service.deleteMyaddress(add_code);
		 }
		 EmployeeVO empVO = (EmployeeVO) session.getAttribute("authUser");
		 model.addAttribute("who",empVO.getEmp_code());
		 return "myaddressList.address";
		 
	 }
	 
	 
}
