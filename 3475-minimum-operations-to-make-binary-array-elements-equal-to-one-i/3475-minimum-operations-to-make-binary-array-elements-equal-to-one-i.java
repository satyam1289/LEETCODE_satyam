class Solution {
    public int minOperations(int[] values) {
        int size = values.length;
        int operations = 0;

        for (int index = 0; index < size - 2; index++) {
            if (values[index] == 0) {
                values[index] = 1;
                values[index + 1] = 1 - values[index + 1]; 
                values[index + 2] = 1 - values[index + 2];
                operations++;
            }  
        }

        if (values[size - 1] == 0 || values[size - 2] == 0) {
            return -1;
        }

        return operations;
    }
}
