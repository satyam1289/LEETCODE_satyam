class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return calc(days, costs, dp, 0);
    }

    private int calc(int[] days, int[] costs, int[] dp, int idx) {
        if (idx >= days.length) return 0;
        if (dp[idx] != -1) return dp[idx];

        int cost = costs[0] + calc(days, costs, dp, idx + 1);

        for (int i = 1; i < 3; i++) {
            cost = Math.min(cost, costs[i] + calc(days, costs, dp, i == 1 ? next(days, days[idx] + 6) : next(days, days[idx] + 29)));
        }

        return dp[idx] = cost;
    }

    private int next(int[] days, int target) {
        if (target >= days[days.length - 1]) return days.length;

        int lo = 0, hi = days.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (days[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
