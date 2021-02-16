package com.sts.fileparser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sts.fileparser.config.ApplicationConfigDto;
import com.sts.fileparser.config.XmlUtil;
import com.sts.fileparser.service.FileParserServiceImpl;

public class FileParserTests {

	@InjectMocks
	private FileParserServiceImpl fileParserServiceImpl;

	@Mock
	private ApplicationConfigDto applicationConfigDto;

	@Mock
	private XmlUtil xmlUtil;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testEmptyInputFilePath() {
		try {
			//System.out.println("test method");
			Mockito.when(applicationConfigDto.getInputFilePath()).thenReturn("");
			fileParserServiceImpl.parseFileContent();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Input file path is empty");
		}
	}

	@Test
	public void testEmptyOutputXmlFilePath() {
		try {
			Mockito.when(applicationConfigDto.getXmlOutputFilePath()).thenReturn("");
			xmlUtil.marshal(Mockito.any());
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Output File Path is empty");
		}
	}

}
