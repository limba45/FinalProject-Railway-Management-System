package factorydesign;
//Create concrete classes implementing the same interface.
import observerdesign.ViewCoachesObserver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewSchedule implements Schedule{
   public void viewEnterSchedule() {
       ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("ScheduleData.txt"))); // Handle a potential exception
        }
        catch (IOException ex) {
            Logger.getLogger(ViewCoachesObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i<lines.size();i++){
        System.out.println("TRAIN NAME      : "+lines.get(i));
        System.out.println("DEPARTURE TIME  : "+lines.get(i+1));
        System.out.println("ARRIVAL TIME    : "+lines.get(i+2));
        i=i+2;
        System.out.println("\n");
        }
   }    
}
