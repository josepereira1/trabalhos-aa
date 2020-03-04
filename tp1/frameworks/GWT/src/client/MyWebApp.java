package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class MyWebApp implements EntryPoint {
    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    @Override
    public void onModuleLoad() {
        final Label label = new Label("Hello World!");
        RootPanel.get("labelContainer").add(label);
    }
}
