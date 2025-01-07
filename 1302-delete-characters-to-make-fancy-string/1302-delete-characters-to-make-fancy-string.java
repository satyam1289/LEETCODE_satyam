class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if (n < 3) return s;
        StringBuilder result = new StringBuilder(s.substring(0, 2));
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) continue;
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
