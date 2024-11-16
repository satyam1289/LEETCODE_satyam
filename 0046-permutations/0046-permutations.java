class Solution {
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> b = new ArrayList<>();
        f(new ArrayList<>(), a, 0, b);
        return b;
    }
    
    static void f(ArrayList<Integer> c, int[] a, int d, List<List<Integer>> b) {
        c = new ArrayList<>(c);
        if (c.size() == a.length) {
            b.add(c);
        } else {
            for (int e = 0; e <= c.size(); e++) {
                c.add(e, a[d]);
                f(c, a, ++d, b);
                c.remove(e);
                d = d - 1;
            }
        }
    }
}
