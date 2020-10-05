package com.jjc.util;

import java.io.IOException;
import java.net.URISyntaxException;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

/**
 * 生成图片模板，固定位置填充文字
 * @author jjc
 * 2020-07-13
 */
public class CreatePdf2IText {
	
	public static void create(String imagePath, String outfile, String font) throws IOException, URISyntaxException {
		// Creating an ImageData object
		ImageData data = ImageDataFactory.create(imagePath);
		// Creating an Image object
		Image image = new Image(data);
		
		PdfWriter writer = new PdfWriter(outfile);

		// Creating a PdfDocument
		PdfDocument pdf = new PdfDocument(writer);
		PageSize pageSize = new PageSize(image.getImageWidth(), image.getImageHeight());
		pdf.setDefaultPageSize(pageSize);

		// Creating a Document
		Document document = new Document(pdf);
		document.setMargins(0, 0, 0, 0);
		
		// Adding font
		System.out.println(font);
		FontProgram fontProgram = FontProgramFactory.createFont(font);
		PdfFont pdfFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.IDENTITY_H, true);
		document.setFont(pdfFont);
		document.setFontSize(22);
		
		// Adding image to the document
		document.add(image);
		
		// Adding text
		document.add(new Paragraph("11测试").setFont(pdfFont).setFixedPosition(1, 170, 330, 100));
		
		// Closing the document
		document.close();
	}
	
	public static String path(String filename) throws URISyntaxException {
		return CreatePdf2IText.class.getClassLoader().getResource(filename).toURI().getPath();
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		CreatePdf2IText.create(CreatePdf2IText.path("static/temp.jpg"), 
				"D:/test.pdf", CreatePdf2IText.path("static/SIMFANG.TTF"));
	}
}
