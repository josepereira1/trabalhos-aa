public interface Subject {
    void registerObserver(ConcreteObserver concreteObserver);
    void removeObserver(int id);
    void notifyObservers();

}
