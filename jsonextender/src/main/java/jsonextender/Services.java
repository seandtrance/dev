package jsonextender;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;



@XStreamAlias("services") 
public class Services {
	@XStreamImplicit
	private List<Service> service = new ArrayList<>();

	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}


}