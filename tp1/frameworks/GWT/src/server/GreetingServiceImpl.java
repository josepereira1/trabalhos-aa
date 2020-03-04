package server;

import client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GreetingServiceImpl extends RemoteServiceServlet implements
        GreetingService {
    @Override
    public String greetServer(String name) throws IllegalArgumentException {
        return null;
    }
}
