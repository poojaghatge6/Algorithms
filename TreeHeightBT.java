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
class class TreeNode {
  int val;
  TreeNode right;
  TreeNode left;

  TreeNode(int val, TreeNode left, TreeNode right) {

    this.val = val;
    this.left = left;
    this.right = right;

  }
}
class TreeHeightBT {
  public static void main(String[] args) {

    System.out.println(findTreeHeight(null)) ; 
    System.out.println(findTreeHeight(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)))) ; 
    System.out.println(findTreeHeight(new TreeNode(2, 
                                                   new TreeNode(29, 
                                                                new TreeNode(26, null, null),
                                                                null),
                                                   new TreeNode(4, 
                                                                null, 
                                                                new TreeNode(2, 
                                                                             new TreeNode(9, null, null),
                                                                            null))))) ; 
    System.out.println(findTreeHeight(new TreeNode(0 , null, null))) ; 


  } 



   public static int findTreeHeight(TreeNode root) {
     
     if(root == null) return 0;
     else {
      return Math.max(findTreeHeight(root.right), findTreeHeight(root.left))+1;
     
     }
     
   }
  
  
}{
  public static void main(String[] args) {

    System.out.println(findTreeHeight(null)) ; 
    System.out.println(findTreeHeight(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)))) ; 
    System.out.println(findTreeHeight(new TreeNode(2, 
                                                   new TreeNode(29, 
                                                                new TreeNode(26, null, null),
                                                                null),
                                                   new TreeNode(4, 
                                                                null, 
                                                                new TreeNode(2, 
                                                                             new TreeNode(9, null, null),
                                                                            null))))) ; 
    System.out.println(findTreeHeight(new TreeNode(0 , null, null))) ; 


  } 



   public static int findTreeHeight(TreeNode root) {
     
     if(root == null) return 0;
     else {
      return Math.max(findTreeHeight(root.right), findTreeHeight(root.left))+1;
     
     }
     
   }
  
  
}
