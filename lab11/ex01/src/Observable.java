import java.util.ArrayList;
public class Observable {
    ArrayList<Observer> listOfObservers = new ArrayList<>();

    public void subscribe(Observer observer){
        listOfObservers.add(observer);
    }

    public void unsubscribe(Observer observer){
        listOfObservers.remove(observer);
    }
}
