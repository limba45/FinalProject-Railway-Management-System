package statedesign;
//Creating concrete classes implementing the same interface.
import observerdesign.ViewCoachesObserver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import iteratordesign.State;

public class ViewState implements State {

   public void doAction(Context context) {
       ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("PassengerDetailsData.txt"))); // Handle a potential exception
        }
        catch (IOException ex) {
            Logger.getLogger(ViewCoachesObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i<lines.size();i++){
        System.out.println("PASSENGER's NAME            : "+lines.get(i));
        System.out.println("PASSENGER's IDENTITY NUMBER : "+lines.get(i+1));
        System.out.println("PASSENGER's ADDRESS         : "+lines.get(i+2));
        System.out.println("PASSENGER's CELL NUMBER     : "+lines.get(i+3));
        i=i+3;
        System.out.println("\n");
        }
      context.setState(this);	
   }

   public String toString(){
      return "View Passenger Details State";
   }
}
