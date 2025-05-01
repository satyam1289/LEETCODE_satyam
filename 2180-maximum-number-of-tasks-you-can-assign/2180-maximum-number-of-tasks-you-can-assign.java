public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0, right = Math.min(tasks.length, workers.length), ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int p = pills;
        int j = workers.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            while (j >= workers.length - k && workers[j] + strength >= tasks[i]) {
                dq.add(workers[j]);
                j--;
            }
            if (dq.isEmpty()) return false;
            if (dq.peekFirst() >= tasks[i]) {
                dq.pollFirst();
            } else if (p > 0) {
                dq.pollLast();
                p--;
            } else {
                return false;
            }
        }
        return true;
    }
}
