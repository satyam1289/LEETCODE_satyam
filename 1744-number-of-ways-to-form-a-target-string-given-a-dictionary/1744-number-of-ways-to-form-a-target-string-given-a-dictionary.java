class Solution {
    private int MOD = 1000000007;

    public int numWays(String[] arr, String tgt) {
        if (tgt.length() > arr[0].length()) {
            return 0;
        }

        long[][] memo = new long[tgt.length()][arr[0].length()];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }

        return (int) calculate(arr, tgt, 0, 0, memo) % MOD;
    }

    private long calculate(String[] arr, String tgt, int idxTgt, int idxArr, long[][] memo) {
        if (idxTgt == tgt.length()) {
            return 1;
        }
        if (idxArr == arr[0].length()) {
            return 0;
        }

        int remTgt = tgt.length() - idxTgt;
        int remArr = arr[0].length() - idxArr;

        if (remTgt > remArr) {
            return 0;
        }

        if (memo[idxTgt][idxArr] != -1) {
            return memo[idxTgt][idxArr];
        }

        long count = calculate(arr, tgt, idxTgt, idxArr + 1, memo);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(idxArr) == tgt.charAt(idxTgt)) {
                count += calculate(arr, tgt, idxTgt + 1, idxArr + 1, memo);
            }
        }

        return memo[idxTgt][idxArr] = count % MOD;
    }
}
