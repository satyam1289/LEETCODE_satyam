class Solution {
    public int maxOperations(int[] arr, int target) {
        int left = 0, right = arr.length - 1, operations = 0;
        Arrays.sort(arr);
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                operations++;
                left++;
                right--;
            } else if (arr[left] + arr[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return operations;
    }
}
