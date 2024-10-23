class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = 10000000;
        int minSpeed = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canReachOnTime(dist, hour, mid)) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minSpeed;
    }

    private boolean canReachOnTime(int[] dist, double hour, int speed) {
        double time = 0.0;
        for (int i = 0; i < dist.length; i++) {
            if (i < dist.length - 1) {
                time += Math.ceil((double) dist[i] / speed);
            } else {
                time += (double) dist[i] / speed;
            }
        }
        return time <= hour;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] dist1 = {1, 3, 2};
        double hour1 = 2.7;
        System.out.println(solution.minSpeedOnTime(dist1, hour1)); 

        int[] dist2 = {1, 3, 2};
        double hour2 = 1.9;
        System.out.println(solution.minSpeedOnTime(dist2, hour2));
    }
}
