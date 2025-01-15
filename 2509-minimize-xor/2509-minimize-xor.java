class Solution {
    public int minimizeXor(int a, int b) {
        int result = 0;
        int setBits = Integer.bitCount(b);
        for(int i = 31; (setBits > 0 && i >= 0); i--) {
            if(((a >> i) & 1) != 0) {
                result = result | 1 << i;
                setBits--;
            }
        }
        for(int i = 0; (setBits > 0 && i <= 31); i++) {
            if((result & (1 << i)) == 0) {
                result = result | (1 << i);
                setBits--;
            }
        }
        return result;
    }
}
