class Solution {
    public long minSum(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int c1 = 0, c2 = 0;
        long s1 = 0, s2 = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) c1++;
            s1 += a[i];
        }

        for (int i = 0; i < m; i++) {
            if (b[i] == 0) c2++;
            s2 += b[i];
        }

        s1 += c1;
        s2 += c2;

        if (c1 == 0 && s1 < s2) return -1;
        if (c2 == 0 && s2 < s1) return -1;

        return Math.max(s1, s2);
    }
}
