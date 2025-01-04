class Solution {
    public List<List<Integer>> findDifference(int[] n1, int[] n2) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        for (int x : n1) s1.add(x);
        for (int x : n2) s2.add(x);
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for (int x : s1) if (!s2.contains(x)) l1.add(x);
        for (int x : s2) if (!s1.contains(x)) l2.add(x);
        res.add(l1);
        res.add(l2);
        return res;
    }
}
