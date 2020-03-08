import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){
        int numberOfObservers = 3;

        //  subject
        ConcreteSubject subject = new ConcreteSubject();

        //  create multiple observers
        for(int i = 0; i < numberOfObservers; i++) new ConcreteObserver(subject);

        System.out.println("initial state: " + subject.getState());

        //  the status is changed, then observers are notified
        subject.setState(50);

        System.out.println("change state value to: " + subject.getState());

        //  here, we are sending additional information to observers
        subject.notifyObservers(LocalDateTime.now());

        subject.setState(5741);
        System.out.println("change state value to: " + subject.getState());
        subject.notifyObservers(LocalDateTime.now());
    }
}
