package factorydesign;
//Creating a ScheduleFactory to generate object of concrete class based on given information.
public class ScheduleFactory {
   //use getSchedule method to get object of manager 
   public Schedule getSchedule(String getSchedule){
       if(getSchedule == null){
           return null;
       }
       if(getSchedule.equalsIgnoreCase("viewSchedule")){
           return new ViewSchedule();
       }
       else if(getSchedule.equalsIgnoreCase("enterSchedule")){
           return new EnterSchedule();
       }
       return null;
   }    
}
