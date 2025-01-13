class Solution {
    public int minimumLength(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        
        int minLength = 0;
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                minLength += 2;
            } else {
                minLength += 1;
            }
        }
        
        return minLength;
    }
}
