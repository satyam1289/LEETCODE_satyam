class Solution {
    public int maxVowels(String str, int length) {
        int maxCount = 0;
        int currentCount = 0;
        
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        
        for (int i = 0; i < length; i++) {
            if (vowelSet.contains(str.charAt(i))) {
                currentCount++;
            }
        }
        maxCount = currentCount;

        for (int i = length; i < str.length(); i++) {
            if (vowelSet.contains(str.charAt(i - length))) {
                currentCount--;
            }
            if (vowelSet.contains(str.charAt(i))) {
                currentCount++;
            }
            maxCount = Math.max(maxCount, currentCount);
        }
        
        return maxCount;
    }
}
