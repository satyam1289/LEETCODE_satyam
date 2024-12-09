class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        boolean[] result = new boolean[q];

        int[] alternatingCountPrefix = new int[n];
        int alternatingCount = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] % 2 != nums[i] % 2) {
                alternatingCount++;
            }
            alternatingCountPrefix[i] = alternatingCount;
        }

        for (int i = 0; i < q; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = true;
            if (alternatingCountPrefix[right] - alternatingCountPrefix[left] != right - left) {
                result[i] = false;
            }
        }

        return result;
    }
}
