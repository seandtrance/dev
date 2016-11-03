package com.klb.dataservice;

import org.springframework.stereotype.Component;

@Component
public class DataAcccessImpl implements DataAcccess {

	@Override
	public String dataAccessTest() throws Exception {
		//for mockito demonstration
		//throw new Exception("Problem with connection");
		
		return "access success";
	}

}
