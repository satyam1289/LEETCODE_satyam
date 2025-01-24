class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        byte[] state = new byte[graph.length];
        boolean[] safe = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        
        for (int node = 0; node < graph.length; node++) {
            if (state[node] == 0) {
                explore(node, state, graph, safe);
            }
        }
        
        for (int node = 0; node < safe.length; node++) {
            if (safe[node]) {
                result.add(node);
            }
        }
        
        return result;
    }

    public boolean explore(int node, byte[] state, int[][] graph, boolean[] safe) {
        if (state[node] == 2) return true;
        if (state[node] == 1 || state[node] == -1) return false;

        state[node] = -1;
        for (int neighbor : graph[node]) {
            if (!explore(neighbor, state, graph, safe)) {
                state[node] = 1;
                return false;
            }
        }

        state[node] = 2;
        safe[node] = true;
        return true;
    }
}
