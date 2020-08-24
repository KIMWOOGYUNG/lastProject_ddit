package kr.or.ddit.login_logout.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import kr.or.ddit.util.JsonUtils;
import kr.or.ddit.vo.FaceIdentifyResult;


/**
 * Cognitive Service -> Face document
 * https://docs.microsoft.com/ko-kr/azure/cognitive-services/face/
 * 
 * REST API 를 이용한 Face 검출 설명
 * https://docs.microsoft.com/ko-kr/azure/cognitive-services/face/quickstarts/java
 * 
 * Face API 사용 가이드
 * https://westus.dev.cognitive.microsoft.com/docs/services/563879b61984550e40cbbe8d/operations/563879b61984550f30395236
 *  
 */
@Service
public class AzureFaceService {
	private static String SUBSCRIPTIONKEY = "3bdac3b821624790ba923fb61c1bba35";
	private static String ENDPOINT = "https://koreacentral.api.cognitive.microsoft.com/face/v1.0";
	private static final String FACEATTRIBUTES =
			"age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise";
	
	/**
	 * 1. 이미지에서 face 를 추출하고, id를 부여함. 해당 id 는   24 시간이 지나면 만료됨. (사진이 얼굴인지 확인하기위함 Detect With Stream)
	 * https://docs.microsoft.com/en-us/azure/cognitive-services/face/face-api-how-to-topics/howtodetectfacesinimage
	 * @param faceImage 이미지 2진 데이터
	 * @param responseBody <pre>성공하면, faceId 만 반환
	 *{
	 *	"faceId":"c5c24a82-6845-4031-9d5d-978df9175426"
	 *}
	 *실패하면, 
	 *{
	 *	"code": "BadArgument",
	 *	"message": "Request body is invalid."
	 *}
	 * </pre>
	 * @return 성공하면 200 반환
	 */
	public int detectFaceSimple(byte[] faceImage, Map<String, Object> responseBody) {
		return detectFace(faceImage, responseBody, false);
	}
	/**
	 * 1. 이미지에서 face 를 추출하고, id를 부여함. 해당 id 는   24 시간이 지나면 만료됨.
	 * @param faceImage 이미지 2진 데이터
	 * @param responseBody <pre>성공하면, 이미지에서  FACEATTRIBUTES 들을 추출함.
	 *[
	 *	{
	 *		"faceId": "c5c24a82-6845-4031-9d5d-978df9175426",
	 *		"recognitionModel": "recognition_02",
	 *		"faceRectangle": {
	 *			"width": 78,
	 *			...
	 *		},
	 *		"faceLandmarks": {
	 *			"pupilLeft": {
	 *				"x": 412.7,
	 *				"y": 78.4
	 *			},
	 *			...
	 *		},
	 *		"faceAttributes": {
	 *			"age": 71.0,
	 *			"gender": "male",
	 *			...
	 *		}
	 *	}
	 *]
	 *실패하면, 
	 *{
	 *	"code": "BadArgument",
	 *	"message": "Request body is invalid."
	 *}
	 * </pre>
	 * @param detail face 추출후 응답데이터로 face id 를 반환할지, face 의 전체 속성을 반환할지 결정.
	 * @return 성공하면 200 반환
	 */
	public int detectDetail(byte[] faceImage, Map<String, Object> responseBody) {
		return detectFace(faceImage, responseBody, true);
	}
	
	private int detectFace(byte[] faceImage, Map<String, Object> responseBody, boolean detail) {
		String detectUrl = ENDPOINT+"/detect";
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			// endpoint URL 설정
			URIBuilder builder = new URIBuilder(detectUrl);
			
			// query String parameter 설정
			builder.setParameter("returnFaceId", "true");
			builder.setParameter("returnFaceLandmarks", "true");
			builder.setParameter("returnFaceattributes", FACEATTRIBUTES);
			builder.setParameter("recognitionModel", "recognition_01");
			builder.setParameter("returnRecognitionModel", "true");
			builder.setParameter("detectionModel", "detection_01");
			URI uri = builder.build();
			
			HttpPost postReq = new HttpPost(uri);
			postReq.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			postReq.setHeader("Content-Type", ContentType.APPLICATION_OCTET_STREAM.toString());
			HttpEntity reqEntity = new ByteArrayEntity(faceImage);
			postReq.setEntity(reqEntity);
			
			HttpResponse response = httpClient.execute(postReq);
			int sc = response.getStatusLine().getStatusCode();
			try(
				InputStream in = response.getEntity().getContent();	
			){
				if(sc==200) {
					if(detail) {
						responseBody.putAll(JsonUtils.unMarshallingToArray(in, Map.class)[0]);
					}else {
						responseBody.put("faceId", JsonUtils.findValue("faceId", in));
					}
				}else {
					responseBody.putAll(JsonUtils.unMarshalling(JsonUtils.findValue("error", in), Map.class));
				}
				return sc;
			}
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 2. 이미지 검증, 두개의 이미지가 동일인임을 검증함.
	 * @param faceId1
	 * @param faceId2
	 * @param responseBody <pre>성공하면, 
	 *{
	 *	"isIdentical": true,
	 *	"confidence": 0.9
	 *}
	 *상태코드 400으로 실패하면,
	 *{
	 *	"code": "BadArgument",
	 *	"message": "Request body is invalid."
	 *}
	 * </pre>
	 * @return 성공하면 200 반환
	 */
	public int verifySameFace(String faceId1, String faceId2, Map<String, Object> responseBody) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("faceId1", faceId1);
		paramMap.put("faceId2", faceId2);
		return verify(paramMap, responseBody);
	}
	
	/**
	 * 2. 이미지 검증, 이미지에서 검출된 Face가  personId의 얼굴이 맞는지 확인
	 * @param faceId
	 * @param personId
	 * @param personGroupId
	 * @param responseBody <pre>성공하면, 
	 *{
	 *	"isIdentical": true,
	 *	"confidence": 0.9
	 *}
	 *상태코드 400으로 실패하면,
	 *{
	 *	"code": "BadArgument",
	 *	"message": "Request body is invalid."
	 *}
	 * </pre>
	 * @return 성공하면 200 반환
	 */
	public int verifyFaceBelongToPerson(String faceId, String personId, String personGroupId, Map<String, Object> responseBody) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("faceId", faceId);
		paramMap.put("personId", personId);
		paramMap.put("personGroupId", personGroupId);
		return verify(paramMap, responseBody);
	}
	
	private int verify(Map<String, Object> paramMap, Map<String, Object> responseBody) {
		String verifyUrl = ENDPOINT+"/verify";
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postReq = new HttpPost(verifyUrl);
			postReq.setHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
			postReq.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			
			StringEntity reqEntity = new StringEntity(JsonUtils.marshalling(paramMap));
			postReq.setEntity(reqEntity);
			
			HttpResponse response = httpClient.execute(postReq);
			int sc = response.getStatusLine().getStatusCode();
			try(
				InputStream in = response.getEntity().getContent();
			){
				if(sc==200) {
					responseBody.putAll(JsonUtils.unMarshalling(in, Map.class));
				}else {
					responseBody.putAll(JsonUtils.unMarshalling(JsonUtils.findValue("error", in), Map.class));
				}
				return sc;
			}		
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 3. 이미지로부터 추출한 face id 로 person id 를 식별함(Face Identify API 활용).
	 * @param faceId
	 * @param personGroupId
	 * @param responseBody <pre>성공하면,  results 로 {@link FaceIdentifyResult} 배열을 반환함.
	 *{ 
	 *	results:[
	 *  	{
	 *      	"faceId": "c5c24a82-6845-4031-9d5d-978df9175426",
	 *      	"candidates": [
	 *      		{
	 *      			"personId": "25985303-c537-4467-b41d-bdb45cd95ca1",
	 *      			"confidence": 0.92
	 *      		}
	 *      	]
	 *      },
	 *      {
	 *      	"faceId": "65d083d4-9447-47d1-af30-b626144bf0fb",
	 *      	"candidates": [
	 *      		{
	 *      			"personId": "2ae4935b-9659-44c3-977f-61fac20d0538",
	 *      			"confidence": 0.89
	 *      		}
	 *      	]
	 *      }
	 *  ]
	 *}
	 *상태코드 400으로 실패하면, 
	 *{
	 *	"code": "BadArgument",
	 *	"message": "Large Person group is invalid."
	 *}
	 * </pre>
	 * @return
	 */
	//detect 안에서 나온 faceID, 맨처음 personGroup은 '한번만' 만들어서 group id를 저장해놓고 넘겨주기
	public int faceIdentify(String faceId, String personGroupId, Map<String, Object> responseBody) {
		String identifyUrl = ENDPOINT+"/identify";
		try {
			HttpClient  httpClient = HttpClientBuilder.create().build();
			HttpPost postReq = new HttpPost(identifyUrl);
			postReq.setHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
			postReq.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("faceIds", new String[] {faceId});
			paramMap.put("personGroupId", personGroupId);
			paramMap.put("maxNumOfCandidatesReturned", 1); // faceId 의 얼굴과 유사한 person id를 최대 1개 까지 조회
			paramMap.put("confidenceThreshold", 0.5); // 신뢰도 0.5  이상의 person id 만 조회함. 해당 값으로 인식률을 조정할 수 있음.
			
			StringEntity reqEntity = new StringEntity(JsonUtils.marshalling(paramMap));
			postReq.setEntity(reqEntity);
			
			HttpResponse response = httpClient.execute(postReq);
			int sc = response.getStatusLine().getStatusCode();
			try(
				InputStream in = response.getEntity().getContent();
			){
				if(sc==200) {
					FaceIdentifyResult[] results = JsonUtils.unMarshallingToArray(in, FaceIdentifyResult.class);
					responseBody.put("results", results);
				}else {
					responseBody.putAll(JsonUtils.unMarshalling(JsonUtils.findValue("error", in), Map.class));
				}
				return sc;
			}
			
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}













