import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        Set<Integer> neededLetters = new HashSet<>();

        for (String word : words2) {
            int[] wordFreq = countFreq(word);
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] > maxFreq[i]) {
                    maxFreq[i] = wordFreq[i];
                    neededLetters.add(i);
                }
            }
        }

        List<Integer> neededList = new ArrayList<>(neededLetters);
        List<String> universalWords = new ArrayList<>();

        for (String word : words1) {
            int[] wordFreq = countFreq(word);
            boolean isUniversal = true;
            for (int i : neededList) {
                if (wordFreq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                universalWords.add(word);
            }
        }

        return universalWords;
    }

    private int[] countFreq(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
