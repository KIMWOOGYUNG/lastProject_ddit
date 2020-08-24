package kr.or.ddit.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JsonUtils {
	public static String findValue(String fldName, String json) throws IOException{
		String[] values = findValues(fldName, json);
		if(values==null || values.length>0) {
			return values[0];
		}else {
			return null;
		}
	}
	
	public static String findValue(String fldName, InputStream json) throws IOException{
		String[] values = findValues(fldName, json);
		if(values==null || values.length>0) {
			return values[0];
		}else {
			return null;
		}
	}
	
	public static String[] findValues(String fldName, String json) throws IOException{
		try(
			InputStream in = new ByteArrayInputStream(json.getBytes());
		){
			return findValues(fldName, in);
		}
	}
	
	public static String[] findValues(String fldName, InputStream json) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(json);
		List<JsonNode> findNodes = node.findValues(fldName);
		String[] array = findNodes.stream().map(element->{
			if( element.isValueNode() ) {
				return element.textValue();
			}else{
				return element.toString();
			}
		}).toArray(String[]::new);
		return array;
	}
	
	public static Object parseJsonToJavaType(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(json);
		return parseNode(node);
	}
	
	public static Object parseNode(JsonNode node) {
		Object result = null;
		if(node.isArray()) {
			result = parseArray(node);
		}else if(node.isObject()) {
			result = parseObject(node);
		}else {
			result = node.toString();
		}
		return result;
	}
	
	private static Map<String, Object> parseObject(JsonNode node) {
		Map<String, Object> resultMap = new LinkedHashMap<>();
		Iterator<Entry<String, JsonNode>> fields = node.fields();
		
		while (fields.hasNext()) {
			Entry<String, JsonNode> entry = fields.next();
			String fldName = entry.getKey();
			JsonNode tmp = entry.getValue();
			resultMap.put(fldName, parseNode(tmp));
		}// while end
		return resultMap;
	}
	
	private static List<Object> parseArray(JsonNode node){
		List<Object> list = new ArrayList<>();
		Iterator<JsonNode> it = node.elements();
		while (it.hasNext()) {
			JsonNode tmp = it.next();
			list.add(parseNode(tmp));
		}
		return list;
	}
	
	public static String marshalling(Object target) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(target);
	}
	
	public static <T> T unMarshalling(String content, Class<T> javaType) throws IOException {
		try(
			InputStream in = new ByteArrayInputStream(content.getBytes());
		){
			return unMarshalling(in, javaType);
		}
	}
	
	public static <T> T unMarshalling(InputStream in, Class<T> javaType) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(in, javaType);
	}
	
	public static <T> T[] unMarshallingToArray(String content, Class<T> elementType) throws IOException {
		try(
			InputStream in = new ByteArrayInputStream(content.getBytes());
		){
			return unMarshallingToArray(in, elementType);
		}
	}
	
	public static <T> T[] unMarshallingToArray(InputStream in, Class<T> elementType) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Class<?> arrayType = Class.forName("[L"+elementType.getName()+";");
			return (T[]) mapper.readValue(in, arrayType);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <C> C unMarshallingToCollection(String content, 
			Class<?> elementType, Class<? extends Collection> collectionType) throws IOException {
		try(
			InputStream in = new ByteArrayInputStream(content.getBytes());
		){
			return unMarshallingToCollection(in, elementType, collectionType);
		}
	}
	
	public static <C> C  unMarshallingToCollection(InputStream in, Class<?> elementType, Class<? extends Collection> collectionType) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		CollectionType cType = mapper.getTypeFactory().constructCollectionType(collectionType, elementType);
		return mapper.readValue(in, cType);
	}
}
