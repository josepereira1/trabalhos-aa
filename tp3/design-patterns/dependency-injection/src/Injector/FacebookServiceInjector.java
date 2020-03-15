package Injector;

import Consumer.*;
import Service.FacebookService;

public class FacebookServiceInjector implements MessageServiceInjector {
	 
	@Override
	public Consumer getConsumer() {
		return new Application(new FacebookService());
	}
}