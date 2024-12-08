class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int n = events.length;
        int[] maxValues = new int[n];
        int maxSum = 0;

        maxValues[0] = events[0][2];
        for (int i = 1; i < n; i++) {
            maxValues[i] = Math.max(maxValues[i - 1], events[i][2]);
        }

        for (int i = 0; i < n; i++) {
            int currentValue = events[i][2];

            int left = 0, right = i - 1, bestIndex = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][1] < events[i][0]) {
                    bestIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (bestIndex != -1) {
                maxSum = Math.max(maxSum, currentValue + maxValues[bestIndex]);
            } else {
                maxSum = Math.max(maxSum, currentValue);
            }
        }

        return maxSum;
    }
}
