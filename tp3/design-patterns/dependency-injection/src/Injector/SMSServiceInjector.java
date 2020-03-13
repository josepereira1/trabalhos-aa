package Injector;

import Consumer.*;
import Service.SMSService;

public class SMSServiceInjector implements MessageServiceInjector {
	 
	@Override
	public Consumer getConsumer() {
		return new Application(new SMSService());
	}
}