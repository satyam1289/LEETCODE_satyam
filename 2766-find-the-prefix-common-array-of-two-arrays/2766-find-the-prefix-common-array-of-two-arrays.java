class Solution {
    public int[] findThePrefixCommonArray(int[] arr1, int[] arr2) {
        int[] freq = new int[arr1.length];
        int[] result = new int[arr1.length];
        int commonCount = 0;

        for (int i = 0; i < arr1.length; i++) {
            freq[arr1[i] - 1]++;
            if (freq[arr1[i] - 1] == 2) commonCount++;

            freq[arr2[i] - 1]++;
            if (freq[arr2[i] - 1] == 2) commonCount++;

            result[i] = commonCount;
        }

        return result;
    }
}
