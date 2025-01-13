class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int pile : piles) {
            maxHeap.add(pile);
        }

        for (int i = 0; i < k; i++) {
            int largestPile = maxHeap.poll();
            maxHeap.add((largestPile + 1) / 2);
        }

        int totalStones = 0;
        while (!maxHeap.isEmpty()) {
            totalStones += maxHeap.poll();
        }

        return totalStones;
    }
}
