class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
        
        int low = minValue, high = maxValue;
        int result = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValid(nums, mid, k)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    public boolean isValid(int[] nums, int capability, int k) {
        int count = 0;
        int i = 0;
        
        while (i < nums.length) {
            if (nums[i] <= capability) {
                count++;
                i += 2;
            } else {
                i++;
            }
            
            if (count == k) {
                return true;
            }
        }
        
        return false;
    }
}
