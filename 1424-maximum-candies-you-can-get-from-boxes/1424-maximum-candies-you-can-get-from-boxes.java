class Solution {
  public int maxCandies(int[] st, int[] can, int[][] ky, int[][] cont, int[] init) {
    int res = 0;
    Queue<Integer> q = new ArrayDeque<>();
    boolean[] seen = new boolean[st.length];

    addBoxes(init, st, q, seen);

    while (!q.isEmpty()) {
      int cur = q.poll();
      res += can[cur];

      for (int k : ky[cur]) {
        if (st[k] == 0 && seen[k])
          q.offer(k);
        st[k] = 1;
      }

      addBoxes(cont[cur], st, q, seen);
    }

    return res;
  }

  private void addBoxes(int[] bx, int[] st, Queue<Integer> q, boolean[] seen) {
    for (int b : bx)
      if (st[b] == 1)
        q.offer(b);
      else
        seen[b] = true;
  }
}
