import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] mat) {
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] r : mat) {
            int firstElem = r[0];
            StringBuilder pattern = new StringBuilder();
            for (int i = 0; i < r.length; i++) {
                pattern.append(firstElem == r[i] ? '1' : '0');
            }
            patternCount.put(pattern.toString(), patternCount.getOrDefault(pattern.toString(), 0) + 1);
        }

        int maxCount = 0;
        for (int count : patternCount.values()) {
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
