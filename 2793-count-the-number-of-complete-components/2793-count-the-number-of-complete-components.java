import java.util.*;

class Solution {
    public int countCompleteComponents(int totalNodes, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int index = 0; index < totalNodes; index++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        boolean[] visitedNodes = new boolean[totalNodes];
        int completeCount = 0;
        for (int index = 0; index < totalNodes; index++) {
            if (!visitedNodes[index]) {
                List<Integer> group = new ArrayList<>();
                if (performBFS(index, graph, visitedNodes, group) && checkComplete(group, graph)) {
                    completeCount++;
                }
            }
        }

        return completeCount;
    }

    public boolean performBFS(int startNode, List<List<Integer>> graph, boolean[] visitedNodes, List<Integer> group) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visitedNodes[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            group.add(currentNode);

            for (int neighbor : graph.get(currentNode)) {
                if (!visitedNodes[neighbor]) {
                    visitedNodes[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return true;
    }

    private boolean checkComplete(List<Integer> group, List<List<Integer>> graph) {
        int size = group.size();
        for (int node : group) {
            if (graph.get(node).size() != size - 1) {
                return false;
            }
        }
        return true;
    }
}
