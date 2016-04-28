package com.jini.toy.dto;

import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;

public class ApiResDto {
	
	private final String resCode;
	private final String resMessage;

	private Map<String, Object> data = Maps.newHashMap();
	
	private ApiResDto(String resCode, String resMessage) {
		this.resCode = resCode;
		this.resMessage = resMessage;
	}
	
	public static ApiResDto create(String resCode, String resMessage) {
		return new ApiResDto(resCode, resMessage);
	}
	
	public Map<String, Object> getData() {
		return data;
	}
	
	public Map<String, Object> putData(String key, Object value) {
		data.put(key, value);
		return data;
	}
	
	public String getResCode() {
		return resCode;
	}

	public String getResMessage() {
		return resMessage;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).toString();
	}
}
