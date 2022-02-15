//package com.codility;
/*
// you can also use imports, for example:
// import java.util.*;

read4k 4095

start = 1274

end = 4096

buffer =  [275 - 4096]

Sring read(int nbytes)

  
  read(275)  ---> (0  to 274)
  
  read(1000)   --> (275 to 1274)
  
  read(8999)  --> (12t - 1275 + 8999)


100k


offset = curr amount in the buffer

 0-274

 0, nBytes

 [275 - 4096]



*/

class Reader{

   StringBuilder buffer;
   int start;
   int end;

   Reader() {
       this.buffer = new StringBuilder();
       this.start = 0;
       this.end = 0;
   }

   String read(int nBytes) {
       String res;        
    //    if(end - start + 1 > nBytes) { // 10 - 0 789
    //        res = buffer.toString().substring(start, nBytes);
    //        start = start + nBytes;
    //    } else {

    //        while( end - start + 1 < nBytes) {
    //            String newData = read4k();
    //            buffer.append(newData);
    //            end = end + 4096;
    //        }
    //        res = buffer.toString().substring(start, nBytes);
    //        start = start + nBytes;
    //    }


        while( end - start + 1 < nBytes) {
            String newData = read4k();
            buffer.append(newData);
            end = end + 4096;
        }
    //    []

        res = buffer.toString().substring(start, nBytes);
        buffer = 
        //start = start + nBytes;

       return res;
   }


    
    String read1(int nBytes) {
       String res;        



        while( end + 1 < nBytes) { // 0
            String newData = read4k();
            buffer.append(newData);
            end = end + 4096;
        }

        res = buffer.toString().substring(0, nBytes);


        //de queue : empty from beging, add new data to the end

        buffer = new StringBuilder( buffer.toString().substring(nBytes, end + 1)); //[abcde 0-4] (0, 3)
  

       return res;
   }


}


public class Solution {

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
    }
}
