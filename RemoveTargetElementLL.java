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


    
      ListNode LL1 = new ListNode(4, 
                         new ListNode(2, 
                                      new ListNode(1, 
                                                   new ListNode(1, 
                                                                new ListNode(3, 
                                                                             new ListNode(2, 
                                                                                          new ListNode(2, null)))))));
      ListNode LL2 = remove(null, 1);
      display(LL2);
      LL1 = remove(LL1, 1);
      display(LL1);
      LL1 = remove(LL1, 2);
      display(LL1);
      remove(LL1, 3);
      display(LL1);
      LL1 = remove(LL1, 4);
      display(LL1);



  } 
  
  
  public static void display(ListNode head) {
    
    ListNode curr=head;
    while(curr!= null) {
      
      System.out.print(curr.val+" ");
      curr = curr.next;
    }
    System.out.println();
    
  }
  
  public static ListNode remove(ListNode head, int target) {
    
    if(head == null) return null;
    
    ListNode curr = head, prev=null;
    
    while(curr!=null) {
      
      if(curr.val == target) {
        if(prev!= null) {
          prev.next = curr.next;
        }
        else {
          head = head.next;
          prev = null;
        }
      } else {
        prev = curr;
      }
      
      curr = curr.next;
    }
    ret
      urn head;
  }
}
