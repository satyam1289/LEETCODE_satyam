class Solution {
    public int countCompleteSubarrays(int[] a) {
        int uniq = (int) Arrays.stream(a).distinct().count();
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0, l = 0;

        for (int r = 0; r < a.length; r++) {
            freq.put(a[r], freq.getOrDefault(a[r], 0) + 1);
            while (freq.size() == uniq) {
                res += a.length - r;
                freq.put(a[l], freq.get(a[l]) - 1);
                if (freq.get(a[l]) == 0)
                    freq.remove(a[l]);
                l++;
            }
        }
        return res;
    }
}
