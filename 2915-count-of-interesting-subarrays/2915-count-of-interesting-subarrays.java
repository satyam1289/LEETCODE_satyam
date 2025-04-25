class Solution {
    public long countInterestingSubarrays(List<Integer> a, int m, int k) {
        int n = a.size();
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        long res = 0;
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += (a.get(i) % m == k) ? 1 : 0;
            s %= m;
            int t = (s - k + m) % m;
            res += mp.getOrDefault(t, 0);
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }
        return res;
    }
}
