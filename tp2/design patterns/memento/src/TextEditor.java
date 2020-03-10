import java.util.Stack;

public class TextEditor {

    private Stack<Memento> savedTextBoxes; // stack holding snapshots
    private TextBox textBox; // current text box
    private boolean autoSave; // if true automatically saves text box before making changes

    public TextEditor() {
        savedTextBoxes = new Stack<>();
        textBox = new TextBox();
        autoSave = false;
    }

    public void appendText(String text) {
        if (autoSave) save(); // creates a snapshot before making changes
        textBox.appendText(text);
    }

    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }

    public void display() {
        System.out.println(">> " + textBox.getText());
    }

    public void save() {
        Memento snapshot = textBox.save(); // creates snapshot
        savedTextBoxes.push(snapshot); // saves it
    }

    public void undo() {
        System.out.println("undo clicked...");
        Memento snapshot = savedTextBoxes.pop();
        snapshot.restore();
    }

    @Override
    public String toString() {
        return "TextEditor{" +
                "savedTextBoxes=" + savedTextBoxes +
                ", textBox=" + textBox +
                ", autoSave=" + autoSave +
                '}';
    }
}
