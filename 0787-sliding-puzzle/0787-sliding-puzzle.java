class Solution {
    private String swap(String a, int b, int c) {
        StringBuilder d = new StringBuilder(a);
        d.setCharAt(b, a.charAt(c));
        d.setCharAt(c, a.charAt(b));
        return d.toString();
    }

    public int slidingPuzzle(int[][] a) {
        int[][] b = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String c = "123450";
        StringBuilder d = new StringBuilder("");
        for (int e = 0; e < a.length; e++) {
            for (int f = 0; f < a[0].length; f++) {
                d.append(a[e][f]);
            }
        }
        Set<String> e = new HashSet<>();
        Queue<String> f = new LinkedList<>();
        f.add(d.toString());
        int g, h = 0;
        while (!f.isEmpty()) {
            g = f.size();
            for (int i = 0; i < g; i++) {
                String j = f.poll();
                if (j.equals(c)) {
                    return h;
                }
                int k = j.indexOf('0');
                for (int l : b[k]) {
                    String m = swap(j, k, l);
                    if (e.contains(m)) {
                        continue;
                    }
                    f.add(m);
                    e.add(m);
                }
            }
            h++;
        }
        return -1;
    }
}
