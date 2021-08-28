/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null;

        weave(head);
        Node head2 = unWeave(head);
        return head2;

    }
    public void weave(Node head) {

        Node curr= head, next=head.next;

        while(curr!=null) {

            Node temp = new Node(curr.val);

            curr.next = temp;
            temp.next = next;
            
            curr = next;
            if(next!=null) next = next.next;
            
        }
        curr= head; next = curr.next;
        
        while(curr!=null && next!=null) {
            next.random = curr.random !=null ? curr.random.next : null;

            curr = next.next;
            if(curr!=null) next = curr.next;            
        }
    }
    
    public Node unWeave(Node head) {

        Node curr = head, next = head.next;
        Node head2 = curr.next;
        
        while(curr != null && next != null) {
            
            curr.next = next.next;
            curr = curr.next;
            
            next.next = next.next!=null ? next.next.next : null;
            
            next = next.next;
        }
        return head2 ; 
    }
    
}
