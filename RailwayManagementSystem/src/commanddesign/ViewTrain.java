package commanddesign;
//We have concrete command classes ViewTrain implementing Order interface which will do actual command processing
import commanddesign.Train;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewTrain implements Order {
    private Train train;

   public ViewTrain(Train train){
      this.train = train;
   }

    public void execute() {
        try {
            train.view();
        } catch (IOException ex) {
            Logger.getLogger(ViewTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}    

