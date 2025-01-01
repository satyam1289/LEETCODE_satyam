class Solution {
    public int maxScore(String binaryString) {
        int length = binaryString.length();
        int oneCount = 0;
        int maxDifference = -1;
        int zeroCount = 0;
        for (int index = 0; index < length - 1; index++) {
            if (binaryString.charAt(index) == '0') zeroCount++;
            else oneCount++;
            maxDifference = Math.max(maxDifference, zeroCount - oneCount);
        }
        if (binaryString.charAt(length - 1) == '1') oneCount++;
        return (maxDifference + oneCount);
    }
}
