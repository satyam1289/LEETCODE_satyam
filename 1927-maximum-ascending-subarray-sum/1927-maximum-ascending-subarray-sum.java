class Solution {
    public int maxAscendingSum(int[] arr) {
        int sum = arr[0];
        int maxSum = sum;

        for (int idx = 1; idx < arr.length; idx++) {
            if (arr[idx] > arr[idx - 1]) {
                sum += arr[idx];
            } else {
                sum = arr[idx];
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
