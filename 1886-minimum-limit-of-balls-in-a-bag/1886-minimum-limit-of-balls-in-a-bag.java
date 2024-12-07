class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int left = 1, right = maxNum, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int operations = 0;

            for (int num : nums) {
                operations += (num - 1) / mid;
            }

            if (operations <= maxOperations) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
