/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  int max_sum = Integer.MIN_VALUE;

  public int max_gain(TreeNode node) {
      
      if(node == null) return 0;
      int max_right = Math.max(max_gain(node.right), 0);
      int max_left = Math.max(max_gain(node.left), 0);
      
      int curr_sum = max_right + max_left + node.val;
      max_sum = Math.max(max_sum, curr_sum);
      
      return node.val + Math.max(max_right, max_left);
      
  }

  public int maxPathSum(TreeNode root) {
    max_gain(root);
    return max_sum;
  }
}
