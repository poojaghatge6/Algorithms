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


    
      ListNode LL1 = new ListNode(1, 
                         new ListNode(1, 
                                      new ListNode(1, 
                                                   new ListNode(1, 
                                                                null))));
     ListNode LL2 = new ListNode(1, 
                         new ListNode(2, 
                                      new ListNode(3, 
                                                   new ListNode(4, 
                                                                null))));
    ListNode LL3 = new ListNode(2, 
                                      new ListNode(4, 
                                                   new ListNode(6, 
                                                                null)));
      // ListNode LL2 = remove(null, 1);
      System.out.println(countOddElems(LL1));
      System.out.println(countOddElems(LL2));
      System.out.println(countOddElems(null));
      System.out.println(countOddElems(new ListNode(1, null)));
      System.out.println(countOddElems(LL3));


  } 
  
  
  public static void display(ListNode head) {
    
    ListNode curr=head;
    while(curr!= null) {
      
      System.out.print(curr.val+" ");
      curr = curr.next;
    }
    System.out.println();
    
  }
  
  public static int countOddElems(ListNode head) {
    
    if(head == null) return 0;
    else if( head.val%2 == 1) return 1+ countOddElems(head.next);
    else return countOddElems(head.next);
    
    
  }
}
