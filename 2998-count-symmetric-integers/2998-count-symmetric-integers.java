class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int total = 0;
        for (int num = low; num <= high; num++) {
            if (isSymmetric(num)) {
                total++;
            }
        }
        return total;
    }

    private boolean isSymmetric(int n) {
        String str = Integer.toString(n);
        int len = str.length();
        if (len % 2 != 0) return false;

        int mid = len / 2, leftSum = 0, rightSum = 0;
        for (int i = 0; i < mid; i++) leftSum += str.charAt(i) - '0';
        for (int i = mid; i < len; i++) rightSum += str.charAt(i) - '0';

        return leftSum == rightSum;
    }
}
