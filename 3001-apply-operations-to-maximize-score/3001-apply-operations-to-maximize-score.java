class Solution {
    public static final int MOD = (int)1e9 + 7;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size(), mx = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nums.get(i);
        for (int num : arr) mx = Math.max(mx, num);
        
        int[] primeScores = getPScore(arr, mx);
        
        int[] mulCnt = new int[mx + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;
        right[n - 1] = n;
        
        for (int i = 1; i < n; i++) {
            int l = i - 1;
            while (l >= 0 && (primeScores[arr[i]] > primeScores[arr[l]])) l = left[l];
            left[i] = l;

            int r = n - i;
            while (r < n && (primeScores[arr[n - i - 1]] >= primeScores[arr[r]])) r = right[r];
            right[n - i - 1] = r;
        }

        for (int i = 0; i < n; i++) {
            int sz = right[i] - left[i] - 1, lSz = i - left[i] - 1, rSz = right[i] - i - 1;
            long subArr = ((sz * (sz + 1L)) / 2 - (lSz * (lSz + 1L)) / 2 - (rSz * (rSz + 1L)) / 2);
            mulCnt[arr[i]] = (int) Math.min(k, mulCnt[arr[i]] + subArr);
        }

        long res = 1;
        for (int m = mx; m > 0; m--) {
            if (mulCnt[m] == 0) continue;
            if (mulCnt[m] >= k) {
                res = (res * modExp(m, k)) % MOD;
                break;
            } else {
                res = (res * modExp(m, mulCnt[m])) % MOD;
                k -= mulCnt[m];
            }
        }

        return (int) res;
    }

    private static int[] getPScore(int[] nums, int mx) {
        int[] spf = sieve(mx);
        int[] pScore = new int[mx + 1];
        for (int num : nums) {
            if (pScore[num] != 0) continue;
            int x = num;
            while (x > 1) {
                pScore[num]++;
                int p = spf[x];
                while (spf[x] == p) x /= p;
            }
        }
        return pScore;
    }

    private static int[] sieve(int lim) {
        int[] spf = new int[lim + 1];
        boolean stop = false;
        for (int i = 3; i <= lim; i += 2) {
            spf[i - 1] = 2;
            if (spf[i] != 0) continue;
            spf[i] = i;

            if (stop) continue;
            stop = i * i > lim;

            for (int j = i * i; j <= lim; j += 2 * i) {
                if (spf[j] == 0) spf[j] = i;
            }
        }
        if (lim % 2 == 0) spf[lim] = 2;
        return spf;
    }

    private static long modExp(int b, int e) {
        long mul = b, res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * mul) % MOD;
            mul = (mul * mul) % MOD;
            e >>= 1;
        }
        return res;
    }
}
