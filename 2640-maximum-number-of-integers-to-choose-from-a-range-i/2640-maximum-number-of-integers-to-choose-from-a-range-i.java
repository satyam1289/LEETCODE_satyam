class Solution {
    public int maxCount(int[] restricted, int limit, int totalMaxSum) {
        Set<Integer> restrictedSet = new HashSet<>();
        for (int number : restricted) {
            restrictedSet.add(number);
        }
        
        int currentSum = 0, elementCount = 0;
        for (int num = 1; num <= limit; num++) {
            if (!restrictedSet.contains(num) && currentSum + num <= totalMaxSum) {
                currentSum += num;
                elementCount++;
            }
        }

        return elementCount;
    }
}
