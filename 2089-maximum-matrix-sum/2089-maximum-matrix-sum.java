class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int a = 0;
        long b = 0;
        long c = Long.MAX_VALUE;
        
        for (int[] d : matrix) {
            for (int i : d) {
                b += Math.abs(i);
                if (i < 0) a++;
                c = Math.min(c, Math.abs(i));
            }
        }
        
        if (a % 2 == 1) b -= 2 * c;
        return b;
    }
}
