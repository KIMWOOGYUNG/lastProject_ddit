package kr.or.ddit.login_logout.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import kr.or.ddit.util.JsonUtils;
import kr.or.ddit.vo.Person;

/**
 * PersonGroup & Person API 사용 가이드
 * https://westus.dev.cognitive.microsoft.com/docs/services/563879b61984550e40cbbe8d/operations/563879b61984550f30395244
 * 
 * Azure PersonGroup, Person, Face  API 를 이용한 안면인식 로그인 절차.
 * https://docs.microsoft.com/ko-kr/azure/cognitive-services/face/face-api-how-to-topics/howtoidentifyfacesinimage
 * 
 * 1. Azure 서버에 PersonGroup  생성 후 personGroup 을 저장함.
 * 2. 생성된  personGroup 에  person 등록 ( 신규 회원 등록시 처리)
 * 3. 등록된 person 에 Face 추가( 신규 회원 등록시 처리)
 * 4. 변경된 personGroup 을 대상으로 훈련 진행
 * 5. 안면인식을 이용한 로그인 처리 절차 
 * 	  1) 클라언트로부터 촬영된 얼굴 이미지 수신.(100%)
 * 	  2) 해당 이미지의 faceId 추출 (Face Detect API 사용)
 *    3) 추출된 faceId 를 이용해 얼굴과 매칭되는 Person id 식별(Face Identify API 사용)
 *    4) person id 를 이용해 DB 로부터 ID/PASSWORD 조회
 *    5) 조회한 ID/PASSWORD 로 로그인 처리
 */
@Service
public class AzurePersonService {
	private static String SUBSCRIPTIONKEY = "3bdac3b821624790ba923fb61c1bba35";
	private static String ENDPOINT = "https://koreacentral.api.cognitive.microsoft.com/face/v1.0";
	private static String URIBASE = ENDPOINT+"/persongroups";
	
	/**
	 * 1. PersonGroup 으로 안면인식 학습 데이터 저장소 생성
	 * @param groupId PersonGroup 식별자
	 * @param groupName optional name
	 * @param responseBody <pre>response body(message body) 반환용, 성공하면 empty map이 반환, 실패하면 error 정보가 반환됨.
	 *ex) 상태코드 401로 실패인 경우.
	 *{
	 *	"code": "Unspecified",
	 *	"message": "Access denied due to invalid subscription key. Make sure you are subscribed to an API you are trying to call and provide the right key."
	 *}</pre>
	 * @return 성공하면 200 반환.
	 */
	public int createPersonGroup(String groupId, String groupName, Map<String, Object> responseBody) {
		String personGroupURI = String.format(URIBASE+"/%s", groupId);
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPut putRequest = new HttpPut(personGroupURI);
			putRequest.setHeader("Content-Type", ContentType.APPLICATION_JSON.toString()); //json으로 넘어가도록
			putRequest.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("name", groupName);
			
			StringEntity reqEntity = new StringEntity(JsonUtils.marshalling(paramMap));
			putRequest.setEntity(reqEntity); //body부분 
			
			HttpResponse response = httpClient.execute(putRequest); //애저서버로넘겨서 응답을받음
			int sc = response.getStatusLine().getStatusCode();
			try(
				InputStream in = response.getEntity().getContent();	
			){
				if(sc!=200) {
					responseBody.putAll(JsonUtils.unMarshalling(JsonUtils.findValue("error", in), Map.class));
				}
				return sc;
			}
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 2. PersonGroup 내에 Person 데이터 생성
	 * @param groupId PersonGroup ID
	 * @param personName  person custom name
	 * @param responseBody <pre>성공하면 등록된 Person  id 반환.
	 * 성공한 경우,
	 *{
	 *	"personId": "25985303-c537-4467-b41d-bdb45cd95ca1"
	 *}
	 *상태코드 401로 실패한 경우,
	 *{
	 *	"code": "Unspecified",
	 *	"message": "Access denied due to invalid subscription key. Make sure you are subscribed to an API you are trying to call and provide the right key."
	 *}</pre>
	 * @return 성공하면 200 반환.
	 */
	public int createPersonInGroup(String groupId, String personName, Map<String, Object> responseBody) {
		String personURI = String.format(URIBASE+"/%s/persons", groupId);
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			HttpPost postRequest = new HttpPost(personURI);
			postRequest.setHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
			postRequest.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("name", personName);
			
			StringEntity reqEntity = new StringEntity(JsonUtils.marshalling(paramMap), Charset.forName("UTF-8"));
			postRequest.setEntity(reqEntity);
			
			HttpResponse response = httpClient.execute(postRequest);
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
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 3. 등록된 Person 에 Face 추가
	 * @param groupId PersonGroup id
	 * @param personId Person id
	 * @param imageByteArray 추가할 Face 2진 데이터
	 * @param responseBody <pre>성공하면 추가된 Face id 반환, 실패하면  error 정보 반환
	 *성공한 경우, 
	 *{
	 *	"persistedFaceId": "B8D802CF-DD8F-4E61-B15C-9E6C5844CCBA"
	 *}
	 *상태코드 400으로 실패한 경우,
	 *{
	 *	"code": "BadArgument",
	 *	"message": "Request body is invalid."
	 *}</pre>
	 * @return 성공하면 200 반환
	 */
	public int addFaceToPersonInGroup(String groupId, String personId, 
										byte[] imageByteArray, Map<String, Object> responseBody){
		String addFaceURI = String.format(URIBASE+"/%s/persons/%s/persistedFaces", groupId, personId);
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost(addFaceURI);
			postRequest.setHeader("Content-Type", ContentType.APPLICATION_OCTET_STREAM.toString());
			postRequest.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			ByteArrayEntity requestEntity = new ByteArrayEntity(imageByteArray);
			postRequest.setEntity(requestEntity);
			
			HttpResponse response = httpClient.execute(postRequest);
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
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 4. PersonGroup 에 Person 을 변경하거나  Face를 추가한 후 해당 그룹을 훈련시킴. 훈련된 그룹만이 Face-Identify 에서 사용될수있음. group train
	 * @param groupId
	 * @param responseBody <pre>훈련 예약 성공시 empty map 반환, 
	 *상태코드 403으로 실패하면, 
	 *{
	 *	"statusCode": 403,
	 *	"message": "Out of call volume quota. Quota will be replenished in 2 days."
	 *}</pre>
	 * @return 비동기로 훈련시키기 때문에 요청이 접수되어 훈련이 진행될 것을 의미하는 202(Accepted)가 상태로 반환됨.
	 *      PersonGroup - Get Training Status API 로 비동기 훈련 상태를 확인할 수 있음. 
	 * 		 만일 실패했다면 400번대 코드가 반환됨.
	 */
	public int personGroupTrain(String groupId, Map<String, Object> responseBody) {
		String personGroupTrainURI = String.format(URIBASE+"/%s/train", groupId);
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost(personGroupTrainURI);
			postRequest.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			
			HttpResponse response = httpClient.execute(postRequest);
			int sc = response.getStatusLine().getStatusCode();
			try(
				InputStream in = response.getEntity().getContent();	
			){
				if(sc/200 != 1) {
					responseBody.putAll(JsonUtils.unMarshalling(JsonUtils.findValue("error", in), Map.class));
				}
				return sc;
			}
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 5. 비동기로 진행되는 훈련 상태를 확인하기 위함. 
	 * @param groupId
	 * @param responseBody <pre>성공하면 상태의 종류를 반환함. status : notstarted, running, succeeded, failed
	 *{
	 *     "status": "succeeded",
	 *     "createdDateTime": "2018-10-15T11:51:27.6872495Z",
	 *     "lastActionDateTime": "2018-10-15T11:51:27.8705696Z",
	 *     "message": null
	 *}
	 *상태코드 404로 실패하면,
	 *{
	 *	"code": "PersonGroupNotFound",
	 *	"message": "Person group is not found."
	 *}</pre> 
	 * @return 성공하면 200반환
	 */
	public int getTrainingStatus(String groupId, Map<String, Object> responseBody){
		String trainURI = String.format(URIBASE+"/%s/training", groupId);
		
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet getRequest = new HttpGet(trainURI);
			getRequest.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			
			HttpResponse response = client.execute(getRequest);
			int sc = response.getStatusLine().getStatusCode();
			
			try(
				InputStream in = response.getEntity().getContent();	
			){
				if(sc==200) {
					responseBody.putAll(JsonUtils.unMarshalling(in, Map.class));
				}else {
					responseBody.putAll(JsonUtils.unMarshalling(JsonUtils.findValue("error", in), Map.class));
				}
			}
			return sc;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 6.  personId로 등록된 Person 정보를 조회함.
	 * @param groupId
	 * @param personId
	 * @param responseBody <pre>성공하면, person 키로 Person 객체를 반환함.
	 * {
	 * 	"person":{
	 *  	"personId": "25985303-c537-4467-b41d-bdb45cd95ca1",
	 *		"persistedFaceIds": [
	 *			"015839fb-fbd9-4f79-ace9-7675fc2f1dd9",
	 *			"fce92aed-d578-4d2e-8114-068f8af4492e",
	 *			"b64d5e15-8257-4af2-b20a-5a750f8940e7"
	 *		],
	 *		"name": "Ryan",
	 *		"userData": "User-provided data attached to the person."
	 *	}
	 *}
	 *403코드로 실패하면,
	 *{
	 *	"statusCode": 403,
	 *	"message": "Out of call volume quota. Quota will be replenished in 2 days."
	 *} 
	 * </pre>
	 * @return
	 */
	public int getPerson(String groupId, String personId, Map<String, Object> responseBody) {
		String personURI = String.format(URIBASE+"/%s/persons/%s", groupId, personId);
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet getReq = new HttpGet(personURI);
			getReq.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			
			HttpResponse response = httpClient.execute(getReq);
			int sc = response.getStatusLine().getStatusCode();
			try(
				InputStream in = response.getEntity().getContent();	
			){
				if(sc==200) {
					responseBody.put("person", JsonUtils.unMarshalling(in, Person.class));
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
	 * 등록된 Person 삭제
	 * @param groupId
	 * @param personId
	 * @param responseBody
	 * @return
	 */
	public int deletePerson(String groupId, String personId, Map<String, Object> responseBody) {
		String personURI = String.format(URIBASE+"/%s/persons/%s", groupId, personId);
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpDelete deleteReq = new HttpDelete(personURI);
			deleteReq.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTIONKEY);
			
			HttpResponse response = httpClient.execute(deleteReq);
			int sc = response.getStatusLine().getStatusCode();
			try(
				InputStream in = response.getEntity().getContent();	
			){
				if(sc!=200) {
					responseBody.putAll(JsonUtils.unMarshalling(JsonUtils.findValue("error", in), Map.class));
				}
				return sc;
			}
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}









