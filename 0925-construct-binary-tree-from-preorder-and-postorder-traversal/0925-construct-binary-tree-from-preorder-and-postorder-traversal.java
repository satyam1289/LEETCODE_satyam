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
    int index = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int[] postMap = new int[post.length + 1];
        for (int i = 0; i < post.length; i++)
            postMap[post[i]] = i;
        return build(pre, postMap, 0, pre.length - 1);
    }
    public TreeNode build(int[] pre, int[] postMap, int low, int high) {
        if (index >= pre.length)
            return null;    
        int postIdx = postMap[pre[index]];
        if (postIdx < low || postIdx > high)
            return null;
        TreeNode node = new TreeNode(pre[index++]);
        node.left = build(pre, postMap, low, postIdx - 1);
        node.right = build(pre, postMap, low, postIdx - 1);
        return node;
    }   
}
