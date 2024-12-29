class Solution {
    public int longestOnes(int[] arr, int k) {
        int maxLen = 0, left = 0, zeroCount = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeroCount++;
                while (zeroCount > k) {
                    if (arr[left++] == 0) zeroCount--;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
