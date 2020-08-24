package kr.or.ddit.hr_admin.service;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Image_AttatchVO;

public interface IImageAttatchService {

	//이미지 업로드
		public ResultState insertImage(Image_AttatchVO imageattatch);
	
		public Image_AttatchVO selectImage(String emp_attcode);
		
		public ResultState deleteImage(Image_AttatchVO imageattatch);

		

}
