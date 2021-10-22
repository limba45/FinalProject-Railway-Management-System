package observerdesign;
//Create concrete observer classes
import java.io.FileOutputStream;
import java.util.Scanner;

public class EnterCoachesObserver extends CoachesObserver {
    public EnterCoachesObserver(Coaches coaches){
        this.coaches = coaches;
        this.coaches.attach(this);
    }

    @Override
    public void update() {
        try{
            Scanner sc=new Scanner(System.in);                          //object of Scanner class  
            String name= "CoachesData.txt";                             //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);    // true for append mode  

            System.out.print("ENTER COACH NUMBER: ");         
            String CoachName=sc.nextLine()+"\n";                        //str stores the string which we have entered  
            byte[] cname = CoachName.getBytes();                        //converts string into bytes  
            fos.write(cname);  
            
            System.out.print("ENTER DETAILS OF ATTACHMENT OF COACH: ");         
            String CoachDetails=sc.nextLine()+"\n";                     //str stores the string which we have entered  
            byte[] cdetails = CoachDetails.getBytes();                  //converts string into bytes  
            fos.write(cdetails); 
            
            fos.close();                                                //close the file  
            System.out.println("file saved.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
