package com.exchange.services.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.exchange.services.controller.AppErrorController;

@WebMvcTest({ AppErrorController.class})
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ApplicationTest {


	private static final String NO_PAGE="/nopagelikethis";
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAppError() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(NO_PAGE)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isNotFound());
	}
	
}
