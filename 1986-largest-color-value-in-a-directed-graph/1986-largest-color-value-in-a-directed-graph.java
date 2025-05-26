class Solution {
  public int largestPathValue(String s, int[][] e) {
    int n = s.length();
    int res = 0, done = 0;
    List<Integer>[] g = new List[n];
    int[] deg = new int[n];
    int[][] cnt = new int[n][26];

    for (int i = 0; i < n; ++i)
      g[i] = new ArrayList<>();

    for (int[] ed : e) {
      int u = ed[0], v = ed[1];
      g[u].add(v);
      ++deg[v];
    }

    Queue<Integer> q = IntStream.range(0, n)
      .filter(i -> deg[i] == 0)
      .boxed()
      .collect(Collectors.toCollection(ArrayDeque::new));

    while (!q.isEmpty()) {
      int u = q.poll();
      ++done;
      res = Math.max(res, ++cnt[u][s.charAt(u) - 'a']);
      for (int v : g[u]) {
        for (int i = 0; i < 26; ++i)
          cnt[v][i] = Math.max(cnt[v][i], cnt[u][i]);
        if (--deg[v] == 0)
          q.offer(v);
      }
    }

    return done == n ? res : -1;
  }
}
