package com.sts.fileparser.service;

import org.springframework.stereotype.Component;

import com.sts.fileparser.config.FileParserException;
import com.sts.fileparser.dto.Text;

//Interface for parsing file

@Component
public interface FileParserService {
	
	Text parseFileContent() throws FileParserException;
	
	void generateOutputFile(Text text);

}
