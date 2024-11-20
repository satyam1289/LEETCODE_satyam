import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int vtx = 0; vtx < n; vtx++) {
            if (color[vtx] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(vtx);
                color[vtx] = 0;

                while (!q.isEmpty()) {
                    int curr = q.poll();

                    for (int nbr : graph[curr]) {
                        if (color[nbr] == -1) {
                            color[nbr] = 1 - color[curr];
                            q.add(nbr);
                        } else if (color[nbr] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
