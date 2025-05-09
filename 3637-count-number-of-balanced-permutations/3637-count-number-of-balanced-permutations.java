class Solution {
    int n, s;
    int M = (int) 1e9 + 7;
    long tp = 0;

    int p(long a, long b) {
        if (b == 0) return 1;
        long h = p(a, b / 2), r = (h * h) % M;
        if (b % 2 == 1) r = (r * a) % M;
        return (int) r;
    }

    int f(int d, int e, int c, int[] f, long[] inv, int[][][] t) {
        if (d == 10) return (c == s / 2 && e == (n + 1) / 2) ? (int) tp : 0;
        if (t[d][e][c] != -1) return t[d][e][c];

        long w = 0;
        for (int i = 0; i <= Math.min(f[d], (n + 1) / 2 - e); i++) {
            int o = f[d] - i;
            long div = (inv[i] * inv[o]) % M;
            long val = f(d + 1, e + i, c + d * i, f, inv, t);
            w = (w + val * div % M) % M;
        }
        return t[d][e][c] = (int) w;
    }

    public int countBalancedPermutations(String num) {
        n = num.length();
        s = 0;
        int[] f = new int[10];
        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            s += d;
            f[d]++;
        }
        if (s % 2 != 0) return 0;

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i % M;

        long[] inv = new long[n + 1];
        for (int i = 0; i <= n; i++) inv[i] = p(fact[i], M - 2);

        tp = fact[(n + 1) / 2] * fact[n / 2] % M;

        int[][][] t = new int[10][(n + 1) / 2 + 1][s + 1];
        for (int[][] a : t)
            for (int[] b : a)
                java.util.Arrays.fill(b, -1);

        return f(0, 0, 0, f, inv, t);
    }
}
