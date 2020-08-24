


package kr.or.ddit.addr.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.addr.dao.IAddressDAO;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.Address_favoriteVO;
import kr.or.ddit.vo.Address_groupVO;
import kr.or.ddit.vo.AjaxdataAddressLineVO;
import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Image_AttatchVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TeamVO;

@Service("AddrService")
public class AddrServiceImpl implements IaddrService {
 @Inject
 private IAddressDAO dao;
 
 	//사내주소록 left
 	@Override
	public List<AddressVO> leftAddr() {
		return dao.leftAddr();
	}
	@Override///사내주소록 리스트
	public List<EmployeeVO> readAddrList(PagingVO<EmployeeVO> pagingVO) {
		return dao.addrList(pagingVO);
	}
	@Override//주소록 수량
	public int selectaddrCount(PagingVO<EmployeeVO> pagingVO) {
		return dao.selectaddrCount(pagingVO);
	}
	@Override///상세보기 내가한거
	public EmployeeVO selectAddress(String emp_code) {
		return dao.readAddressList(emp_code);
	}
	//부서 리스트 
	@Override
	public List<EmployeeVO> deptList(PagingVO<EmployeeVO> pagingVO) {
		return dao.deptAddress(pagingVO);
	}
	//부서 인원 수 조회 
	@Override
	public int selectDeptCount(PagingVO<EmployeeVO> pagingVO) {
		return dao.selectDeptCount(pagingVO);
	}
	////팀 리스트 
	@Override
	public List<EmployeeVO> teamAddress(PagingVO<EmployeeVO> pagingVO) {
		return dao.teamAddress(pagingVO);
	}
	//팀 개개별 리스트를 출력
	@Override
	public List<EmployeeVO> teamList(PagingVO<EmployeeVO> pagingVO) {
		return dao.teamList(pagingVO);
	}
	//팀 개개별 인원 수 출력
	@Override
	public int teamCount(PagingVO<EmployeeVO> pagingVO) {
		return dao.teamCount(pagingVO);
	}
	//팀 인원 수 조회
	@Override
	public int selectTeamCount(PagingVO<EmployeeVO> pagingVO) {
		return dao.selectTeamCount(pagingVO);
	}
	 ////내 주소록  리스트 
	 @Override
		public List<AjaxdataAddressLineVO> myaddressList(PagingVO<AjaxdataAddressLineVO> pagingVO) {
			return dao.myaddressList(pagingVO);
		}
	///내 주소록 카운트
	 @Override
		public int selectmyaddCount(PagingVO<AjaxdataAddressLineVO> pagingVO) {
			return dao.selectmyaddCount(pagingVO);
		}
	 //내 주소록 상세보기 
	 @Override
		public AddressVO myselectAddress(String add_code) {
			return dao.myselectAddress(add_code);
		}
	 //내 주소록 즐겨찾기 리스트 
		@Override
		public List<Address_favoriteVO> myfavoriteList(String emp_code) {
			return dao.myfavoriteList(emp_code);
		}
		//거래처의 개별 리스트
		@Override
		public List<AddressVO> customerList(PagingVO<AddressVO> pagingVO) {
			return dao.customerList(pagingVO);
		}
		
		//거래처의 수 출력
		@Override
		public int customerCount(PagingVO<AddressVO> pagingVO) {
			return dao.customerCount(pagingVO);
		}
		

		//내 주소록의 거래처 리스트 
		@Override
		public List<Address_groupVO> mycustomergroupaddr(String emp_code) {
			return dao.mycustomergroupaddr(emp_code);
		}
		//그룹 개개별 카운트
		@Override
		public int groupCount(PagingVO<EmployeeVO> pagingVO) {
			return dao.groupCount(pagingVO);
		}
		//그룹 상세보기
		@Override
		public AjaxdataAddressLineVO readGroupList(String add_code) {
			return dao.readGroupList(add_code);
		}
		//내 주수록의 즐겨찾기 & 거래처 카운트 
		@Override
		public int selectmyfavoriteCount(PagingVO<EmployeeVO> pagingVO) {
			return dao.selectmyfavoriteCount(pagingVO);
		}
	   ///내 주소록 거래처 등록
		@Override
		public ResultState insertEmp(AddressVO address) {
			int cnt = dao.insertEmp(address);
			ResultState result = ResultState.FAIL;
			if(cnt > 0) result= ResultState.OK;
			return result;
		}
		//내 주소록 거래처 등록(모달)
		@Override
		public int updatemyaddress(AddressVO add_code) {
			return 0;
		}
		//내 주소록 완전 삭제 
		@Override
		public ResultState deleteMyaddress(String add_code) {
			ResultState result = ResultState.FAIL;
			int cnt =dao.deleteMyaddress(add_code);
			if(cnt>0) {
				result=ResultState.SUCCESSES;
			}
			return result;
		}
		
	   
	   
	   
	   
	   
	   
	   
/////////////////////////////////////dynaTree///////////////////////////
	@Override//전체 부서 반환
	public List<DepartmentVO> readDepartmentList() {
		return dao.selectDepartmentList();
	}

	@Override //부서에 속해있는 팀 반환
	public List<TeamVO> readTeamList(String dept_code) {
		return dao.selectTeamList(dept_code);
	}
	
	
	@Override//부서에 속해있는 사원 반환
	public List<EmployeeVO> addrList(PagingVO<EmployeeVO> pagingVO) {
		return dao.selectAddrList(pagingVO);
	}
///////////////////////////////////////////////////////////////////////
	@Override
	public ResultState updateCustomAddr(AddressVO addressVO) {
		ResultState state = ResultState.FAIL;
		
		 if( dao.updateCustomAddr(addressVO) > 0) {
			 state = ResultState.OK;
		 }
		return state;
	}

	

	


	
	
	
	





	


}
