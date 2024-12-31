class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        long totalSum = 0, leftSum = 0;
        
        for (int num : nums) {
            totalSum += num;
        }
        
        for (int i = 0; i < n; i++) {
            totalSum -= nums[i];
            if (leftSum == totalSum) {
                return i;
            }
            leftSum += nums[i];
        }
        
        return -1;
    }
}
