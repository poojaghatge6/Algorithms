import java.io.*;
import java.util.*;


class ListNode {
  
  int val;
  ListNode next;
  ListNode( int val, ListNode next) {
  
    this.next = next;
    this.val=val;
  }
}

class MaxElementInLL {
  public static void main(String[] args) {
    
  ListNode LL1 = new ListNode(1, new  ListNode(4, new ListNode(5, new ListNode(1, null))));
    
  ListNode LL2 = new ListNode(7, new ListNode(1, new ListNode(5, new ListNode(1, null))));
  ListNode LL3 = new ListNode(-1, new ListNode(-3, new ListNode(-5, new ListNode(0, new ListNode(-11, null)))));
  System.out.print(findMax(LL1).val + " ");
  System.out.print(findMax(LL2).val+ " ") ;
  System.out.print(findMax(LL3).val+ " ");
  System.out.print(findMax(new ListNode(1, null)).val+ " ");

  }
  
  
  
  public static ListNode findMax(ListNode root) {
    
    if(root == null || root.next == null) return root;
    
    ListNode curr = root;
    int max = Integer.MIN_VALUE;
    ListNode maxNode = curr;
    
    while(curr!= null) {
    
      if(curr.val > max) {
        max = curr.val;
        maxNode = curr;
      }
      curr = curr.next;
    
    }
    
    return maxNode;
  }
}
