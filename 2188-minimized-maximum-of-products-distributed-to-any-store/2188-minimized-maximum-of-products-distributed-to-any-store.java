import java.util.*;

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = Arrays.stream(quantities).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            int req = 0;
            for (int num : quantities) {
                req += (num + mid - 1) / mid; 
            }

            if (req > n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
