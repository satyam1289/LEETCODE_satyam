class Solution {
    public int countDays(int d, int[][] m) {
        int n = m.length;

        if (n == 1) {
            return d - (m[0][1] - m[0][0] + 1);
        }

        Arrays.sort(m, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < n; i++) {
            if (m[i - 1][1] >= m[i][0]) {
                m[i][0] = m[i - 1][0];
                m[i][1] = Math.max(m[i - 1][1], m[i][1]);
            } else {
                d -= m[i - 1][1] - m[i - 1][0] + 1;
            }
        }

        d -= m[n - 1][1] - m[n - 1][0] + 1;

        return d;
    }
}