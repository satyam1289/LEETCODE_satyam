class Solution {
    public int maxChunksToSorted(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int chunkCount = 0, currentMax = 0;
        for (int index = 0; index < array.length; index++) {
            currentMax = Math.max(currentMax, array[index]);
            if (currentMax == index)
                chunkCount++;
        }

        return chunkCount;
    }
}
