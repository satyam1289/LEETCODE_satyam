


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
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calculateMax(root);
        return maxSum;
    }
    private int calculateMax(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, calculateMax(node.left));
        int right = Math.max(0, calculateMax(node.right));

        int current = node.val + left + right;

        maxSum = Math.max(current, maxSum);
        return node.val + Math.max(left, right);
    }
}
