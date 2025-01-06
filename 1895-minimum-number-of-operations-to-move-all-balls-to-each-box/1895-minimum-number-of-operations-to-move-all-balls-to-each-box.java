class Solution {
    public int[] minOperations(String s) {
        List<Integer> indices = new ArrayList<>();
        int n = s.length();
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                indices.add(i);
            }
        }
        
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int idx : indices) {
                total += Math.abs(i - idx);
            }
            res[i] = total;
        }
        return res;
    }
}
