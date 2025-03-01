class Solution {
    public int[] applyOperations(int[] array) {
        
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] == array[j + 1]) {
                array[j] *= 2; 
                array[j + 1] = 0; 
            }
        }

        int pos = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] != 0) {
                array[pos++] = array[j]; 
            }
        }

        while (pos < array.length) {
            array[pos++] = 0;
        }

        return array;
    }
}
