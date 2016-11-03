package jsonextender;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.thoughtworks.xstream.XStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class SwaggerJsonExtender {
	
	public String readTextFromResources(String fileName) {
		String result = "";
		ClassLoader classLoader = getClass().getClassLoader();
		try {
		    result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	public Services convertFromXML(String xml) {
		XStream xstream = new XStream();
		xstream.processAnnotations(Service.class);   
		xstream.processAnnotations(Services.class);     
		Services services = (Services)xstream.fromXML(xml);
		
		return services;
	}
}
