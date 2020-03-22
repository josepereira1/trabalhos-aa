public class UIHandler implements Mediator {

    private Button button;
    private TextBox textBox;
    private TextInput nameTextInput;

    @Override
    public void addComponent(Component component) {
        if (component instanceof Button) button = (Button) component;
        else if (component instanceof TextBox) textBox = (TextBox) component;
        else if (component instanceof TextInput) nameTextInput = (TextInput) component;
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender.equals(button)) reactOnButton(event);
        else if (sender.equals(textBox)) reactOnTextBox(event);
        else if (sender.equals(nameTextInput)) reactOnTextInput(event);
    }

    private void reactOnButton(String event) {
        switch (event) {
            case "click":
                String name = nameTextInput.getText();
                textBox.setText("Hello " + name + "!");
                System.out.println(textBox.getText());
                break;
            case "hover":
                textBox.setText("Mouse is over button!");
                System.out.println(textBox.getText());
                break;
            default:
                break;
        }
    }

    private void reactOnTextBox(String event) {}

    private void reactOnTextInput(String event) {}
}
