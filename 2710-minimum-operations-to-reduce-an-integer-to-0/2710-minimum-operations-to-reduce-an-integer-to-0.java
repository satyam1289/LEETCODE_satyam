class Solution {
    public int minOperations(int n) {
        int operations = 0;
        
        while (n > 0) {
            if ((n & 1) == 0) {
                n >>= 1;
            } else {
                if ((n & 2) == 0) {
                    n -= 1;
                } else {
                    n += 1;
                }
                operations++;
            }
        }

        return operations;
    }
}
