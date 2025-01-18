class Solution {
    private int bfs(List<List<int[]>> graph) {
        int size = graph.size();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerFirst(new int[] { 0, 0 });
        int[] distances = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int node = current[0], cost = current[1];

            for (int[] edge : graph.get(node)) {
                int neighbor = edge[0], edgeCost = edge[1];
                if (cost + edgeCost < distances[neighbor]) {
                    distances[neighbor] = cost + edgeCost;
                    if (edgeCost == 0) {
                        queue.offerFirst(new int[] { neighbor, distances[neighbor] });
                    } else {
                        queue.offerLast(new int[] { neighbor, distances[neighbor] });
                    }
                }
            }
        }
        return distances[size - 1];
    }

    public int minCost(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < rows * cols; i++) {
            graph.add(new ArrayList<>());
        }

        int nodeCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == rows - 1 && j == cols - 1)
                    continue;

                if (j + 1 < cols) {
                    if (grid[i][j] == 1) {
                        graph.get(nodeCount).add(new int[] { nodeCount + 1, 0 });
                    } else {
                        graph.get(nodeCount).add(new int[] { nodeCount + 1, 1 });
                    }
                }
                if (j - 1 >= 0) {
                    if (grid[i][j] == 2) {
                        graph.get(nodeCount).add(new int[] { nodeCount - 1, 0 });
                    } else {
                        graph.get(nodeCount).add(new int[] { nodeCount - 1, 1 });
                    }
                }
                if (i + 1 < rows) {
                    if (grid[i][j] == 3) {
                        graph.get(nodeCount).add(new int[] { nodeCount + cols, 0 });
                    } else {
                        graph.get(nodeCount).add(new int[] { nodeCount + cols, 1 });
                    }
                }
                if (i - 1 >= 0) {
                    if (grid[i][j] == 4) {
                        graph.get(nodeCount).add(new int[] { nodeCount - cols, 0 });
                    } else {
                        graph.get(nodeCount).add(new int[] { nodeCount - cols, 1 });
                    }
                }
                nodeCount++;
            }
        }

        return bfs(graph);
    }
}
