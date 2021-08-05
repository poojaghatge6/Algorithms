
import java.io.*;
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

class ValidateBST {

  public static boolean validateBST(TreeNode root) {

    if(root == null) return true;

    return validateBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);


  }


  public static boolean validateBinarySearchTree(TreeNode root, int min, int max) {

    if(root == null) return true;

    if(root.val >= max || root.val <= min) return false;


    return  validateBinarySearchTree(root.right, root.val, max) 
      && validateBinarySearchTree(root.left, min, root.val );


  } 


  public static void main(String[] args) {


    TreeNode tree1 = new TreeNode(2, 
                                    new TreeNode(1, null, null),
                                    new TreeNode(3, null, null));
    TreeNode tree2 = new TreeNode(1, 
                                  new TreeNode(2, null, null), 
                                  new TreeNode(3, null, null));
    TreeNode tree3 = new TreeNode(8, 
                         new TreeNode(3, 
                                      new TreeNode(1, null, null), 
                                      new TreeNode(6, null, null)), 
                         new TreeNode(10, 
                                      null, 
                                      new TreeNode(14, 
                                                   new TreeNode(13, null, null),
                                                   null)));

    System.out.println(validateBST(tree1));
    System.out.println(validateBST(tree2));
    System.out.println(validateBST(tree3));

  }
}
