public class TextBox implements Originator {

    private StringBuilder currentText;

    public TextBox() {
        currentText = new StringBuilder();
    }

    public void appendText(String text) {
        currentText.append(text);
    }

    public void setText(String text) {
        this.currentText.setLength(0); // more efficient than creating a new instance
        this.currentText.append(text);
    }

    public String getText() {
        return currentText.toString();
    }

    public Memento save() {
        return new TextBoxSnapshot(this, currentText.toString());
    }

    @Override
    public String toString() {
        return "TextBox{" +
                "currentText=" + currentText +
                '}';
    }
}


