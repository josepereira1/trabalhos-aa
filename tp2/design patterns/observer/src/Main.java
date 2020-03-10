import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){
        int numberOfObservers = 3;

        //  subject
        ConcreteSubject subject = new ConcreteSubject();

        //  observer register
        ConcreteObserver obs = new ConcreteObserver(subject);

        //  create multiple observers
        for(int i = 0; i < numberOfObservers; i++) new ConcreteObserver(subject);

        System.out.println("initial state: " + subject.getState());

        //  the state is changed, then observers are notified
        subject.setState(50);

        System.out.println("change state value to: " + subject.getState());

        //  here, we are sending additional information to observers
        subject.notifyObservers(LocalDateTime.now());

        subject.setState(5741);
        System.out.println("change state value to: " + subject.getState());
        subject.notifyObservers(LocalDateTime.now());


        //  the status is changed and do not notify observers immediately and 
        //  check that the status of observers is not updated
        subject.setState(-457);
        System.out.println("change state value to: " + subject.getState());
        System.out.println("state of observer before notifyObservers: " + obs.getState());
        subject.notifyObservers(LocalDateTime.now());

        //  remove observer obs
        subject.removeObserver(obs);
    }
}
