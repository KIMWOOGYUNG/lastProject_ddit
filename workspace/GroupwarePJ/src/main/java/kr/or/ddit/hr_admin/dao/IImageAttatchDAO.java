package kr.or.ddit.hr_admin.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Image_AttatchVO;

@Repository
public interface IImageAttatchDAO {
	
	//이미지 업로드
	public int insertImage(Image_AttatchVO imageattatch);
	
	public Image_AttatchVO selectImage(String emp_attcode);
	
	public ResultState deleteImage(Image_AttatchVO imageattatch);

}