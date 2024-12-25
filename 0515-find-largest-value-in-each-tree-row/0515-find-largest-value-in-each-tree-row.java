class Solution {
    public List<Integer> largestValues(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int count = queue.size();
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < count; i++) {
                TreeNode current = queue.poll();
                maxVal = Math.max(maxVal, current.val);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            result.add(maxVal);
        }

        return result;
    }
}
