class P {
    int f, s;
    P(int f, int s) {
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public int countPalindromicSubsequence(String str) {
        P[] p = new P[26];
        for (int i = 0; i < 26; i++) {
            p[i] = new P(-1, -1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (p[str.charAt(i) - 'a'].f == -1) {
                p[str.charAt(i) - 'a'].f = i;
            } else {
                p[str.charAt(i) - 'a'].s = i;
            }
        }
        int c = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i].f != -1 && p[i].s != -1) {
                HashSet<Character> h = new HashSet<>();
                for (int j = p[i].f + 1; j < p[i].s; j++) {
                    h.add(str.charAt(j));
                }
                c += h.size();
            }
        }
        return c;
    }
}
