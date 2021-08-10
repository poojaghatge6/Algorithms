import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

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



class SumOfElementsBT {
 
  
  public static void main(String[] args) {
    
    
    System.out.println(sumBT(null)) ; 
    System.out.println(sumBT(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)))) ; 
    System.out.println(sumBT(new TreeNode(1, null, null))) ; 
 
    
 } 
  public static void display(int [] arr) {
    for(int i =0; i< arr.length ; i++) {
      System.out.print(arr[i]+ " ");
    }
    
     System.out.println();
  }
  public static int sumBT(TreeNode root) {
    
    if(root == null) return 0;
    
    int sum=0;
    
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    
    while(!q.isEmpty()) {
      
      TreeNode curr = q.poll();
      sum = sum + curr.val;
      if(curr.left != null) q.offer(curr.left); 
      if(curr.right != null) q.offer(curr.right); 
    
    }
    
    return sum;
    
    
    
  } 
}
