class Solution {
    public String addSpaces(String s, int[] sp) {
        int si = 0;
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (si < sp.length && i == sp[si]) {
                res.append(" ");
                si++;
            }
            res.append(s.charAt(i));
        }
        
        return res.toString();
    }
}
