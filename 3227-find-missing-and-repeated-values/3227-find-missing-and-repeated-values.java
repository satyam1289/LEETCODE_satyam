class Solution {
    public int[] findMissingAndRepeatedValues(int[][] matrix) {
        int size = matrix.length;
        int repeated = 0, missing = 0;
        int[] count = new int[size * size + 1];

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                count[matrix[row][col]]++;
            }
        }

        for(int num = 1; num <= size * size; num++){
            if(count[num] > 1){
                repeated = num;
            }

            if(count[num] == 0){
                missing = num;
            }
        }

        return new int[]{repeated, missing};
    }
}
