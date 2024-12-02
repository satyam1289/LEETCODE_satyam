class Solution {
    public boolean canIWin(int maxNum, int target) {
        if ((maxNum * (maxNum + 1) / 2) < target) {
            return false;
        }
        int[][] memo = new int[2][1 << maxNum];
        Arrays.fill(memo[0], -1);
        Arrays.fill(memo[1], -1);
        return checkWin(memo, 0, maxNum, target, 0, 0) == 1;
    }

    private int checkWin(int[][] memo, int total, int maxNum, int target, int usedMask, int turn) {
        if (memo[turn][usedMask] != -1) {
            return memo[turn][usedMask];
        }
        for (int num = 1; num <= maxNum; num++) {
            int bit = (1 << (num - 1));
            if ((usedMask & bit) == 0) {
                if (total + num >= target || checkWin(memo, total + num, maxNum, target, usedMask | bit, 1 - turn) != 1) {
                    return memo[turn][usedMask] = 1;
                }
            }
        }
        return memo[turn][usedMask] = 0;
    }
}
