class Solution {
    public int shortestSubarray(int[] a, int b) {
        int n = a.length;
        long[] c = new long[n + 1];

        for (int i = 0; i < n; i++) {
            c[i + 1] = c[i] + a[i];
        }

        int[] d = new int[n + 1];
        int start = 0, end = 0;
        int minLen = n + 1;

        for (int i = 0; i < c.length; i++) {
            while (end > start && c[i] >= c[d[start]] + b) {
                minLen = Math.min(minLen, i - d[start++]);
            }

            while (end > start && c[i] <= c[d[end - 1]]) {
                end--;
            }

            d[end++] = i;
        }

        return minLen <= n ? minLen : -1;
    }
}
