import Consumer.Consumer;
import Injector.*;

public class Main {
	public static void main(String[] args) {
		String msg = "Hello";
		MessageServiceInjector injector = null;
		Consumer consumer = null;

		//Send Email
		injector = new EmalServiceInjector();
		consumer = injector.getConsumer();
		consumer.processMessage(msg);

		//Send SMS
		injector = new SMSServiceInjector();
		consumer = injector.getConsumer();
		consumer.processMessage(msg);
	}
}