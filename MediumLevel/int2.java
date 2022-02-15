package com.codility;

// you can also use imports, for example:
// import java.util.*;


//small (n, n p), medium, large sizes - vehicles(park, unpark) - 1 parking lot, size is given by customer,

// park - > size, timestamp, availaibility -> ticket/ null


park()

unpark()

 //
 
 //small[] = [0, 0].  O(n)

//{ spot name:  {end time}}


unpark ( Ticket )
//[1 2 3 4]



queueAvailable[ 3, 4, 2] // O(1)


//{1, 2} 

//qOccupied [1, 2] ///

// leave pay the price

// rate = 15$/hr

class Ticket {
 int size ;
 int spot;
 Ticket (int size, int spot) {
    this.size = size;
    this.spot = spot;
 }
}

class ParkingSystem {

    int[] small, medium, large;

    ParkingSystem(int small, int med, int l) {
        this.small = new int[small];
        this.medium = new int[med];
        this.large = new int[l];
    }

//0 as
    public Ticket park(int size) {
        
        if( size == 0) {
            return getTicket( small, size);
        } else if(size == 1) {
            return getTicket( medium , size);
        } else if(size == 2) {
            return getTicket( large, size);
        }

        return null;


    }

    public Ticket getTicket(int[] arr, int size) {

        for( int i =0; i< arr.length; i++) {
            if(arr[i] == 0) {
                arr[i] = 1;
                return new Ticket(size, i);
            }
        }
        return null;
    }

    public boolean unpark(Ticket ticket) {

         if(ticket.size == 0) {
             return unOccupy(small, ticket);
         } else if (ticket.size == 1) {
            return unOccupy(medium, ticket);
         } else {
            return unOccupy(large, ticket);
         }
    }

    public boolean unOccupy(int[] arr, Ticket ticket) {
        arr[ticket.spot] = 0;
        return true;
    }

}






public class Solution {

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
    }
}
