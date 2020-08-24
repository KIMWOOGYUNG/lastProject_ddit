package kr.or.ddit.approval.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.FormVO;
import kr.or.ddit.vo.Form_CatagVO;
import kr.or.ddit.vo.PagingVO;

@Repository
public interface IPublicFormBoxDAO {
	/**
	 * 등록된 서식의 개수 구하기
	 * @param pagingVO
	 * @return
	 */
	public int selectFormCount(PagingVO<FormVO> pagingVO);
	/**
	 * 서식 목록을 리스트에 담기
	 * @param pagingVO
	 * @return
	 */
	public List<FormVO> selectFormList(PagingVO<FormVO> pagingVO);
	/**
	 * 서식 하나를 선택하여 상세보기
	 * @param fc_code
	 * @return
	 */
	public FormVO selectForm(String form_code);
	/**
	 * 새로운 서식 추가
	 * @param form
	 * @return
	 */
	public int insertForm(FormVO form);
	/**
	 * 서식 수정
	 * @param form
	 * @return
	 */
	public int updateForm(FormVO form);
	/**
	 * 서식 삭제
	 * @param form_code
	 * @return
	 */
	public int deleteForm(String form_code);
	/**
	 * 서식 카테고리 
	 * @return
	 */
	public List<Form_CatagVO> selectFormCatagList();
	/**
	 * 서식파일의 html소스 가져오기
	 * @param form_content
	 * @return
	 */
	public FormVO selectHTMLCode(String form_content);
	/**
	 * 
	 * @return
	 */
	public List<Map<String, Object>> selectCatagList();
}