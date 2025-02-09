import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = i - arr[i];
            freqMap.put(diff, freqMap.getOrDefault(diff, 0) + 1);
        }
        long pairCount = 0;
        for (int count : freqMap.values()) {
            pairCount += (long) count * (count - 1) / 2;
        }
        int len = arr.length;
        long totalPairs = (long) len * (len - 1) / 2;
        return totalPairs - pairCount;
    }
}
