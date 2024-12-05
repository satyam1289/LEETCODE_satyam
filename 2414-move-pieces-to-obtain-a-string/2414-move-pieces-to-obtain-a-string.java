class Solution {
    public boolean canChange(String start, String target) {
        int s = 0;
        int t = 0;
        int n = start.length();

        while (s < n || t < n) {
            while (s < n && start.charAt(s) == '_') s++;
            while (t < n && target.charAt(t) == '_') t++;

            if (s == n || t == n) break;
            if (start.charAt(s) != target.charAt(t)) return false;
            if (start.charAt(s) == 'L' && s < t) return false;
            if (start.charAt(s) == 'R' && s > t) return false;

            s++;
            t++;
        }
        return s == n && t == n;
    }
}
