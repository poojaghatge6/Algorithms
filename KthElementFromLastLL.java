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


    
    ListNode LL1 = new ListNode(13, new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(7, new ListNode(10, null))))));
    System.out.println(kthFromLast(LL1, 0)) ;
    System.out.println(kthFromLast(LL1, 2)) ;
    System.out.println(kthFromLast(LL1, 5)) ;
    System.out.println(kthFromLast(LL1, 6)) ;



  }
  
   public static int kthFromLast(ListNode head, int k) {
    
    if(head == null) return -1;
    int count=k;
    ListNode fast=head, slow=null;
     
    while(fast!=null) {
      
      if(count ==0) {
        slow = head;
      } else if(slow!=null) slow = slow.next;
      
      count--;
      fast = fast.next;
      
    }
     if(slow!=null) return slow.val;
     else return -1;
    
  }
  

}
