class Solution {
    public List<String> getWordsInLongestSubsequence(String[] wordList, int[] groupIds) {
        int len = groupIds.length;
        int[] lengthDp = new int[len];
        int[] previousIndex = new int[len];
        Arrays.fill(lengthDp, 1);
        Arrays.fill(previousIndex, -1);
        int maxLenIndex = 0;

        for (int curr = 1; curr < len; curr++) {
            for (int prev = 0; prev < curr; prev++) {
                if (
                    differsByOneChar(wordList[curr], wordList[prev]) &&
                    lengthDp[prev] + 1 > lengthDp[curr] &&
                    groupIds[curr] != groupIds[prev]
                ) {
                    lengthDp[curr] = lengthDp[prev] + 1;
                    previousIndex[curr] = prev;
                }
            }
            if (lengthDp[curr] > lengthDp[maxLenIndex]) {
                maxLenIndex = curr;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = maxLenIndex; i >= 0; i = previousIndex[i]) {
            result.add(wordList[i]);
        }
        Collections.reverse(result);
        return result;
    }

    private boolean differsByOneChar(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int mismatch = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (++mismatch > 1) {
                    return false;
                }
            }
        }
        return mismatch == 1;
    }
}
