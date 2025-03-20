class Solution {
    int[] root;
    int[] minEdgeCost;

    public int findLeader(int node) {
        if (root[node] != node) {
            root[node] = findLeader(root[node]); 
        }
        return root[node];
    }

    public int[] minimumCost(int nodes, int[][] connections, int[][] requests) {
        root = new int[nodes];
        minEdgeCost = new int[nodes];
        Arrays.fill(minEdgeCost, -1);

        for (int index = 0; index < nodes; index++) root[index] = index;

        for (int[] connection : connections) {
            int pointA = connection[0], pointB = connection[1], weight = connection[2];
            int rootA = findLeader(pointA);
            int rootB = findLeader(pointB);

            if (minEdgeCost[rootA] == -1) minEdgeCost[rootA] = weight;
            else minEdgeCost[rootA] &= weight;

            if (minEdgeCost[rootB] == -1) minEdgeCost[rootB] = weight;
            else minEdgeCost[rootB] &= weight;

            if (rootA != rootB) {
                root[rootA] = rootB;
                minEdgeCost[rootB] &= minEdgeCost[rootA];
            }
        }

        int[] response = new int[requests.length];
        for (int index = 0; index < requests.length; index++) {
            int startNode = requests[index][0], endNode = requests[index][1];

            if (startNode == endNode) response[index] = 0;
            else if (findLeader(startNode) != findLeader(endNode)) response[index] = -1;
            else response[index] = minEdgeCost[findLeader(startNode)];
        }

        return response;
    }
}
