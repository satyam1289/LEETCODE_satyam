import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxStreak = 0;
        
        for (int num : nums) {
            int streak = 0;
            long current = num;
            
            while (set.contains((int) current)) {
                streak++;
                current *= current;
                if (current > Integer.MAX_VALUE) break; 
            }
            
            maxStreak = Math.max(maxStreak, streak);
        }
        
        return maxStreak > 1 ? maxStreak : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {2, 4, 16, 256};
        int[] nums2 = {1, 3, 9, 27}; 
        System.out.println(sol.longestSquareStreak(nums1)); 
        System.out.println( sol.longestSquareStreak(nums2)); 
    }
}
