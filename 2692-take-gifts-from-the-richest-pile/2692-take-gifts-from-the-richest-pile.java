import java.util.*;

class Solution {
    public long pickGifts(int[] gifts, int operations) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) heap.add(gift);

        for (int i = 0; i < operations && heap.peek() > 1; i++) {
            int maxGift = heap.poll();
            heap.add((int) Math.sqrt(maxGift));
        }

        long total = 0;
        for (int gift : heap) total += gift;
        return total;
    }
}
