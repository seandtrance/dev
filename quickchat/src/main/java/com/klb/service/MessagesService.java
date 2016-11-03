package com.klb.service;

import com.klb.entities.Message;

public interface MessagesService {
	public Message getMessage(int id);
	public String hello(String name);
}
