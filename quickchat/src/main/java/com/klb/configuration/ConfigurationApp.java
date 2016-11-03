package com.klb.configuration;


import io.dropwizard.Configuration;


public class ConfigurationApp extends Configuration {

	private String appname;

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}
	 
}
