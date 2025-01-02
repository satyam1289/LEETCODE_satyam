class Solution {
    
    private boolean isVowelString(String word) {
        if (word.isEmpty()) return false;
        String vowels = "aeiou";
        char start = word.charAt(0);
        char end = word.charAt(word.length() - 1);
        return vowels.indexOf(start) != -1 && vowels.indexOf(end) != -1;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n + 1]; 
     
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (isVowelString(words[i]) ? 1 : 0);
        }

        int[] results = new int[queries.length];

       
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            results[i] = prefixSum[end + 1] - prefixSum[start];
        }

        return results;
    }
}
