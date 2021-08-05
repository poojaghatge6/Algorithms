
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
      TreeNode tree = new TreeNode(8, new TreeNode(3, 
                                          new TreeNode(1, null, null),
                                          new TreeNode(6, null, null)), 
                                 new TreeNode(10, 
                                          null, 
                                          new TreeNode(14, 
                                                   new TreeNode(13, null, null),
                                                   null)));
      System.out.println(search(null, 1)) ;
      System.out.println(search(tree, 1));
      System.out.println(search(tree, 14));
      System.out.println(search(tree, 2)) ;
      System.out.println(search(tree, 13));
      System.out.println(search(new TreeNode(0, null,null), 0));
    
  }
  
  
  public static boolean search(TreeNode root, int element) {
    
    if(root == null) return false;
    
    
    Queue<TreeNode> parent_queue = new LinkedList<TreeNode>();
    parent_queue.add(root);
    Queue<TreeNode> child_queue = new LinkedList<TreeNode>();
    
    while(!parent_queue.isEmpty()) {
    
      TreeNode node = parent_queue.poll();
      if(node.val == element) return true;
      else {
        if(node.right!=null) child_queue.offer(node.right);
        if(node.left!=null) child_queue.offer(node.left);
      
      }
      
      if(parent_queue.isEmpty()) {
        parent_queue  = child_queue;
        child_queue = new LinkedList<TreeNode>();
        
      }
    }
    return false;
  
  }
  
}
  
