class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rms) {
        int[] vis = new int[rms.size()];
        vis[0] = 1;
        dfs(rms, vis, 0);
        return allVisited(vis);
    }

    public void dfs(List<List<Integer>> rms, int[] vis, int rm) {
        List<Integer> keys = rms.get(rm);
        for (int i = 0; i < keys.size(); i++) {
            int k = keys.get(i);
            if (vis[k] == 0) {
                vis[k] = 1;
                dfs(rms, vis, k);
            }
        }
    }

    boolean allVisited(int[] vis) {
        for (int v : vis) {
            if (v == 0) return false;
        }
        return true;
    }
}
