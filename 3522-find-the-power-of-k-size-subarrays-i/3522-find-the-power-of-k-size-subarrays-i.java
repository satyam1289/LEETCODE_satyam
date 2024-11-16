class Solution {
    public int[] resultsArray(int[] a, int b) {
        if (b == 1) {
            return a;
        }
        int[] c = new int[a.length + 1 - b];
        Arrays.fill(c, -1);
        boolean d = true;
        int e = 0;
        int f = 1;
        while (e < a.length - 1) {
            if (a[e + 1] - a[e] == 1) {
                f++;
            } else {
                f = 1;
            }
            if (f >= b) {
                c[e - b + 2] = a[e + 1];
            }
            e++;
        }
        return c;
    }
}
