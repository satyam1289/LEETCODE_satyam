class Solution {
    public int waysToSplitArray(int[] arr) {
        long[] prefixSum = new long[arr.length];
        prefixSum[0] = arr[0];

        for (int j = 1; j < arr.length; j++) {
            prefixSum[j] = prefixSum[j - 1] + arr[j];
        }

        int splits = 0;

        for (int j = 0; j < arr.length - 1; j++) {
            long left = prefixSum[j];
            long right = prefixSum[prefixSum.length - 1] - left;
            if (left >= right) {
                splits++;
            }
        }
        return splits;
    }
}
