class Solution {
    public int longestNiceSubarray(int[] values) {
        int maxLen = 0;
        int bitwiseOr = 0;
        int start = 0;

        for (int end = 0; end < values.length; end++) {
            
            while ((bitwiseOr & values[end]) != 0) {
                bitwiseOr ^= values[start];
                start++;
            }

            bitwiseOr |= values[end];
            
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
