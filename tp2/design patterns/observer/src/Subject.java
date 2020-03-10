public interface Subject {
    void registerObserver(Observer concreteObserver);
    void removeObserver(Observer observer);
    void notifyObservers(Object info);
}
