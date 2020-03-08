import java.util.ArrayList;
import java.util.Collection;

public class ConcreteSubject implements Subject {
    private int state;
    private Collection<Observer> observers;

    public ConcreteSubject(){
        this.state = 0;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Object info) {
        System.out.println("notify observers");
        Object[] arr = new Object[2];   //  array with info to send
        arr[0] = this.state;            //  state
        arr[1] = info;                  //  time
        for(Observer ob : observers)ob.update(arr);
    }

    // other methods

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        this.state = state;
    }
}
