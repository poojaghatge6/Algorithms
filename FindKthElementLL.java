
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
    
    ListNode LL1 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4, null))));
    ListNode LL2 = new ListNode(1, new ListNode(3,new ListNode(5, null)));
     ListNode LL3 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4, new ListNode(5,null)))));
    System.out.println(findKthLL(LL1, 1));
    System.out.println(findKthLL(LL2, 2));
      
    System.out.println(findKthLL(new ListNode(1, null), 1));
    System.out.println(findKthLL(LL3, 5));
  
 } 
  

  public static int findKthLL(ListNode root, int k) {
    
    ListNode curr=root;
    int count =0;
    
    while(curr!=null) {
    
    
     count++;
      if(count == k) return curr.val;
      curr= curr.next;
      
    }
    
    return -1;
   

  }
}



