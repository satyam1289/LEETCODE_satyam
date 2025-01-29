class Solution {
    public int[] findRedundantConnection(int[][] edges) { // Fixed method name
        DisjointSet ds = new DisjointSet(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (ds.getRoot(u) == ds.getRoot(v)) {
                return new int[]{u, v};
            } else {
                ds.mergeBySize(u, v);
            }
        }
        return new int[2];
    }
}

class DisjointSet {
    int[] root;
    int[] rank;

    DisjointSet(int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int getRoot(int node) {
        if (node == root[node]) {
            return node;
        }
        return root[node] = getRoot(root[node]); // Path Compression
    }

    public void mergeBySize(int node1, int node2) {
        int root1 = getRoot(node1);
        int root2 = getRoot(node2);
        if (root1 == root2) return;

        if (rank[root1] > rank[root2]) {
            root[root2] = root1;
            rank[root1] += rank[root2];
        } else {
            root[root1] = root2;
            rank[root2] += rank[root1];
        }
    }
}

class Edge {
    int from;
    int to;
    int cost;

    Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
