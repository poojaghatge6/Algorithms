/*
 * Click `Run` to execute the snippet below!
 */
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


    
      ListNode LL1 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
      ListNode LL2 = new ListNode(-3, new ListNode(-2, new ListNode(-1, null)));
      display(insert(LL1, 2));
      display(insert(LL2, -4));
      display(insert(LL2, 0));
      display(insert(null, 1));



  } 
  
  
  public static void display(ListNode head) {
    
    ListNode curr=head;
    while(curr!= null) {
      
      System.out.print(curr.val+" ");
      curr = curr.next;
    }
    System.out.println();
    
  }
  
  public static ListNode insert(ListNode head, int target) {
    
    if(head == null) return new ListNode(target, null);
    
    ListNode curr = head, prev=null;
    
    while(curr!=null) {
      
      if(curr.val > target) {
        ListNode temp = new ListNode(target, null);
        if(prev!=null) prev.next = temp;
        else {
          temp.next = curr;
          return temp;
        }
        temp.next = curr;
        
        return head;
        
      }
      prev = curr;
      curr = curr.next;
      
      
    }
    
    ListNode temp = new ListNode(target, null);
    prev.next = temp;
  
    return head;
  }
  

  
}
