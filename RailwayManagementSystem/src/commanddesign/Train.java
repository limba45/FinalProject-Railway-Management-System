package commanddesign;
//Train uses command pattern to identify which object will execute which command based on the type of command
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Train {
      public void view() throws IOException {
       ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("TrainRecordsData.txt"))); // Handle a potential exception
       for(int i = 0; i<lines.size();i++){
       System.out.println("TRAIN NAME    : "+lines.get(i));
       System.out.println("TRAIN NUMBER  : "+lines.get(i+1));
       System.out.println("TRAIN ROUTE   : "+lines.get(i+2));
       System.out.println("TRAIN TYPE    : "+lines.get(i+3));
       System.out.println("TRAIN COACHES : "+lines.get(i+4));
       i=i+4;
       System.out.println("\n");
       }
   }
    
    public void enter(){
        try
        {
            Scanner sc=new Scanner(System.in);                //object of Scanner class  
            String name= "TrainRecordsData.txt";                   //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);  // true for append mode  

            System.out.print("ENTER TRAIN NAME: ");         
            String TrainName=sc.nextLine()+"\n";           //str stores the string which we have entered  
            byte[] tname = TrainName.getBytes();              //converts string into bytes  
            fos.write(tname);  

            System.out.print("ENTER TRAIN NUMBER: ");
            String TrainNumber=sc.nextLine()+"\n";                   //str stores the string which we have entered  
            byte[] tnumber = TrainNumber.getBytes();                       //converts string into bytes  
            fos.write(tnumber); 

            System.out.print("ENTER TRAIN ROUTE: ");
            String TrainRoute=sc.nextLine()+"\n";               //str stores the string which we have entered  
            byte[] troute = TrainRoute.getBytes();                  //converts string into bytes  
            fos.write(troute);  
            
            System.out.print("ENTER TRAIN TYPE: ");
            String TrainType=sc.nextLine()+"\n";               //str stores the string which we have entered  
            byte[] ttype = TrainType.getBytes();                  //converts string into bytes  
            fos.write(ttype);
            
            System.out.print("ENTER TRAIN COACHES: ");
            String TrainCoaches=sc.nextLine()+"\n";               //str stores the string which we have entered  
            byte[] tcoaches = TrainCoaches.getBytes();                  //converts string into bytes  
            fos.write(tcoaches);
            
            fos.close();                                      //close the file  
            System.out.println("file saved.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
  
}
  
  



