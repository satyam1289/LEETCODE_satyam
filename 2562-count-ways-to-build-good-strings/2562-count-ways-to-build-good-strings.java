class Solution {
    int MOD = (int) 1e9 + 7;

    public int countGoodStrings(int min, int max, int zero, int one) {
        long[] dp = new long[max + 1];
        Arrays.fill(dp, -1);
        long res = 0;

        for (int i = min; i <= max; i++) {
            res = (res + calc(dp, zero, one, i)) % MOD;
        }

        return (int) res;
    }

    private long calc(long[] dp, int zero, int one, int idx) {
        if (idx < 0) return 0;
        if (idx == 0) return 1;
        if (dp[idx] != -1) return dp[idx];
        return dp[idx] = (calc(dp, zero, one, idx - one) + calc(dp, zero, one, idx - zero)) % MOD;
    }
}
