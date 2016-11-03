package com.klb.entities;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;


public class Message
{

	private String message;
	private String author;
	private Date date;
	

	public Message(String message, String author, Date date) {
		super();
		this.message = message;
		this.author = author;
		this.date = date;
	}
	public Message() {
		super();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
