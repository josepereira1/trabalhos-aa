public class GoogleCache implements Google {

    private GoogleClass service;
    private int value;
    private boolean needReset = false;

    public GoogleCache(GoogleClass service) {
        this.service = service;
        this.value = this.service.getValue();
    }

    @Override
    public int getValue() {
        if(needReset) {
            System.out.println("Acess to the real service");
            this.value = this.service.getValue();
            this.needReset = false;
        }
        return this.value;
    }

    @Override
    public void setValue(int x) {
        System.out.println("Acess to the real service");
        this.service.setValue(x);
        this.needReset = true;
    }
}
