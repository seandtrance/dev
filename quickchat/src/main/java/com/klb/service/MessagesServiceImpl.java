package com.klb.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klb.dataservice.DataAcccess;
import com.klb.entities.Message;

@Service
public class MessagesServiceImpl implements MessagesService {
	
	@Autowired
	private DataAcccess dataAcccess;
	
	@Override
	public Message getMessage(int id)  {
		try {
			Message m = new Message();
			m.setMessage(dataAcccess.dataAccessTest() + " hello everyubody");
			m.setDate(new Date());
			m.setAuthor("Jack Aaaa");
			return m;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String hello(String name) {
		return "Hello " + name;
	}
}
