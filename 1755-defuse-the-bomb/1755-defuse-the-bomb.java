class Solution {

    public int[] decrypt(int[] a, int b) {
        int[] c = new int[a.length];
        if (b == 0) {
            return c;
        }
        for (int d = 0; d < c.length; d++) {
            if (b > 0) {
                for (int e = d + 1; e < d + b + 1; e++) {
                    c[d] += a[e % a.length];
                }
            } else {
                for (int e = d - Math.abs(b); e < d; e++) {
                    c[d] += a[(e + a.length) % a.length];
                }
            }
        }
        return c;
    }
}
