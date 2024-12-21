class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] count = new int[1];
        dfs(adj, values, 0, -1, count, k);
        return count[0];
    }

    static int dfs(List<List<Integer>> adj, int[] values, int node, int parent, int[] count, int k) {
        int sum = values[node];
        for (int neigh : adj.get(node)) {
            if (neigh != parent) {
                sum += dfs(adj, values, neigh, node, count, k);
            }
        }
        if (sum % k == 0) count[0]++;
        return sum % k;
    }
}
