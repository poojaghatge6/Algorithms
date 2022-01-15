import java.io.*;
import java.util.*;

/*
 *Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 
 
 
 list : [ 06:50, 04:45, 12:45 ] 
 
 
 
 list; [ 12:45 , 06:50, 04:45 ]

 
      [
 
 
 
       
       
  empty list => 0
 
         2 hours, 5 mins => 120+ 5 =>  125 mins
         
 
 nlogn
 
 diff(t1, t2) -> mins
 
 
 
 
 
      
 */

class Solution {
  public static void main(String[] args) {
    
    
    String[] timep = new String[] {  "06:50", "04:45", "12:45" };
    
    String[] timep1 = new String[] {  };
 
    String[] timep3 = new String[] { "12:00" };

    String[] timep2 = new String[] { "00:05","18:00", "23:55" };
    
    String[] timep4 = new String[] { "05:00","18:00" };

    
    System.out.println(minimumDiff(timep2)); 
    System.out.println(minimumDiff(timep)); 
    System.out.println(minimumDiff(timep1)); 
    System.out.println(minimumDiff(timep3)); 
    System.out.println(minimumDiff(timep4)); 
    
  }
  
  
  public static int minimumDiff(String[] timePoints) { // 00:00 - 23:59
    
    // 0...1439
    // use an array o size .. .... .....
    
    
    int min = Integer.MAX_VALUE;
    
    
    for (int i = 0; i < timePoints.length; i++)  {
      
      for(int j = i+1; j < timePoints.length; j ++) {
      
        int  t1 = getMinutes(timePoints[i]);
        int t2 = getMinutes(timePoints[j]);
        
        int minsT =  Math.abs(t1 - t2);
      
        minsT = minsT > 720 ? 1440 - minsT : minsT;
          
        min = Math.min(min, minsT);
      }
      
    }
    
    if(min == Integer.MAX_VALUE) {
      return 0;
    }
    
    return min;
  
  }
  
  
  public static int getMinutes(String timePoint) { // 12:00 am -> 00:00
    
    String[] hm = timePoint.split(":");
    
    int hours = Integer.parseInt(hm[0]);
    int mins = Integer.parseInt(hm[1]);
    
    return hours*60 + mins; 
  }
  
  
  
  
}
