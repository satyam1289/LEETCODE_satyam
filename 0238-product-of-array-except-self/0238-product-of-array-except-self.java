class Solution {
    public int[] productExceptSelf(int[] inputArray) {
        int length = inputArray.length;
        int[] resultArray = new int[length];
        
        resultArray[0] = 1;
        for (int i = 1; i < length; i++) {
            resultArray[i] = resultArray[i - 1] * inputArray[i - 1];
        }
        
        int rightProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            resultArray[i] *= rightProduct;
            rightProduct *= inputArray[i];
        }
        
        return resultArray;
    }
}
