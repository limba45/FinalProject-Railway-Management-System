package observerdesign;
//Coaches is an object having methods to attach and detach observers to a client object
import java.util.ArrayList;
import java.util.List;

public class Coaches {
    private List<CoachesObserver> coachesobservers = new ArrayList<CoachesObserver>();
    private int state;
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(CoachesObserver coachobserver){
        coachesobservers.add(coachobserver);
    }

    public void notifyAllObservers(){
        for (CoachesObserver coachesobserver : coachesobservers) {
        coachesobserver.update();
        }
    } 	
    
}
