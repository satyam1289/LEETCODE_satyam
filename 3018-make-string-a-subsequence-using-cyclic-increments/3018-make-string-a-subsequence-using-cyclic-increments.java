class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int index2 = 0;
        for(int index1 = 0; index1 < length1 && index2 < length2; index1++) {
            int char1 = str1.charAt(index1);
            int char2 = str2.charAt(index2);
            if(char1 == char2 || char1 + 1 == char2 || char1 - 25 == char2) {
                index2++;
            }
        }
        return index2 == length2;
    }
}
