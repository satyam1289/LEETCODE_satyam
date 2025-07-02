class Solution {
    public int possibleStringCount(String word, int k) {
        int n = word.length();
        
        if (n < k) {
            return 0;
        }

        final int MOD = 1_000_000_007;
        List<Integer> list = new ArrayList<>();
        long ways = 1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count++;
            if (i == n - 1 || word.charAt(i) != word.charAt(i + 1)) {
                if (count > 1) {
                    if (k > 0) {
                        list.add(count - 1);
                    }
                    ways = ways * count % MOD;
                }
                k--;
                count = 0;
            }
        }
        
        if (k <= 0) {
            return (int) ways;
        }

        int m = list.size();
        int[][] dp = new int[m + 1][k];
        Arrays.fill(dp[0], 1); 

        int[] prefix = new int[k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                prefix[j + 1] = (prefix[j] + dp[i][j]) % MOD;
            }
            int c = list.get(i);
            for (int j = 0; j < k; j++) {
                dp[i + 1][j] = (prefix[j + 1] - prefix[Math.max(j - c, 0)] + MOD) % MOD;
            }
        }

        return (int) ((ways - dp[m][k - 1] + MOD) % MOD);
    }
}