public class Client {
    private Google service;

    public Client(Google service) {
        this.service = service;
    }

    public int getValue() {
        return service.getValue();
    }

    public void setValue(int x) {
        service.setValue(x);
    }

}
