package com.sts.fileparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.sts.fileparser.config.FileParserException;
import com.sts.fileparser.dto.Text;
import com.sts.fileparser.service.FileParserServiceImpl;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class FileParserApp implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger(FileParserApp.class);

	@Autowired
	private FileParserServiceImpl fileParserServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(FileParserApp.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			LOGGER.debug("File Parsing started");
			Text text = fileParserServiceImpl.parseFileContent();
			fileParserServiceImpl.generateOutputFile(text);
			LOGGER.debug("File Parsing is completed");
		} catch (FileParserException e) {
			LOGGER.error("File Parser Exception" + e.getMessage());
			System.out.println("File Parser Exception" + e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Exception in Parsing file " + e.getMessage());
			System.out.println("Exception in Parsing file " + e.getMessage());
		}
	}

}
