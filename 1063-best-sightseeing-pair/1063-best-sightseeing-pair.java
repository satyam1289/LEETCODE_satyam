class Solution {
    public int maxScoreSightseeingPair(int[] vals) {
        int maxScore = 0;
        int maxPrev = vals[0];
        
        for (int j = 1; j < vals.length; j++) {
            maxScore = Math.max(maxScore, maxPrev + vals[j] - j);
            maxPrev = Math.max(maxPrev, vals[j] + j);
        }
        
        return maxScore;
    }
}
