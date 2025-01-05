class Solution {
    public String shiftingLetters(String str, int[][] ops) {
        int len = str.length();
        int[] charVals = new int[len];
        for (int i = 0; i < len; i++) {
            charVals[i] = str.charAt(i) - 'a';
        }

        int[] diffArr = new int[len + 1];
        for (int[] op : ops) {
            int val = (op[2] == 0) ? -1 : 1;
            diffArr[op[0]] += val;
            diffArr[op[1] + 1] -= val;
        }

        int prefix = 0;
        for (int i = 0; i < len; i++) {
            prefix += diffArr[i];
            int newVal = (charVals[i] + prefix) % 26;
            newVal = (newVal + 26) % 26;
            charVals[i] = newVal;
        }

        StringBuilder result = new StringBuilder();
        for (int val : charVals) {
            result.append((char) (val + 'a'));
        }

        return result.toString();
    }
}
