package by.undrul.shapestask.observer;

public interface TetrahedronObservable {
    void attach(TetrahedronObserver tetrahedronObserver);
    void detach(TetrahedronObserver tetrahedronObserver);
    void notifyObservers();
}
