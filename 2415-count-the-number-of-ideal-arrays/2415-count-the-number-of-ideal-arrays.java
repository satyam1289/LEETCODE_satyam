class Solution {
    int MOD = 1000000007;
    int[][] divisorCount = new int[10001][14];
    int[][] combinations = new int[10001][14];

    public Solution() {
        
        for (int n = 0; n < 10001; n++) {
            for (int r = 0; r <= Math.min(n, 13); r++) {
                combinations[n][r] = (r == 0 || r == n) ? 1 : 
                    (combinations[n - 1][r - 1] + combinations[n - 1][r]) % MOD;
            }
        }

       
        for (int divisor = 1; divisor < 10001; divisor++) {
            divisorCount[divisor][0]++;
            for (int multiple = divisor * 2; multiple < 10001; multiple += divisor) {
                for (int len = 0; len < 13; len++) {
                    if (divisorCount[divisor][len] > 0)
                        divisorCount[multiple][len + 1] += divisorCount[divisor][len];
                }
            }
        }
    }

    public int idealArrays(int length, int maxValue) {
        int result = 0;
        for (int val = 1; val <= maxValue; val++) {
            for (int numBars = 0; numBars < Math.min(14, length); numBars++) {
                result = (int)((result + 1L * divisorCount[val][numBars] * combinations[length - 1][numBars]) % MOD);
            }
        }
        return result;
    }
}
