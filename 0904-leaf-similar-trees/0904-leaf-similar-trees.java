import java.util.*;

public class Solution {
    public boolean leafSimilar(TreeNode tree1, TreeNode tree2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        cL(tree1, leaves1);
        cL(tree2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void cL(TreeNode node, List<Integer> leaves) {
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        
        cL(node.left, leaves);
    cL(node.right, leaves);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
