package com.jini.toy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jini.toy.dto.ApiReqDto;
import com.jini.toy.dto.ApiResDto;

@Controller
public class DocController {

	@RequestMapping("/toy/docs")
	public @ResponseBody ApiResDto getDocs(ApiReqDto param) {
		
		String itemId = param.getWithDefault("itemId", "123456789");
		String salestrNo = param.getWithDefault("salestrNo", "2034");
		String siteNo = param.getWithDefault("siteNo", "6001");
		
		
		if(itemId.equals("123456789") && siteNo.equals("6001") && salestrNo.equals("2034")) {
			ApiResDto result = ApiResDto.create("success", "성공");
			result.putData("itemId", "123456789");
			result.putData("itemNm", "감자칩");
			result.putData("brandId", "55555555");
			result.putData("brandNm", "노브랜드");
			result.putData("sellPrc", "10000");
			return result;	
		} else {
			ApiResDto result = ApiResDto.create("Fail", "실패");
			return result;
		}
	}

}
