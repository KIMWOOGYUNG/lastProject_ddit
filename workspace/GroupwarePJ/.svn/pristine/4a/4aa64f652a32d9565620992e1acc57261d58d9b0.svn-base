package kr.or.ddit.hr_admin.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.hr_admin.dao.IAdminEmployDAO;
import kr.or.ddit.hr_admin.dao.IImageAttatchDAO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Image_AttatchVO;
import kr.or.ddit.vo.WorkLogVO;
import kr.or.ddit.vo.WorkLog_AttatchVO;

@Service
public class ImageAttatchServiceImpl implements IImageAttatchService {

	@Inject
	private IImageAttatchDAO attatchdao;
	
	@Inject
	private IAdminEmployDAO empDAO;
	
	@Value("#{appInfo.attatchPath}")
	String attachPath;
	@Value("#{appInfo.attatchPath}")
	File saveFolder;
	
	@PostConstruct
	public void init() {
//		String realPath = context.getServletContext().getRealPath(attachPath);
//		saveFolder = new File(attachPath);
		if(!saveFolder.exists()) saveFolder.mkdirs();
	}
	
	private void deleteBinary(String[] delAttSaveName) {
		if(delAttSaveName == null || delAttSaveName.length == 0)return;
		try {
			for(String delName : delAttSaveName) {
				System.out.println("11 : " + saveFolder + "22 : " + delName);
				FileUtils.forceDelete(new File(saveFolder, delName));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	


	@Override
	public Image_AttatchVO selectImage(String emp_attcode) {
		Image_AttatchVO imageattatch = attatchdao.selectImage(emp_attcode);
		return imageattatch;
	}

@Transactional
	@Override
	public ResultState deleteImage(Image_AttatchVO imageattatch) {
//	Image_AttatchVO saveimage = selectImage(imageattatch.getEmp_attcode());
	ResultState result = null;	
//	
//	List<Image_AttatchVO> attList = saveimage.getImage_attList();
//	String[] delAttNames = null;
//	if(attList != null && !attList.isEmpty()) {
//		delAttNames = new String[attList.size()];
//		for(int i = 0; i< delAttNames.length; i++) {
//			delAttNames[i] = attList.get(i).getSave_name();
//		}
//	}
//	int cnt = attatchdao.deleteImage(imageattatch.getEmp_attcode());
//	
//	if(cnt > 0) {
//		deleteBinary(delAttNames);
//		result = ResultState.OK;
//	}else {
//		result = ResultState.FAIL;
//	}
	return result;
	}

public int processAttatches(EmployeeVO employ) throws IllegalStateException, IOException{
	int cnt = 0;
	List<Image_AttatchVO> attatchList = employ.getImage_attList();
			for(Image_AttatchVO attatch : attatchList) {
				attatch.setEmp_code(employ.getEmp_code());
				cnt += attatchdao.insertImage(attatch);
				attatch.getRealFile().transferTo(new File(saveFolder, attatch.getSave_name()));
			}
			return cnt;
				
			}




@Transactional
@Override
public ResultState insertImage(Image_AttatchVO image){
	return null;
//	int cnt = attatchdao.insertImage(image);
//	processAttatches(image);
//	ResultState result = ResultState.FAIL;
//	if(cnt > 0) result = ResultState.OK;
	
}

}























