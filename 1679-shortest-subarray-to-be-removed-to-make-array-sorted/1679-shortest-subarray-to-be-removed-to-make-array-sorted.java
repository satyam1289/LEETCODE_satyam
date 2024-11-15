class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        while (left + 1 < arr.length && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        if (left == arr.length - 1) {
            return 0;
        }
        
        int right = arr.length - 1;
        while (right > left && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        int minRemove = Math.min(arr.length - left - 1, right);
        
        int l = 0;
        int r = right;
        while (l <= left && r < arr.length) {
            if (arr[r] >= arr[l]) {
                minRemove = Math.min(minRemove, r - l - 1);
                l++;
            } else {
                r++;
            }
        }
        
        return minRemove;
    }
}
