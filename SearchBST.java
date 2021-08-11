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
class SearchBST {
  public static void main(String[] args) {

    TreeNode tree = new TreeNode(8, 
                                 new TreeNode(3, 
                                              new TreeNode(1, null, null), 
                                              new TreeNode(6, null, null)),
                                 new TreeNode(10, 
                                              null, 
                                              new TreeNode(14, 
                                                             new TreeNode(13, null, null),
                                                             null)));
    System.out.println(searchBST(null, 1)) ; 
    System.out.println(searchBST(tree, 1)) ; 
    System.out.println(searchBST(tree, 14)) ; 
    System.out.println(searchBST(tree, 2)) ;
    System.out.println(searchBST(tree, 13)) ; 
    System.out.println(searchBST(new TreeNode(0, null, null), 0)) ; 


  } 



   public static boolean searchBST(TreeNode root, int ele) {
     
    TreeNode next = root;
     
    while(next != null) {
      if(next.val == ele) return true;
      else if(next.val < ele) next = next.right;
      else if(next.val > ele) next = next.left;
      
    }
    return false;
   }

  
  
