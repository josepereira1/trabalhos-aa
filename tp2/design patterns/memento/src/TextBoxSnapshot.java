import java.time.LocalDateTime;

public class TextBoxSnapshot implements Memento {

    private TextBox originator;

    // cloned state variables from originator (TextBox)
    private String text;

    // custom variables for advanced features
    private LocalDateTime savedAt;

    public TextBoxSnapshot(TextBox originator, String text) {
        this.originator = originator;
        this.text = text;
        savedAt = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return savedAt;
    }

    public void restore() {
        originator.setText(text);
    }

    @Override
    public String toString() {
        return "TextBoxSnapshot{" +
                "originator=" + originator +
                ", text='" + text + '\'' +
                ", savedAt=" + savedAt +
                '}';
    }
}


