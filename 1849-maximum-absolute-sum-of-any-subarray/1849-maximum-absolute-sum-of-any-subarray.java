class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, mSum = 0, maxSum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) maxSum = sum;
            if (sum < mSum) mSum = sum;
        }
        return Math.abs(maxSum - mSum);
    }
}