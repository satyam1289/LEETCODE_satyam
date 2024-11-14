import java.util.*;

class Solution {
    public int minimizedMaximum(int stores, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();

        while (low < high) {
            int mid = (low + high) / 2;
            int requiredStores = 0;
            for (int quantity : quantities) {
                requiredStores += (quantity + mid - 1) / mid; 
            }

            if (requiredStores > stores) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
