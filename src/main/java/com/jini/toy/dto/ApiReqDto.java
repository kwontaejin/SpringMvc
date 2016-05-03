package com.jini.toy.dto;

import java.util.Map;

import com.google.common.collect.Maps;

public class ApiReqDto {

	private Map<String, Object> params = Maps.newHashMap();
	
	public Map<String, Object> getParams() {
		return params;
	}
	
	public String getWithDefault(String key, String defaultValue) {
		if(params == null || params.get(key) == null) {
			return defaultValue;
		}
		
		return (String)params.get(key);
	}
	
	public Map<String, Object> putParam(String key, String value) {
		if(params == null) {
			params = Maps.newHashMap();
		}
		
		params.put(key, value);
		
		return params;
	}
}
