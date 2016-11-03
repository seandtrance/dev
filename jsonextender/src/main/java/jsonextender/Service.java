package jsonextender;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Service")
public class Service {
	
	@XStreamAlias("path") 
	@XStreamAsAttribute   
	private String path;
	
	@XStreamAlias("method") 
	@XStreamAsAttribute   
	private String method;
	
	@XStreamImplicit
	private List<String> example;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<String> getExample() {
		return example;
	}
	public void setExample(List<String> example) {
		this.example = example;
	}
	
	
}
