/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
Prompt: 
Today, you will be giving the Flatten Linked List problem.
In this problem each linked list node has 3 properties:
value: Int
next: Node?
down: Node?  
down is another linked list. We want to flatten this linked list such that all nodes only have nexts and no downs.
Function Signature: func flatten(node: Node)

prev    curr   next
          1 -> 6     
           2    3 -> 7
            5   
            
            1 
             2
              5
           head      tail
 
 
 
 flatten(head) {
  
   
  
  }



  
  [head, tail] helperFlattner( head1) {
  
      //base case
      if(head1.down == null) {
        return [head1, head1]
      }
      
      prev, next
      
      while( cur! null) {
      
        
      
        if(curr.down!= null) [head, tail] = helperFlattner(curr.down)
        
        curr.next = head;
        
        tail.next = next
        
        prev = curr
        curr = next
        

      }
      
      return [head1 prev]
  }
  
  
  
In this example:
1.next == 6, 1.down == 2, 2.down == 5
Output:
1 -> 2 -> 5 -> 6
Always resolve down before next.
 */

class ListNode {
  int val;
  ListNode next;
  ListNode down;
  
  ListNode(int val, ListNode next, ListNode down) {
    this.val = val;
    this.next = next;
    this.down = down;
  }

}

class Solution {
  public static void main(String[] args) {
    
    
    ListNode l1 = new ListNode( 1, 
                               new ListNode(6, null,
                                            new ListNode(3, new ListNode(7, null, null), null)), 
                               new ListNode(2, null, 
                                            new ListNode(5, null, null))
                                                                            
                              );
    
    display(flatten(l1));
    
  }
  
  public static ListNode flatten(ListNode head) {
    
    
    ListNode[] list = helperFlattner(head);
    
    return list[0];
    
  }
  
  
    public static void display(ListNode root) {
    
    ListNode curr = root;
  
    while(curr!= null) {
        System.out.print(curr.val+" ");
       curr = curr.next;
    }
    
    System.out.println();
  }



  
  public static ListNode[] helperFlattner( ListNode head1) {
  

      if(head1.down == null  && head1.next == null ) {
        return new ListNode[]{head1, head1};
      }
      
      ListNode curr = head1, prev = null, next = curr.next;
      
      while( curr != null) {
      
        if( curr.down != null) {
          
          ListNode[] list = helperFlattner(curr.down);
          
          System.out.println(list[1].val);
          
          list[1].next = next;
          
           if( next!= null) {
             System.out.println(next.val);
           }
          
          curr.next = list[0];

          prev = list[1];
          
          curr.down = null;

          curr = next;
        
        } else {
          prev = curr;
          curr = curr.next;
         
        } 
        
       if(next != null) {
          next = next.next;
        }

      }
      
      return new ListNode[]{head1, prev};
  }
  
  
}
