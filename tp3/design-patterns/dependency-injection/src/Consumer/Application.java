package Consumer;

import Service.MessageService;

public class Application implements Consumer {
	MessageService service;

	public Application(MessageService service) {
		this.service = service;
	}

	@Override
	public void processMessage(String msg) {
		this.service.sendMessage(msg);
	}
}