class Solution {
    public int isPrefixOfWord(String text, String prefix) {
        String[] words = text.split(" ");
        int totalWords = words.length;
        for (int idx = 0; idx < totalWords; idx++) {
            String word = words[idx];
            if (word.charAt(0) == prefix.charAt(0)) {
                if (matchesPrefix(word, prefix)) return idx + 1;
            }
        }
        return -1;
    }

    private boolean matchesPrefix(String word, String prefix) {
        int prefixLen = prefix.length();
        int wordLen = word.length();
        if (prefixLen > wordLen) return false;
        for (int idx = 0; idx < prefixLen; idx++) {
            if (word.charAt(idx) != prefix.charAt(idx)) return false;
        }
        return true;
    }
}
