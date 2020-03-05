public class Main {
    /*
        Design Pattern Observer:
        Implement one to many dependency, where dependent objects are notified when the object state changes.
     */

    public static void main(String[] args){
        int numberOfObservers = 5;
        ConcreteSubject subject = new ConcreteSubject();    //  objecto observado

        //  objeto que observa o subject(objecto observado)
        //  a criação deste ConcreteObserver é apenas para poder utilizar mais abaixo
        ConcreteObserver ob1 = new ConcreteObserver(subject);

        //  criação de vários observers
        for(int i = 0; i < numberOfObservers; i++) new ConcreteObserver(subject);

        System.out.println("current state = " + subject.getState());

        try {
            System.out.println("Thread sleep!");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread wake up!");

        //  mudamos o estado, e de seguida notificar os observadores desta mudança
        System.out.println("Change state to 50!");
        subject.setState(50);
        subject.notifyObservers();

        /*
        mudamos o estado, mas não notificamos imediatamente os observadores,
        para verificar que se estes não forem notificados, têm valores de estado desatualizados
         */
        subject.setState(5000);

        System.out.println("Change State: " + subject.getState());
        System.out.println("Current state of observer 1 before notify observers: " + ob1.getState());

        subject.notifyObservers();

        subject.removeObserver(3);
        System.out.println("Set state to 10000");
        subject.setState(10000);
        subject.notifyObservers();

    }
}
