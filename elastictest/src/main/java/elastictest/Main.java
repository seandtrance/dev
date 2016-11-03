package elastictest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map.Entry;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.SearchHits;

import static org.elasticsearch.common.xcontent.XContentFactory.*;


public class Main {

	private final static String INDEX = "loggers";

	
	
	public static void main(String[] args) throws IOException {
		Client client = null;
		
		try {
			client = TransportClient.builder().build()
					   .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		SearchResponse allHits = client.prepareSearch(INDEX)
                .addFields("status")
                .setQuery(QueryBuilders.matchAllQuery())
                .execute().actionGet();
		
		
		
		SearchHits sh = allHits.getHits();
	
		System.out.println(allHits);

//		  XContentBuilder builder = XContentFactory.jsonBuilder();
//		  builder.startObject();
//		  allHits.toXContent(builder, ToXContent.EMPTY_PARAMS);
//		  builder.endObject();
//		  
//		  System.out.println(builder.string());

	}

}
