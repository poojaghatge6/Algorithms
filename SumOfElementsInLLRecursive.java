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


    
    
    ListNode LL1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
    System.out.println(sum(null));
    System.out.println(sum(LL1));
    System.out.println(sum(new ListNode(1, null)));



  }
  
   public static int sum(ListNode head) {
    
    if(head == null) return 0;
    else {
      return head.val + sum(head.next);
    }
    
  }
  

}
