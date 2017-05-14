package com.jini.toy;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jini.toy.dto.ApiReqDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestNotesSpringDataRest.class)
@WebAppConfiguration
public class DocDocumentation {
	
	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation))
//				.alwaysDo(document("{class-name}/{method-name}",
//						preprocessRequest(prettyPrint()),
//							preprocessResponse(prettyPrint())
//							))
				.build();
	}

	@Test
	public void test1() throws Exception {
		
		ApiReqDto reqDto = new ApiReqDto();
		reqDto.putParam("siteNo", "6001");
		reqDto.putParam("salestrNo", "2034");
		
		ObjectMapper mapper = new ObjectMapper();
		String contentStr = mapper.writeValueAsString(reqDto);
		
		
		this.mockMvc.perform(post("/toy/docs").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
								.content(contentStr))
								.andExpect(status().isOk())
								.andExpect(jsonPath("$.data.*").exists())
								.andDo(document("{class-name}/{method-name}",
										preprocessRequest(prettyPrint()),
										preprocessResponse(prettyPrint()),
										responseFields(
												fieldWithPath("data.itemId").description("상품ID"),
												fieldWithPath("data.itemNm").description("상풍명"),
												fieldWithPath("resCode").description("응답코드"),
												fieldWithPath("resMessage").description("응답메시지"),
												fieldWithPath("data.brandNm").description("브랜드명"),
												fieldWithPath("data.sellPrc").description("판매가격"),
												fieldWithPath("data.brandId").description("브랜드ID")))
										);
	}
}