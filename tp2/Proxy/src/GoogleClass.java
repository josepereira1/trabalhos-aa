public class GoogleClass implements Google {

    private int value;

    protected GoogleClass() {
        this.value = 0;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int x) {
        this.value = x;
    }
}
