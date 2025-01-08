class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = words[i];
                String s2 = words[j];

                if (s2.startsWith(s1) && s2.endsWith(s1)) {
                    count++;
                }
            }
        }

        return count;
    }
}
