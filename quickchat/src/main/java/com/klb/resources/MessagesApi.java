package com.klb.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.klb.configuration.ConfigurationApp;
import com.klb.entities.Message;
import com.klb.service.MessagesService;

@RestController
@Path(value = "/messages")
public class MessagesApi {
	@Autowired
	MessagesService messagesService;
	
	@Autowired
	private ConfigurationApp configuration;
	
	
	@GET
	@Path("/message")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
	public  Message getMessage() {
		return messagesService.getMessage(1);
	}
	
	@GET
	@Path("/hello/{name}")
	public  String getHelloMessage( @PathVariable("name") String name) {
		return messagesService.hello(name);
	}
}
