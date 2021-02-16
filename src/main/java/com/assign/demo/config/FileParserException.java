package com.assign.demo.config;

/**
 *         Custom Exception class for handling file parsing exceptions.
 *
 */
public class FileParserException extends Exception {

	private static final long serialVersionUID = 1L;

	public FileParserException() {
		super();
	}

	public FileParserException(String error) {
		super(error);
	}

}
