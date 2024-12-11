class Solution {
    public int maximumBeauty(int[] arr, int adjustment) {
        int length = arr.length;
        int maxElement = 0;

        for (int i = 0; i < length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        int[] rangeTracker = new int[maxElement + 10];

        for (int i = 0; i < length; i++) {
            int start = Math.max(0, arr[i] - adjustment);
            int end = Math.min(maxElement, arr[i] + adjustment) + 1;
            rangeTracker[start]++;
            rangeTracker[end]--;
        }

        int maxBeauty = rangeTracker[0];
        for (int i = 1; i < rangeTracker.length; i++) {
            rangeTracker[i] += rangeTracker[i - 1];
            if (rangeTracker[i] > maxBeauty) {
                maxBeauty = rangeTracker[i];
            }
        }

        return maxBeauty;
    }
}
