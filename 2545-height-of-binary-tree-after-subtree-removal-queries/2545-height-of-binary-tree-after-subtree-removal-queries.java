import java.util.*;

class Solution {
    Map<TreeNode, Integer> depth = new HashMap<>();
    Map<TreeNode, Integer> height = new HashMap<>();
    Map<Integer, TreeNode> nodeMap = new HashMap<>();
    int[] maxHeightAtDepth = new int[100001];
    int[] secondMaxHeightAtDepth = new int[100001];
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs(root, 0);
        Arrays.fill(maxHeightAtDepth, -1);
        Arrays.fill(secondMaxHeightAtDepth, -1);
        
        for (TreeNode node : depth.keySet()) {
            int d = depth.get(node);
            int h = height.get(node);
            if (h > maxHeightAtDepth[d]) {
                secondMaxHeightAtDepth[d] = maxHeightAtDepth[d];
                maxHeightAtDepth[d] = h;
            } else if (h > secondMaxHeightAtDepth[d]) {
                secondMaxHeightAtDepth[d] = h;
            }
        }
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            TreeNode queryNode = nodeMap.get(queries[i]);
            if (queryNode == null) {
                result[i] = 0;
                continue;
            }
            int d = depth.get(queryNode);
            int h = height.get(queryNode);
            if (h == maxHeightAtDepth[d]) {
                result[i] = d + secondMaxHeightAtDepth[d];
            } else {
                result[i] = d + maxHeightAtDepth[d];
            }
        }
        
        return result;
    }
    
    private int dfs(TreeNode node, int d) {
        if (node == null) return -1;
        depth.put(node, d);
        nodeMap.put(node.val, node);
        int leftHeight = dfs(node.left, d + 1);
        int rightHeight = dfs(node.right, d + 1);
        int h = Math.max(leftHeight, rightHeight) + 1;
        height.put(node, h);
        return h;
    }
}
