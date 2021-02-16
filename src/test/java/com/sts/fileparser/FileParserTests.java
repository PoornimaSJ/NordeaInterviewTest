package com.sts.fileparser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sts.fileparser.config.FileParserAppConfigDto;
import com.sts.fileparser.config.XmlFileParser;
import com.sts.fileparser.service.FileParserServiceImpl;

public class FileParserTests {

	@InjectMocks
	private FileParserServiceImpl fileParserServiceImpl;

	@Mock
	private FileParserAppConfigDto fileParserAppConfigDto;

	@Mock
	private XmlFileParser xmlFileParser;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testEmptyInputFilePath() {
		try {
			//System.out.println("test method");
			Mockito.when(fileParserAppConfigDto.getInputFilePath()).thenReturn("");
			fileParserServiceImpl.parseFileContent();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Input file path is empty");
		}
	}

	@Test
	public void testEmptyOutputXmlFilePath() {
		try {
			Mockito.when(fileParserAppConfigDto.getXmlOutputFilePath()).thenReturn("");
			xmlFileParser.marshal(Mockito.any());
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Output File Path is empty");
		}
	}

}
