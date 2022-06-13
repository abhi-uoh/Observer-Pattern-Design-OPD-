import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoardImpl implements Board{

    private List<Observer> observers;
    private String message;
    private boolean changed;


    public ScoreBoardImpl(){
        this.observers = new ArrayList<>();
    }


    @Override
    public void register(Observer obj) {
        if(obj==null){
            throw new NullPointerException("Null observer Registered");
        }
        if(!observers.contains(obj)){
            observers.add(obj);
        }

    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObserver() {
        if(!changed){
            return;
        }
        else {
            this.changed = false;
            for (Observer observer: this.observers) {
                observer.update();

            }
        }

    }

    @Override
    public Object getUpdate(Observer obj) {

        return this.message;
    }
    public void postMessage(String  msg){
        System.out.println("Message posted : " + msg);
        this.message = msg;
        this.changed = true;
        notifyObserver();
    }
}
