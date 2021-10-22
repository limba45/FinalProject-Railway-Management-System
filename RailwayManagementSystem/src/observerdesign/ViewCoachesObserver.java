package observerdesign;
//Create concrete observer classes
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewCoachesObserver extends CoachesObserver {
    public ViewCoachesObserver(Coaches coaches){
        this.coaches = coaches;
        this.coaches.attach(this);
    }

    @Override
    public void update() {
        ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("CoachesData.txt"))); // Handle a potential exception
        } catch (IOException ex) {
            Logger.getLogger(ViewCoachesObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i<lines.size();i++){
        System.out.println("COACH NAME   : "+lines.get(i));
        System.out.println("COACH DETAILS: "+lines.get(i+1));
        i=i+1;
        System.out.println("\n");
        }
    }
    
}
