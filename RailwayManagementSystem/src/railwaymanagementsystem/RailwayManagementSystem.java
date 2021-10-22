package railwaymanagementsystem;

import iteratordesign.Iterator;
import statedesign.EnterState;
import statedesign.ViewState;
import statedesign.Context;
import factorydesign.ScheduleFactory;
import factorydesign.Schedule;
import observerdesign.EnterCoachesObserver;
import observerdesign.Coaches;
import observerdesign.ViewCoachesObserver;
import commanddesign.EnterTrain;
import commanddesign.TrainInvoker;
import commanddesign.ViewTrain;
import commanddesign.Train;
import java.io.IOException;

public class RailwayManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int swValue;

        
        int TrainValue;
        int CoachesValue;
        int ScheduleValue;
        int PassengerValue;
        while(true){
            // Displaying menu graphics
            System.out.println("RAILWAY MANAGEMENT SYSTEM");
            System.out.println("Options:");
            System.out.println("1. Trains");
            System.out.println("2. Coaches Types");
            System.out.println("3. Schedule");
            System.out.println("4. Passanger Details");
            System.out.println("5. View Seating Details");
            System.out.println("6. Exit");
            swValue = Keyin.inInt("Select option: ");
            System.out.println("\n");
            
            switch (swValue) {
//CASE 1 IS TRAIN RECORDS USING COMMAND DESIGN PATTERN   
//In this command design pattern we are encapsulating  a request as an object,
//which lets us parameterize other objects with different requests and support undoable operations.
//We have created an interface Order.java which is acting as a command                
//will use Train class to demonstrate command pattern.                
                case 1:
                    System.out.println("Enter 1 to view Train Records");
                    System.out.println("Enter 2 to insert Train Record");
                    TrainValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
                    
                    if(TrainValue==1){
//Create a command interface.                        
                        Train train = new Train();                        
//Create a request class.                        
                        ViewTrain viewTrainOrder = new ViewTrain(train);
//Creating a command invoker class.                         
                        TrainInvoker trainInvoker = new TrainInvoker();
                      
                        trainInvoker.takeOrder(viewTrainOrder);
                        trainInvoker.placeOrders();
                    }
                    else if(TrainValue==2){
//Create a command interface.
                        Train man = new Train();
//Create a request class.                        
                        EnterTrain enterTrainOrder = new EnterTrain(man);
//Creating a command invoker class.                      
                        TrainInvoker trainInvoker = new TrainInvoker();
                      
                        trainInvoker.takeOrder(enterTrainOrder);
                        trainInvoker.placeOrders();
                        break;
                    }
                    break;

//CASE 2 IS COACHES MODULE USING OBSERVER DESIGN PATTERN 
//Observer pattern uses three actor classes. Coaches, Observer and Client                    
                case 2:
                    System.out.println("Enter 1 to view Coach Details");
                    System.out.println("Enter 2 to insert Coach Details");
                    CoachesValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
                    
                    Coaches coaches = new Coaches();
                    
                    if(CoachesValue==1){
//Using ViewCoachesObserver and concrete observer objects.
                        new ViewCoachesObserver(coaches);
//Accounts is an object having methods to attach and detach observers to a client object                        
                        coaches.setState(1);
                    }
                     else if(CoachesValue==2){
//Using ENTERCOACHESOBSERVER and concrete observer objects.                         
                        new EnterCoachesObserver(coaches);
//Accounts is an object having methods to attach and detach observers to a client object                        
                        coaches.setState(1);
                        break;
                    }
                    
                    break;
                    
//CASE 3 IS SCHEDULE USING FACTORY DESIGN PATTERN
//We will use ScheduleFactory to get a object. It will pass information (viewSchedule,enterSchedule) 
//to ScheduleFactory to get the type of object it needs.                    
                case 3:
                    System.out.println("Enter 1 to view Train Schedule");
                    System.out.println("Enter 2 to insert Train Schedule");
                    ScheduleValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
//Using the ScheduleFactory to get object of concrete class by passing an information such as type.                    
                    ScheduleFactory scheduleFactory = new ScheduleFactory();

                    if(ScheduleValue==1){
//get an object of ViewAttendance and call its viewEnterAttendance method.
                        Schedule viewSchedule = scheduleFactory.getSchedule("viewSchedule");
                        viewSchedule.viewEnterSchedule();
                    }
                    else if(ScheduleValue==2){
//get an object of EnterAttendance and call its viewEnterAttendance method.
                        Schedule enterSchedule = scheduleFactory.getSchedule("enterSchedule");
                        enterSchedule.viewEnterSchedule();
                    }
                    
                    break;
                    
//CASE 4 IS PASSENGER DETAILS USING STATE DESIGN PATTERN                   
//In State Design Pattern, we have created objects which represent various states 
//And a context object whose behavior varies as its state object changes.                    
                case 4:
                    System.out.println("Enter 1 to view Passenger Details");
                    System.out.println("Enter 2 to insert Passenger Details");
                    PassengerValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");

//Using the Context to see change in behaviour when State changes 
//Context is a class which carries a State
                    Context context = new Context();

                    if(PassengerValue==1){
//We are using Context and state objects to demonstrate change in Context 
//behavior based on type of state it is in.                        
                        ViewState viewState = new ViewState();
                        viewState.doAction(context);
                    }
                    else if(PassengerValue==2){   
                        EnterState enterState = new EnterState();
                        enterState.doAction(context);
                    }
                    break;
                    
//CASE 5 IS SEATING DETAILS USING ITERATOR DESIGN PATTERN
//We're creating an ITERATOR interface which narrates navigation method and a Container interface 
//which retruns the iterator. 
//Concrete classes implementing the Container interface will be responsible to implement Iterator interface and use it                                      
//Using the SeatingRepository to get iterator and print Types of seating class available.
                    case 5: 
                    SeatsRepository seatsRepository = new SeatsRepository();
                    for(Iterator iter = seatsRepository.getIterator(); iter.hasNext();){
                        String seat = (String)iter.next();
                        System.out.println("Class : " + seat);
                    }
                    break;                   
                    
//CASE 6 IS EXITING PROGRAM 
                case 6:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    
//CASE DEFAULT IS PRINTING OUT THE INVALID SELECTION BY THE USER
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary but its a formality
    }
   
    }
  }




// keyin methos is for input of character and numeric types only in main menu

class Keyin {

  //*******************************
  //   support methods
  //*******************************
  //Method to display the user's prompt string
  public static void printPrompt(String prompt) {
    System.out.print(prompt + " ");
    System.out.flush();
  }

  //Method to make sure no data is available in the
  //input stream
  public static void inputFlush() {
    int dummy;
    int bAvail;

    try {
      while ((System.in.available()) != 0)
        dummy = System.in.read();
    } catch (java.io.IOException e) {
      System.out.println("Input error");
    }
  }

  //********************************
  //  data input methods for
  //string, int, char, and double
  //********************************
  public static String inString(String prompt) {
    inputFlush();
    printPrompt(prompt);
    return inString();
  }

  public static String inString() {
    int aChar;
    String s = "";
    boolean finished = false;

    while (!finished) {
      try {
        aChar = System.in.read();
        if (aChar < 0 || (char) aChar == '\n')
          finished = true;
        else if ((char) aChar != '\r')
          s = s + (char) aChar; // Enter into string
      }

      catch (java.io.IOException e) {
        System.out.println("Input error");
        finished = true;
      }
    }
    return s;
  }

  public static int inInt(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Integer.valueOf(inString().trim()).intValue();
      }

      catch (NumberFormatException e) {
        System.out.println("Invalid input. Not an integer");
      }
    }
  }

  public static char inChar(String prompt) {
    int aChar = 0;

    inputFlush();
    printPrompt(prompt);

    try {
      aChar = System.in.read();
    }

    catch (java.io.IOException e) {
      System.out.println("Input error");
    }
    inputFlush();
    return (char) aChar;
  }

  public static double inDouble(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Double.valueOf(inString().trim()).doubleValue();
      }

      catch (NumberFormatException e) {
        System.out
            .println("Invalid input. Not a floating point number");
      }
    }
  }
}
        
    }
    

