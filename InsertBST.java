import java.util.*;


class TreeNode {
  int val;
  TreeNode right;
  TreeNode left;


  TreeNode(int val, TreeNode left, TreeNode right) {

    this.val = val;
    this.left = left;
    this.right = right;

  }
}

class Solution {
  public static void main(String[] args) {
    
    TreeNode tree = new TreeNode(6, 
                                 new TreeNode(3, 
                                              new TreeNode(2, null, null), 
                                              new TreeNode(4, null, null)), 
                                 new TreeNode(8, null, null));
    display(insertBST(tree, 7));
    display(insertBST(tree, 5));
    display(insertBST(tree, 1));
    display(insertBST(null, 1));
  }
  
  
  public static void display(TreeNode root) {
    
    if(root == null) return;
    
    
    Queue<TreeNode> parent_queue = new LinkedList<TreeNode>();
    parent_queue.add(root);
    Queue<TreeNode> child_queue = new LinkedList<TreeNode>();
    
    while(!parent_queue.isEmpty()) {
    
      TreeNode node = parent_queue.poll();
     
      System.out.print(node.val+ " ");
      
      if(node.left!=null) child_queue.offer(node.left);
      if(node.right!=null) child_queue.offer(node.right);
      
    
      
      if(parent_queue.isEmpty()) {
        parent_queue  = child_queue;
        child_queue = new LinkedList<TreeNode>();
        
      }
    }
      System.out.println();

  }
  
  public static TreeNode insertBST(TreeNode root, int target) {
    
    if(root == null) return new TreeNode(target, null, null);

    TreeNode curr=root, prev=null;
    
    while(curr!=null) {
      prev = curr;
      if(curr.val < target) 
         curr = curr.right;
      else
        curr = curr.left;
    }
    
    if(target > prev.val) {
      prev.right = new TreeNode(target, null, null);
    } else {
       prev.left = new TreeNode(target, null, null);
    }
   
    return root; 
  }
}
