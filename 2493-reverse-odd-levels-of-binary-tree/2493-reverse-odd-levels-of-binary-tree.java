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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        List<List<TreeNode>> levelNodesList = new ArrayList<>();

        // Traverse the tree level by level
        while (!nodeQueue.isEmpty()) {
            int currentLevelSize = nodeQueue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();
                currentLevelNodes.add(currentNode);
                if (currentNode.left != null) {
                    nodeQueue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right);
                }
            }
            levelNodesList.add(currentLevelNodes);
        }

        
        for (int levelIndex = 0; levelIndex < levelNodesList.size(); levelIndex++) {
            if (levelIndex % 2 == 1) {
                List<TreeNode> currentLevelNodes = levelNodesList.get(levelIndex);
                int leftIndex = 0;
                int rightIndex = currentLevelNodes.size() - 1;

                while (leftIndex < rightIndex) {
                    
                    int temp = currentLevelNodes.get(leftIndex).val;
                    currentLevelNodes.get(leftIndex).val = currentLevelNodes.get(rightIndex).val;
                    currentLevelNodes.get(rightIndex).val = temp;

                    leftIndex++;
                    rightIndex--;
                }
            }
        }

        return root;
    }
}
