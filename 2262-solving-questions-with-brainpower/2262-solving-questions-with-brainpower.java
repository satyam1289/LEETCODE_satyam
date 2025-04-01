class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int p = q[i][0];
            int b = q[i][1];
            int nx = i + b + 1;

            long tk = p + (nx < n ? dp[nx] : 0);
            long sk = dp[i + 1];

            dp[i] = Math.max(tk, sk);
        }

        return dp[0];
    }
}
