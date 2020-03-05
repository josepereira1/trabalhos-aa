public class ConcreteObserver implements Observer {
    public int id;
    private ConcreteSubject subject;
    private int state;

    public ConcreteObserver(ConcreteSubject subject){
        subject.registerObserver(this);//  o próprio ConcreteObserver se regista como observador
        this.subject = subject;
    }

    @Override
    public void update() {
        this.state = this.subject.getState();
        System.out.println("id = "+ this.id + " | value = " + this.state);
    }

    // other methods

    public int getState(){
        return this.state;
    }
}
