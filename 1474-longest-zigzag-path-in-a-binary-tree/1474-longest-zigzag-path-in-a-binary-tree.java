class Solution {
    int maxLen;
    Map<TreeNode, int[]> memo;
    
    public int longestZigZag(TreeNode root) {
        memo = new HashMap<>();
        dfs(root);
        return maxLen;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            memo.put(node, new int[]{0, 0});
            return;
        }

        dfs(node.left);
        dfs(node.right);

        int left = 0, right = 0;

        if (memo.get(node.left) != null)
            left = 1 + memo.get(node.left)[1]; 
        
        if (memo.get(node.right) != null)
            right = 1 + memo.get(node.right)[0]; 

        memo.put(node, new int[]{left, right});
        maxLen = Math.max(maxLen, Math.max(left, right));
    }
}
