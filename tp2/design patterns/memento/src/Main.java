public class Main {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.setAutoSave(true);

        textEditor.appendText("Hello");
        textEditor.display();
        // System.out.println(textEditor);
        textEditor.appendText(" World!");
        textEditor.display();
        // System.out.println(textEditor);
        textEditor.undo();
        // System.out.println(textEditor);
        textEditor.display();
    }
}
