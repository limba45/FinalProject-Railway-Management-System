package statedesign;
//Creating concrete classes implementing the same interface.
import java.io.FileOutputStream;
import java.util.Scanner;
import iteratordesign.State;

public class EnterState implements State {

   public void doAction(Context context) {
       try{
            Scanner sc=new Scanner(System.in);                      //object of Scanner class  
            String name= "PassengerDetailsData.txt";                //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);// true for append mode  

            System.out.print("ENTER PASSENGER NAME: ");         
            String PassengerName=sc.nextLine()+"\n";                //str stores the string which we have entered  
            byte[] pname = PassengerName.getBytes();                //converts string into bytes  
            fos.write(pname);  
            
            System.out.print("ENTER PASSENGER's IDENTITY NUMBER: ");         
            String PassengerIdentity=sc.nextLine()+"\n";            //str stores the string which we have entered  
            byte[] pidentity = PassengerIdentity.getBytes();        //converts string into bytes  
            fos.write(pidentity); 

            System.out.print("ENTER PASSENGER's ADDRESS: ");
            String PassengerAddress=sc.nextLine()+"\n";             //str stores the string which we have entered  
            byte[] paddress = PassengerAddress.getBytes();          //converts string into bytes  
            fos.write(paddress);  
            
            System.out.print("ENTER PASSENGER's CELL NUMBER: ");
            String CellNumber=sc.nextLine()+"\n";                   //str stores the string which we have entered  
            byte[] cnumber = CellNumber.getBytes();                 //converts string into bytes  
            fos.write(cnumber); 
            
            fos.close();                                            //close the file  
            System.out.println("file saved.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
       context.setState(this);	
   }

   public String toString(){
      return "Enter Passenger Details Data State";
   }
}