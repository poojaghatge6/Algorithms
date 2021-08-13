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
class Solution{
  public static void main(String[] args) {


    System.out.println(findTreeMax(null));
    System.out.println(findTreeMax(new TreeNode(1, 
                                                new TreeNode(2, null, null),
                                                new TreeNode(3, null, null)))); 
    System.out.println(findTreeMax(new TreeNode(2, 
                                                new TreeNode(29, 
                                                             new TreeNode(26, null, null),
                                                            null), 
                                                new TreeNode(4, 
                                                             null, 
                                                             new TreeNode(2, 
                                                                          new TreeNode(9, null, null),
                                                                         null))))); 
    System.out.println(findTreeMax(new TreeNode(1, null, null))); 


  } 



   public static Integer findTreeMax(TreeNode root) {
     
     if(root == null) return null;
     
     Integer right_max = findTreeMax(root.right);
     Integer left_max = findTreeMax(root.left);
     
     if(right_max == null && left_max == null) return root.val;
     else if(right_max == null) return Math.max(root.val, left_max);
     else if(left_max == null) return Math.max(root.val, right_max);
     else 
       return Math.max(root.val, Math.max(right_max, left_max));
     
   }
  
  
}
