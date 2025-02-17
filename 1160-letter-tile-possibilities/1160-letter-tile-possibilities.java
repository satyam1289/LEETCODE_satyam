class Solution {
    public static int backtrack(HashMap<Character, Integer> freqMap) {
        int count = 0;
        for (char ch : freqMap.keySet()) {
            if (freqMap.get(ch) > 0) {
                freqMap.put(ch, freqMap.get(ch) - 1);
                count += 1 + backtrack(freqMap);
                freqMap.put(ch, freqMap.get(ch) + 1);
            }
        }
        return count;
    }

    public static int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : tiles.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        return backtrack(freqMap);
    }
}