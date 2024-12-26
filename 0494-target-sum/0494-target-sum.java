class Solution {
    public int findTargetSumWays(int[] numbers, int targetSum) {
        int totalArraySum = 0;
        for (int number : numbers) {
            totalArraySum += number;
        }

       
        if ((targetSum + totalArraySum) % 2 != 0 || targetSum > totalArraySum || targetSum < -totalArraySum) {
            return 0;
        }

        int requiredSubsetSum = (targetSum + totalArraySum) / 2;

        
        int[] subsetCount = new int[requiredSubsetSum + 1];
        subsetCount[0] = 1;

        for (int number : numbers) {
            for (int currentSum = requiredSubsetSum; currentSum >= number; currentSum--) {
                subsetCount[currentSum] += subsetCount[currentSum - number];
            }
        }

        return subsetCount[requiredSubsetSum];
    }
}
