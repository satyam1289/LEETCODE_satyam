class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        int[] nextGreater = new int[nums2.length];

        nextGreater(nextGreater, nums2);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nextGreater[i]);
        }

 
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1); 
        }

        return result;
    }
     public void nextGreater(int[] ans, int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

       
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
    }
}
