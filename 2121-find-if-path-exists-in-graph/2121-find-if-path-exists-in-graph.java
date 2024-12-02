import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        stack.push(source);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current == destination) {
                return true;
            }
            if (visited[current]) {
                continue;
            }
            visited[current] = true;
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }
}
