class Solution {
    public long countValid(int pos, int isTight, String number, String suffix, int maxDigit, int len, long[][] dp) {
        if (pos == len) return 1;

        if (dp[pos][isTight] != -1) return dp[pos][isTight];

        long minDigit = 0, total = 0;
        int limit = isTight == 1 ? Math.min(maxDigit, number.charAt(pos) - '0') : maxDigit;

        int suffixStart = len - suffix.length();
        if (suffixStart <= pos) {
            minDigit = suffix.charAt(pos - suffixStart) - '0';
            limit = Math.min(limit, suffix.charAt(pos - suffixStart) - '0');
        }

        for (int digit = (int) minDigit; digit <= limit; digit++) {
            int newTight = (isTight == 1 && digit == number.charAt(pos) - '0') ? 1 : 0;
            total += countValid(pos + 1, newTight, number, suffix, maxDigit, len, dp);
        }

        dp[pos][isTight] = total;
        return total;
    }

    public long numberOfPowerfulInt(long start, long end, int maxDigit, String suffix) {
        String endStr = Long.toString(end);
        String startStr = Long.toString(start - 1);

        int endLen = endStr.length();
        int startLen = startStr.length();

        long countEnd = 0, countStart = 0;

        if (suffix.length() <= endLen) {
            long[][] dp = new long[endLen][2];
            for (long[] row : dp) Arrays.fill(row, -1);
            countEnd = countValid(0, 1, endStr, suffix, maxDigit, endLen, dp);
        }

        if (suffix.length() <= startLen) {
            long[][] dp = new long[startLen][2];
            for (long[] row : dp) Arrays.fill(row, -1);
            countStart = countValid(0, 1, startStr, suffix, maxDigit, startLen, dp);
        }

        return countEnd - countStart;
    }
}
