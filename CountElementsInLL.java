
class ListNode {
  
  int val;
  ListNode next;
  ListNode( int val, ListNode next) {
    this.next = next;
    this.val=val;
  }
}

class Solution {
  public static void main(String[] args) {
    ListNode LL1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
    System.out.println(count(null)) ; 
    System.out.println(count(LL1)) ; 
    System.out.println(count(new ListNode(0 ,null))) ; 
 } 
  public static int count(ListNode root) {
    
    if(root == null) return 0;
    else {
      return 1+ count(root.next);
    }
  }
}



