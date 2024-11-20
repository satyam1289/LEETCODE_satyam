class Solution {
    public int takeCharacters(String s, int k) {
        int[] cnt = new int[3];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
            return -1;
        }
        int remA = cnt[0] - k;
        int remB = cnt[1] - k;
        int remC = cnt[2] - k;

        int[] winCnt = new int[3];
        int maxWin = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            winCnt[s.charAt(right) - 'a']++;

            while (winCnt[0] > remA || winCnt[1] > remB || winCnt[2] > remC) {
                winCnt[s.charAt(left) - 'a']--;
                left++;
            }
            maxWin = Math.max(maxWin, right - left + 1);
        }
        return s.length() - maxWin;
    }
}
