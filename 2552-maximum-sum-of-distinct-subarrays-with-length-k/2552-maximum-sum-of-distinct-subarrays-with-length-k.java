class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long currSum = 0, maxSum = 0;
        int[] freq = new int[100001];
        int dupCnt = 0;

        for (int i = 0; i < k - 1; i++) {
            currSum += nums[i];
            if (freq[nums[i]] >= 1) dupCnt++;
            freq[nums[i]]++;
        }

        int first = 0;
        for (int i = k - 1; i < n; i++) {
            currSum += nums[i] - first;
            if (freq[nums[i]] >= 1) dupCnt++;
            freq[nums[i]]++;

            if (dupCnt == 0) maxSum = Math.max(maxSum, currSum);

            first = nums[i - (k - 1)];
            if (freq[first] > 1) dupCnt--;
            freq[first]--;
        }

        return maxSum;
    }
}
