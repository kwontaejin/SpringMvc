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
		ApiResDto result = ApiResDto.create("success", "¼º°ø");
		return result;
	}

}
