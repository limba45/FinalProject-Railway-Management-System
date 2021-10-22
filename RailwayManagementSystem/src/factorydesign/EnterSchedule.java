package factorydesign;
//Create concrete classes implementing the same interface.
import java.io.FileOutputStream;
import java.util.Scanner;


public class EnterSchedule implements Schedule{
   public void viewEnterSchedule() {
      try{
            Scanner sc=new Scanner(System.in);                //object of Scanner class  
            String name= "ScheduleData.txt";                  //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);  // true for append mode  

            System.out.print("ENTER TRAIN NAME: ");         
            String TrainName=sc.nextLine()+"\n";               //str stores the string which we have entered  
            byte[] tname = TrainName.getBytes();                  //converts string into bytes  
            fos.write(tname);  
            
            System.out.print("ENTER DEPARTURE TIME: ");         
            String departure=sc.nextLine()+"\n";                   //str stores the string which we have entered  
            byte[] depart = departure.getBytes();                       //converts string into bytes  
            fos.write(depart); 

            System.out.print("ENTER ARRIVEAL TIME: ");
            String ArrivalTime=sc.nextLine()+"\n";             //str stores the string which we have entered  
            byte[] atime = ArrivalTime.getBytes();                //converts string into bytes  
            fos.write(atime);                                  
            
            fos.close();                                      //close the file  
            System.out.println("file saved.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
   }    
}
