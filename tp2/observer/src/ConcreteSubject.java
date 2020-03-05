import java.util.*;

public class ConcreteSubject implements Subject {
    private int state;
    private Map<Integer,Observer> observers;
    private int lastId;

    public ConcreteSubject(){
        this.state = 0;
        this.observers = new HashMap<>();
        this.lastId = 0;
    }

    @Override
    public void registerObserver(ConcreteObserver concreteSubject) {
        lastId++;
        concreteSubject.id = lastId;
        System.out.println("Register observer with id " + lastId + "!");
        observers.put(lastId , concreteSubject);
    }

    @Override
    public void removeObserver(int id) {
        System.out.println("Remove observer with id " + id);
        observers.remove(id);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Notify observers!");
        for(Observer ob : observers.values())ob.update();
    }

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        this.state = state;
    }
}
