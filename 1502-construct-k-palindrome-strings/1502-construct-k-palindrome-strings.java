class Solution {
    public boolean canConstruct(String str, int num) {
        if (str.length() < num)
            return false;
        
        int[] charCount = new int[26];
        for (char ch : str.toCharArray()) {
            charCount[ch - 'a']++;
        }
        
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0)
                oddCount++;
        }
        
        return oddCount <= num;
    }
}
