class Solution {
    public int minDominoRotations(int[] a, int[] b) {
        int n = a.length;
        int res = check(a[0], a, b, n);
        if (res != -1) return res;
        return check(b[0], a, b, n);
    }

    private int check(int val, int[] a, int[] b, int n) {
        int rotA = 0, rotB = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != val && b[i] != val) return -1;
            if (a[i] != val) rotA++;
            if (b[i] != val) rotB++;
        }
        return Math.min(rotA, rotB);
    }
}
