class Solution {
    public long countFairPairs(int[] numbers, int low, int high) {
        Arrays.sort(numbers);
        return countSmaller(numbers, high) - countSmaller(numbers, low - 1);     
    }

    private long countSmaller(int[] numbers, int limit) {
        int left = 0, right = numbers.length - 1;
        long total = 0;
        while (left < right) {
            int pairSum = numbers[left] + numbers[right];
            if (pairSum <= limit) {
                total += (right - left);
                left++;   
            } else {    
                right--;
            }
        }
        return total;
    }
}
