package commanddesign;
//We have concrete command classes EnterTrain implementing Order interface which will do actual command processing

import commanddesign.Train;

public class EnterTrain implements Order {
    private Train train;

   public EnterTrain(Train train){
      this.train = train;
   }

   public void execute() {
      train.enter();
   }
}    

