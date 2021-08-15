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

class ReverseLinkedList {
  public static void main(String[] args) {
    
    ListNode LL1 = new ListNode(13, new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(7, new ListNode(10, null))))));
    ListNode ans = null;
    ListNode L2 = new ListNode(1, null);
    ans = reverse(L2);
    display(ans);
    
    
    ListNode L3 = new ListNode(1, new ListNode(2, null));
    ans = reverse(L3);
    display(ans);
    
    ans = reverse(LL1);
    display(ans);
  }
  
  
  public static void display(ListNode root) {
    
    ListNode curr = root;
  
    while(curr!= null) {
        System.out.print(curr.val+" ");
       curr = curr.next;
    }
    
    System.out.println();
  }
  
  public static ListNode reverse(ListNode root) {
    
    if(root == null || root.next == null) return root;
    
    ListNode a = root, b = root.next, c = b.next ;
    
    while(b!= null) {
    
      b.next = a;
      
      if(a == root) {
        a.next = null;
      }
      
      a = b;
      b = c;
      
      if(c != null) c = c.next;
      else return a;
    
    }
    
    return a;
  }
}
     
