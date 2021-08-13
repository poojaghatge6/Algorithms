class ListNode {
  
  int val;
  ListNode next;
  ListNode( int val, ListNode next) {
  
    this.next = next;
    this.val=val;
  }
}
class Solution{
  public static void main(String[] args) {


    
      ListNode LL1 = new ListNode(1, new ListNode(3, new ListNode(5, null)));
      ListNode LL2 = new ListNode(1, new ListNode(3, new ListNode(-13, new ListNode(-3, new ListNode(1, null)))));
      ListNode LL3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
      System.out.println(findMiddle(null));
      System.out.println(findMiddle(LL1));
      System.out.println(findMiddle(LL2));
      System.out.println(findMiddle(LL3));
      System.out.println(findMiddle(new ListNode(1, null)));


  } 
  
  
  public static void display(ListNode head) {
    
    ListNode curr=head;
    while(curr!= null) {
      
      System.out.print(curr.val+" ");
      curr = curr.next;
    }
    System.out.println();
    
  }
  
  public static int findMiddle(ListNode head) {
    
    if(head == null) return -1;
    
    if(head.next == null) return head.val;
    
    ListNode slow=null, fast=head;
    int count =1;
    
    while(fast!=null) {
      fast = fast.next;
      
      if(fast!=null) {
        count = count+ 1;
        fast = fast.next;
        if(fast!=null) count = count+1;
        if(slow!=null) slow = slow.next;
        else slow = head;
      }
    }
    
    if(count%2 == 1) {
      slow = slow.next;
    }
 
    return slow.val;
    
    
  }
}
