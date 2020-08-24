package kr.or.ddit.approval.service;

import java.io.File;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.approval.dao.IPublicFormBoxDAO;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.CommonsAttatchFileVO;
import kr.or.ddit.vo.FormVO;
import kr.or.ddit.vo.Form_CatagVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class PublicFormBoxServiceImpl implements IPublicFormBoxService {

	@Inject
	IPublicFormBoxDAO dao;
	
//	@Inject
//	WebApplicationContext context;
	
//	@Value("#{appInfo.attatchPath}")
//	String attatchPath;
//	@Value("#{appInfo.attatchPath}")
//	String saveFolder;
//	
//	@PostConstruct
//	public void init() {
//		if(!saveFolder.exists()) saveFolder.mkdirs();
//	}
//	
//	private void deleteBinary(String[] delAttSaveName) {
//		if(delAttSaveName == null || delAttSaveName.length == 0)return;
//		try {
//			for(String delName : delAttSaveName) {
//				FileUtils.forceDelete(new File(saveFolder, delName));
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

	@Override
	public int selectFormCount(PagingVO<FormVO> pagingVO) {
		return dao.selectFormCount(pagingVO);
	}

	@Override
	public List<FormVO> selectFormList(PagingVO<FormVO> pagingVO) {
		return dao.selectFormList(pagingVO);
	}

	@Override
	public FormVO selectForm(String form_code) {
		return dao.selectForm(form_code);
	}

	@Override
	public ResultState insertForm(FormVO form) {
		ResultState result = null;
		int cnt = dao.insertForm(form);
		if(cnt > 0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		return result;
	}

	@Override
	public ResultState updateForm(FormVO form) {
		ResultState result = null;
		int cnt = dao.updateForm(form);
		if(cnt>0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		
		return result;
	}

	@Override
	public ResultState deleteForm(String form_code) {
		ResultState result = null;
		int cnt = dao.deleteForm(form_code);
		if(cnt>0) {
			result = ResultState.SUCCESSES;
		}else {
			result = ResultState.FAIL;
		}
		
		return result;
	}

	@Override
	public List<Form_CatagVO> selectFormCatagList() {
		return dao.selectFormCatagList();
	}

	@Override
	public FormVO selectHTMLCode(String form_content) {
		return dao.selectHTMLCode(form_content);
	}

//	@Override
//	public CommonsAttatchFileVO downloadAttatch(String form_code) {
//		CommonsAttatchFileVO attatch = dao.select
//		return null;
//	}

	

}
