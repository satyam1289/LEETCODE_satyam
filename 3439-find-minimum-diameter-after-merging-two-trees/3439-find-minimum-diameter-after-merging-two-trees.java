class Solution {
    public int minimumDiameterAfterMerge(int[][] tree1Edges, int[][] tree2Edges) {
        int nodesTree1 = tree1Edges.length + 1;
        ArrayList<ArrayList<Integer>> tree1 = new ArrayList<>();
        for (int i = 0; i < nodesTree1; i++) {
            tree1.add(new ArrayList<>());
        }
        for (int[] edge : tree1Edges) {
            int a = edge[0];
            int b = edge[1];
            tree1.get(a).add(b);
            tree1.get(b).add(a);
        }

        int nodesTree2 = tree2Edges.length + 1;
        ArrayList<ArrayList<Integer>> tree2 = new ArrayList<>();
        for (int i = 0; i < nodesTree2; i++) {
            tree2.add(new ArrayList<>());
        }
        for (int[] edge : tree2Edges) {
            int a = edge[0];
            int b = edge[1];
            tree2.get(a).add(b);
            tree2.get(b).add(a);
        }

        int diameter1 = calcDiameter(tree1, nodesTree1);
        int diameter2 = calcDiameter(tree2, nodesTree2);
        int mergedDiameter = (int) Math.ceil(diameter1 / 2.0) + (int) Math.ceil(diameter2 / 2.0) + 1;

        return Math.max(Math.max(diameter1, diameter2), mergedDiameter);
    }

    int calcDiameter(ArrayList<ArrayList<Integer>> tree, int nodes) {
        boolean[] visited = new boolean[nodes];
        int[] result = new int[2];
        dfs(0, 0, tree, visited, result);

        int farthestNode = result[0];
        visited = new boolean[nodes];
        result = new int[2];
        dfs(farthestNode, 0, tree, visited, result);

        return result[1];
    }

    void dfs(int node, int dist, ArrayList<ArrayList<Integer>> tree, boolean[] visited, int[] result) {
        visited[node] = true;

        if (dist > result[1]) {
            result[0] = node;
            result[1] = dist;
        }

        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, dist + 1, tree, visited, result);
            }
        }
    }
}
