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

class CountElementsInBT {
  public static void main(String[] args) {
 
      System.out.println(countElements(null));
      System.out.println(countElements(new TreeNode(1, 
                                                    new TreeNode(2, null, null), 
                                                    new TreeNode(3, null, null))));
      System.out.println(countElements(new TreeNode(2, 
                                                    new TreeNode(29, 
                                                             new TreeNode(26, null, null),
                                                             null), 
                                                    new TreeNode(4, 
                                                             null, 
                                                             new TreeNode(2, 
                                                                      new TreeNode(9,  null, null),
                                                                      null)))));
      System.out.println(countElements(new TreeNode(0, null, null)));
    
  }
  
  
  public static int countElements(TreeNode root) {
    
    if(root == null) return 0;
    
    int count = 0;
    
    
    Queue<TreeNode> parent_queue = new LinkedList<TreeNode>();
    parent_queue.add(root);
    Queue<TreeNode> child_queue = new LinkedList<TreeNode>();
    
    while(!parent_queue.isEmpty()) {
    
      TreeNode node = parent_queue.poll();
      count++;
      if(node.right!=null) child_queue.offer(node.right);
      if(node.left!=null) child_queue.offer(node.left);
      
      
      if(parent_queue.isEmpty()) {
        parent_queue  = child_queue;
        child_queue = new LinkedList<TreeNode>();
        
      }
    }
    
    
    return count;
  
  
  }
  

  
}
  
