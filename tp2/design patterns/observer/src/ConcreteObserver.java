import java.time.LocalDateTime;

public class ConcreteObserver implements Observer{
    private Subject subject;
    private int state;

    public ConcreteObserver(Subject subject){
        this.subject = subject;
        this.subject.registerObserver(this);
        //  observer registers on the subject
    }

    @Override
    public void update(Object info) {
        LocalDateTime time = null;
        if(info instanceof Object[]){
            Object[] arr = (Object[]) info;
            this.state = (Integer) arr[0];
            time = (LocalDateTime) arr[1];
        }
        System.out.println("observer: state = " + this.state + " | time = " + time);
    }

    // other methods

    public int getState(){
        return this.state;
    }
}
