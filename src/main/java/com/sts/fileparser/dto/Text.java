package com.sts.fileparser.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


//class for text logic

@XmlRootElement(name = "text")
@XmlType(propOrder = { "sentences" })
public class Text {

	private List<Sentence> sentences = new ArrayList<Sentence>();

	@XmlElement(name = "sentence", type = Sentence.class)
	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}

	public void addSentences(Sentence sentence) {
		this.sentences.add(sentence);
	}

}
