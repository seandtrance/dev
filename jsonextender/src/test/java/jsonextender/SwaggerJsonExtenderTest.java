package jsonextender;

import org.junit.Test;

public class SwaggerJsonExtenderTest {
	
	@Test
	public void test() {
		SwaggerJsonExtender swaggerJsonExtender= new SwaggerJsonExtender();
		String xml = swaggerJsonExtender.readTextFromResources("samples.xml");
		Services s = swaggerJsonExtender.convertFromXML(xml);
		
		System.out.println("test");
	}
}
