class Solution {
    public boolean checkIfExist(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> freq = new HashMap();

        for (int i = 0; i < len; i++) {
            if (freq.containsKey(nums[i] * 2)) {
                return true;
            } else if (nums[i] % 2 == 0 && freq.containsKey(nums[i] / 2)) {
                return true;
            }
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        return false;
    }
}
