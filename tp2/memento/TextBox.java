public class TextBox {

    private StringBuilder currentText;

    public TextBox() {
        currentText = new StringBuilder();
    }

    public void appendText(String text) {
        currentText.append(text);
    }

    public void setText(String text) {
        this.currentText.setLength(0); // more efficient than create a new instance
        this.currentText.append(text);
    }

    public String getText() {
        return currentText.toString();
    }

    public TextBoxSnapshot save() {
        return new TextBoxSnapshot(this, currentText.toString());
    }

    @Override
    public String toString() {
        return "TextBox{" +
                "currentText=" + currentText +
                '}';
    }
}


