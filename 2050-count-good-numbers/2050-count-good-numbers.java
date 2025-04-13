class Solution {
    static final int MOD = 1_000_000_007;

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) != 0) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        long res = modPow(5, evenCount) * modPow(4, oddCount) % MOD;
        return (int) res;
    }
}
