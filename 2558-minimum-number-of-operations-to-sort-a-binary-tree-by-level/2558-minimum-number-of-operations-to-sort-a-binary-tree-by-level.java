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

    private int findIndex(int[] array, int element) {
        for (int x = 0; x < array.length; x++)
            if (array[x] == element)
                return x;

        return -1;
    }

    private void exchange(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int calculateSwaps(int[] array, int length) {
        int swapCount = 0;
        int[] sortedArray = Arrays.copyOfRange(array, 0, length);
        Arrays.sort(sortedArray);

        for (int y = 0; y < length; y++) {
            if (array[y] != sortedArray[y]) {
                swapCount++;
                exchange(array, y, findIndex(array, sortedArray[y]));
            }
        }
        return swapCount;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int operations = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.peek();
            int queueSize = nodeQueue.size();

            for (int z = 0; z < queueSize; z++) {
                current = nodeQueue.remove();
                if (current.left != null)
                    nodeQueue.add(current.left);

                if (current.right != null)
                    nodeQueue.add(current.right);
            }

            int[] nodeValues = new int[nodeQueue.size()];
            int index = 0;
            for (TreeNode node : nodeQueue)
                nodeValues[index++] = node.val;

            operations += calculateSwaps(nodeValues, index);
        }
        return operations;
    }
}
