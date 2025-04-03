class Solution {
    public long maximumTripletValue(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        int maxDiff = 0;
        long result = 0;
        
        for (int i = 0; i < arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
            if (i >= 2)
                result = Math.max(result, (long) maxDiff * arr[i]);
            if (i >= 1)
                maxDiff = Math.max(maxDiff, maxVal - arr[i]);
        }
        
        return result;
    }
}
