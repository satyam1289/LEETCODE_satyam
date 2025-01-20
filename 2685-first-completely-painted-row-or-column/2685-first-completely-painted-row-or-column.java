class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> mp = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;

        int nn[] = new int[n];
        int mm[] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mp.put(mat[i][j], new int[] { i, j });
            }
        }
        int tem = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] value = mp.get(arr[i]);
            int f = value[0];
            int l = value[1];
            nn[f]++;
            mm[l]++;
            if (nn[f] >= m) {
                tem = i;
                break;
            }
            if (mm[l] >=n) {
                tem = i;
                break;
            }
        }
        return tem;
    }
}