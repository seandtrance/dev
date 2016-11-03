package quickchat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.klb.dataservice.DataAcccess;
import com.klb.service.MessagesService;
import com.klb.service.MessagesServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MessagesServiceImplTest {
	
	@Mock
	DataAcccess dataAcccess;
	
	@InjectMocks
	MessagesService messagesService = new MessagesServiceImpl();
		
	@Test
	public void getMessageTest() {
		try {
			Mockito.when(dataAcccess.dataAccessTest()).thenReturn("mock test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("mock test hello everyubody", messagesService.getMessage(1).getMessage());
	}

}
