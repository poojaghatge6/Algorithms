class ListNode {
  
  int val;
  ListNode next;
  ListNode( int val, ListNode next) {
  
    this.next = next;
    this.val=val;
  }
}
class SumTwoLL{
  public static void main(String[] args) {


    
    ListNode LL1 = new ListNode(1, 
                                new ListNode(3, 
                                             new ListNode(5, null)));
    ListNode LL2 = new ListNode(-1, 
                                new ListNode(3, 
                                             new ListNode(-10, null)));
    display(sumTwoLL(LL1, LL2)); 
    display(sumTwoLL(new ListNode(0, null), new ListNode(0, null)));


  } 
  
  
  public static void display(ListNode head) {
    
    ListNode curr=head;
    while(curr!= null) {
      
      System.out.print(curr.val+" ");
      curr = curr.next;
    }
    System.out.println();
    
  }
  
  public static ListNode sumTwoLL(ListNode head1, ListNode head2) {
    
    ListNode curr1 = head1, curr2=head2, ans=null, prev=null;
    
    while(curr1!=null) {
      
      ListNode node = new ListNode(curr1.val+ curr2.val, null);
      if(prev!=null) prev.next = node;
      
      if(ans == null) ans = node;
      
      curr1 = curr1.next;
      curr2 = curr2.next;
      
      prev = node;
      
      
    }
  
  
    return ans;
  }
  

  
}
