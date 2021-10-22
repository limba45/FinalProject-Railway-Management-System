package railwaymanagementsystem;
//Creating a concrete class which implements the Container interface. 
//This class has inner class SeatingIterator that implements the Iterator interface.

import iteratordesign.Iterator;
import iteratordesign.Container;

class SeatsRepository implements Container {
    public String seating[] = {"ECONOMY" , "BUSINESS" ,"FIRSTCLASS" };
    
    @Override
   public Iterator getIterator() {
      return new SeatingIterator();
   }

   private class SeatingIterator implements Iterator {

      int index;

      public boolean hasNext() {
      
         if(index < seating.length){
            return true;
         }
         return false;
      }

      public Object next() {
      
         if(this.hasNext()){
            return seating[index++];
         }
         return null;
      }		
   }
}
