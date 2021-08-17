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
    else {
    
        return 1 + countElements(root.right) + countElements(root.left);
    }
  
  
  }
  

  
}
