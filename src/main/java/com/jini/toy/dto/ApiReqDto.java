package com.jini.toy.dto;

import java.util.Map;

import com.google.common.collect.Maps;

public class ApiReqDto {

	private Map<String, Object> params = Maps.newHashMap();
	
	public Map<String, Object> getParams() {
		return params;
	}
}
