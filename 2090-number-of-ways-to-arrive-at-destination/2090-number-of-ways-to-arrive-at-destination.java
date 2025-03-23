class Pair {
    long weight;
    int vertex;
    Pair(long _weight, int _vertex) {
        this.weight = _weight;
        this.vertex = _vertex;
    }
}

class Solution {
    public int countPaths(int nodes, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        int edgeCount = edges.length;
        for (int i = 0; i < edgeCount; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            int weight = edges[i][2];

            if (start >= nodes || end >= nodes) continue;  

            graph.get(start).add(new Pair(weight, end)); 
            graph.get(end).add(new Pair(weight, start));
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingLong(x -> x.weight));
        
        long[] minDist = new long[nodes];
        int[] pathCount = new int[nodes];
        Arrays.fill(minDist, Long.MAX_VALUE);
        Arrays.fill(pathCount, 0); 
        minDist[0] = 0;
        pathCount[0] = 1;
        minHeap.add(new Pair(0, 0));
        int modulo = (int) (1e9 + 7);

        while (!minHeap.isEmpty()) {
            long currentDist = minHeap.peek().weight;
            int currentNode = minHeap.peek().vertex;
            minHeap.remove();
            
            if (currentDist > minDist[currentNode]) continue;

            for (Pair neighbor : graph.get(currentNode)) {
                int neighborNode = neighbor.vertex;
                long edgeWeight = neighbor.weight;

                if (currentDist + edgeWeight < minDist[neighborNode]) {
                    minDist[neighborNode] = currentDist + edgeWeight;
                    minHeap.add(new Pair(currentDist + edgeWeight, neighborNode));
                    pathCount[neighborNode] = pathCount[currentNode];
                } else if (currentDist + edgeWeight == minDist[neighborNode]) {
                    pathCount[neighborNode] = (pathCount[currentNode] + pathCount[neighborNode]) % modulo;
                }
            }
        }
        return pathCount[nodes - 1] % modulo;
    }
}