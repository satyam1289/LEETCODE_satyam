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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        traverse(root, output);
        return output;
    }

    private void traverse(TreeNode current, List<Integer> output) {
        if (current == null) {
            return;
        }
        traverse(current.left, output);
        traverse(current.right, output);
        output.add(current.val);
    }
}
