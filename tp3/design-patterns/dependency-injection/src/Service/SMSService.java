package Service;

public class SMSService implements MessageService {
	
	@Override
	public void sendMessage(String message) {
		System.out.println("SMS: " + message);
	}
}