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
    
    
    TreeNode tree1 = new TreeNode(3, 
                                  new TreeNode(29, 
                                               new TreeNode(2, null, null),
                                              null),
                                  new TreeNode(4, 
                                               null, 
                                               new TreeNode(2, 
                                                            new TreeNode(9, null, null),
                                                           null)));
    System.out.println(DFSTree(null, 1)) ;
    System.out.println(DFSTree(tree1, 9)) ;
    System.out.println(DFSTree(tree1, 1)) ;
    System.out.println(DFSTree(tree1, 2)) ;
    System.out.println(DFSTree(new TreeNode(1, null, null), 2));
  }
  

  
  public static boolean DFSTree(TreeNode root, int target) {
    
    if(root == null) return false;
    
    if(root.val == target) return true;
    else {
      return DFSTree(root.left, target) || DFSTree(root.right, target);
    }
    
  
  }
    
    

}
