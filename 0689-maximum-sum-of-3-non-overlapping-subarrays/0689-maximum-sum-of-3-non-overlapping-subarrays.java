class Solution {
    public int[] maxSumOfThreeSubarrays(int[] arr, int size) {
        int n = arr.length;
        int[] sums = new int[n - size + 1];
        int winSum = 0;

        for (int i = 0; i < size; i++) {
            winSum += arr[i];
        }
        sums[0] = winSum;

        for (int i = size; i < n; i++) {
            winSum = winSum + arr[i] - arr[i - size];
            sums[i - size + 1] = winSum;
        }

        int[] left = new int[sums.length];
        int bestIdx = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[bestIdx]) bestIdx = i;
            left[i] = bestIdx;
        }

        int[] right = new int[sums.length];
        bestIdx = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[bestIdx]) bestIdx = i;
            right[i] = bestIdx;
        }

        int[] res = new int[]{-1, -1, -1};
        int max = 0;

        for (int i = size; i < sums.length - size; i++) {
            int l = left[i - size];
            int r = right[i + size];
            int total = sums[l] + sums[i] + sums[r];
            if (res[0] == -1 || total > max || 
                (total == max && isSmaller(l, i, r, res))) {
                max = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }

        return res;
    }

    private boolean isSmaller(int l, int m, int r, int[] curr) {
        if (l != curr[0]) return l < curr[0];
        if (m != curr[1]) return m < curr[1];
        return r < curr[2];
    }
}
