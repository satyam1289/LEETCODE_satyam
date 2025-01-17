class Solution {
    public boolean doesValidArrayExist(int[] nums) {
        int xorResult = 0;
        for (int value : nums) {
            xorResult ^= value;
        }
        return xorResult == 0;
    }
}
