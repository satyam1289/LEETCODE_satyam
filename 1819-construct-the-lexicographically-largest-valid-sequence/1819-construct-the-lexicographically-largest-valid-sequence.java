class Solution {
    private int[] result;

    public int[] constructDistancedSequence(int n) {
        result = null;
        int[] sequence = new int[2 * n - 1];
        boolean[] isUsed = new boolean[n + 1];
        backtrack(n, 0, sequence, isUsed);
        return result;
    }

    private boolean backtrack(int n, int index, int[] sequence, boolean[] isUsed) {
        if (index == sequence.length) {
            result = sequence.clone();
            return true;
        }

        if (sequence[index] != 0) return backtrack(n, index + 1, sequence, isUsed); // Skip occupied

        for (int num = n; num >= 1; num--) {
            if (isUsed[num]) continue;

            int nextIndex = (num == 1) ? index : index + num;
            if (nextIndex < sequence.length && sequence[nextIndex] == 0) {
                sequence[index] = num;
                sequence[nextIndex] = num;
                isUsed[num] = true;

                if (backtrack(n, index + 1, sequence, isUsed)) return true;

                sequence[index] = 0;
                sequence[nextIndex] = 0;
                isUsed[num] = false;
            }
        }

        return false;
    }
}