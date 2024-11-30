class Solution {
    private Map<Integer, List<Integer>> a = new HashMap<>();
    private Map<Integer, Integer> b = new HashMap<>();
    private Map<Integer, Integer> c = new HashMap<>();
    
    public int[][] validArrangement(int[][] d) {
        for (int[] e : d) {
            a.computeIfAbsent(e[0], f -> new ArrayList<>()).add(e[1]);
            c.put(e[0], c.getOrDefault(e[0], 0) + 1);
            b.put(e[1], b.getOrDefault(e[1], 0) + 1);
        }

        int g = h(), i = d.length, j = 0;
        Stack<Integer> k = new Stack<>();
        l(g, k);
        int[][] m = new int[i][2];

        while (j < i) {
            m[j][0] = k.pop();
            m[j++][1] = k.peek();
        }
        return m;
    }

    public int h() {
        int i = 0;
        for (Map.Entry<Integer, Integer> j : c.entrySet()) {
            int k = j.getValue(), l = j.getKey();
            if (k - b.getOrDefault(l, 0) == 1) {
                return l;
            }
            if (l > 0) {
                i = l;
            }
        }
        return i;
    }

    public void l(int m, Stack<Integer> n) {
        while (c.getOrDefault(m, 0) > 0) {
            c.put(m, c.get(m) - 1);
            int o = a.get(m).get(c.get(m));
            l(o, n);
        }
        n.push(m);
    }
}
