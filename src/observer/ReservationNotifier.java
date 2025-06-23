package observer;

import java.util.ArrayList;
import java.util.List;

public class ReservationNotifier implements ReservationSubject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(String message){
        for(Observer o : observers){
            o.update(message);
        }
    }

}
