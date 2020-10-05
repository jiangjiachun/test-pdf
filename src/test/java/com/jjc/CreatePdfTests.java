package com.jjc;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import com.jjc.util.CreatePdf2IText;

public class CreatePdfTests {

	@Test
	public void create2IText() throws URISyntaxException, IOException {
		CreatePdf2IText.create(CreatePdf2IText.path("static/temp.jpg"), 
				"D:/test.pdf", CreatePdf2IText.path("static/SIMFANG.TTF"));
	}
}
