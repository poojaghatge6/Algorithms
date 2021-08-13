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
                                  new ListNode(2, 
                                               new ListNode(3, 
                                                            new ListNode(5, 
                                                                         new ListNode(6, 
                                                                                      new ListNode(7, 
                                                                                                   new ListNode(10, null)))))));
      System.out.println(search(null, 1));
      System.out.println(search(LL1, 2));
      System.out.println(search(LL1, 4));
      System.out.println(search(LL1, -1));
      System.out.println(search(LL1, 10));
      System.out.println(search(LL1, 11));



  } 
  
  
  public static void display(ListNode head) {
    
    ListNode curr=head;
    while(curr!= null) {
      
      System.out.print(curr.val+" ");
      curr = curr.next;
    }
    System.out.println();
    
  }
  
  public static boolean search(ListNode head, int target) {
    
    ListNode curr = head;
    
    while(curr!=null) {
      
      if(curr.val == target) {
        return true;
      } else if(curr.val > target) {
        return false;
      }
      curr = curr.next;
      
      
    }
  
  
    return false;
  }
  

  
}
