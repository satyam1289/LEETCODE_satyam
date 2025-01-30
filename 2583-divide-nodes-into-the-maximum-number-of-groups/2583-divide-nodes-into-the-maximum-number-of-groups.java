class Solution {
    public int magnificentSets(int nodes, int[][] links) { // Fixed method name
        
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int vertex = 1; vertex <= nodes; vertex++) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
        
        for (int[] link : links) {
            int start = link[0];
            int end = link[1];
            adjacencyList.get(start).add(end);
            adjacencyList.get(end).add(start);
        }
        
        Map<Integer, List<Integer>> clusters = new HashMap<>();
        Set<Integer> visitedNodes = new HashSet<>();
        int clusterId = 1;
        for (int vertex = 1; vertex <= nodes; vertex++) {
            if (visitedNodes.contains(vertex)) continue;
            visitedNodes.add(vertex);
            clusters.put(clusterId, new ArrayList<>());
            exploreCluster(clusterId++, vertex, adjacencyList, clusters, visitedNodes);    
        }
        
        int[] maxTraversalInCluster = new int[clusterId];
        int totalResult = 0;
        for (int cluster = 1; cluster < clusterId; cluster++) {
            for (int clusterVertex : clusters.get(cluster)) {
                
                int clusterResult = performBFS(clusterVertex, adjacencyList);
                if (clusterResult == -1) return -1;
                maxTraversalInCluster[cluster] = Math.max(maxTraversalInCluster[cluster], clusterResult);
            }
            totalResult += maxTraversalInCluster[cluster];
        }

        return totalResult;
    }

    private void exploreCluster(int clusterId, int vertex, Map<Integer, List<Integer>> adjacencyList, 
                                Map<Integer, List<Integer>> clusters, Set<Integer> visitedNodes) {
        clusters.get(clusterId).add(vertex);
        for (int neighbor : adjacencyList.get(vertex)) {
            if (visitedNodes.contains(neighbor)) continue;
            visitedNodes.add(neighbor);
            exploreCluster(clusterId, neighbor, adjacencyList, clusters, visitedNodes);
        }
    }

    private int performBFS(int vertex, Map<Integer, List<Integer>> adjacencyList) {
        int depth = 0;
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> currentLevel = new HashSet<>();
        
        queue.offer(vertex);
        visitedNodes.add(vertex);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Set<Integer> nextLevel = new HashSet<>();

            for (int i = 0; i < levelSize; i++) {
                int currentVertex = queue.poll();

                for (int neighbor : adjacencyList.get(currentVertex)) {
                    if (currentLevel.contains(neighbor)) return -1;
                    if (visitedNodes.contains(neighbor)) continue;
                    nextLevel.add(neighbor);
                    visitedNodes.add(neighbor);
                    queue.offer(neighbor);
                }
            }

            currentLevel = nextLevel;
            depth++;
        }
        
        return depth;
    }
}
