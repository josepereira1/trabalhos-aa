package Injector;

import Consumer.*;
import Service.EmailService;

public class EmailServiceInjector implements MessageServiceInjector {
	 
	@Override
	public Consumer getConsumer() {
		return new Application(new EmailService());
	}
}