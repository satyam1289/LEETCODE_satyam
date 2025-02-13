class Solution {
    public int minOperations(int[] arr, int target) {
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        for (int val : arr) {
            minHeap.add((double) val);
        }
        int count = 0;
        while (minHeap.size() > 1) {
            double first = minHeap.poll();
            double second = minHeap.poll();
            if (first >= target) {
                return count;
            }
            double newVal = 2 * Math.min(first, second) + Math.max(first, second);
            minHeap.add(newVal);
            count++;
        }
        return count;
    }
}
