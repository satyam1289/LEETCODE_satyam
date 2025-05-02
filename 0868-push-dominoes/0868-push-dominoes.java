class Solution {
    public String pushDominoes(String s) {
        int n = s.length();
        int[] rL = new int[n]; 
        int[] lR = new int[n];

  
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'L') rL[i] = i;
            else if (s.charAt(i) == '.') rL[i] = (i < n - 1) ? rL[i + 1] : -1;
            else rL[i] = -1;
        }

       
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') lR[i] = i;
            else if (s.charAt(i) == '.') lR[i] = (i > 0) ? lR[i - 1] : -1;
            else lR[i] = -1;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int dL = rL[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - rL[i]);
            int dR = lR[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - lR[i]);

            if (dL == dR) res.append('.');
            else if (dL < dR) res.append('L');
            else res.append('R');
        }

        return res.toString();
    }
}
