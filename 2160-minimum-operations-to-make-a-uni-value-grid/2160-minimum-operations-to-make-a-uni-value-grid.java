class Solution {
    public int minOperations(int[][] matrix, int step) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] frequency = new int[10001];
        
        boolean invalidCase = false;
        int baseValue = matrix[0][0];
        
        for (int[] row : matrix) {
            for (int element : row) {
                frequency[element]++;
                if (Math.abs(baseValue - element) % step != 0)
                    invalidCase = true;
            }
        }
        if (invalidCase) return -1;
        
        int[] sortedArray = new int[rows * cols];
        int index = 0;
        
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        
        int operations = 0;
        int median = sortedArray[sortedArray.length / 2];
        
        for (int num : sortedArray) {
            operations += Math.abs(num - median) / step;
        }
        
        return operations;
    }
}
