class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
        int edges = 0;
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            if (left[i] != -1) {
                parent[left[i]]++;
                if (parent[left[i]] > 1) return false;
                edges++;
            }

            if (right[i] != -1) {
                parent[right[i]]++;
                if (parent[right[i]] > 1) return false;
                edges++;
            }
        }

        if (edges != n - 1) return false;

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == 0) {
                if (root == -1) root = i;
                else return false;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        int visited = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            if (left[node] != -1) queue.add(left[node]);
            if (right[node] != -1) queue.add(right[node]);
        }

        return visited == n;
    }
}
