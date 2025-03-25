class Solution {
    static class P {
        int c;
        boolean e;

        P(int c, boolean e) {
            this.c = c;
            this.e = e;
        }
    }

    public boolean checkValidCuts(int n, int[][] r) {
        TreeMap<Integer, P> x = new TreeMap<>();
        TreeMap<Integer, P> y = new TreeMap<>();

        for (int[] rect : r) {
            int x1 = rect[0], x2 = rect[2];
            int y1 = rect[1], y2 = rect[3];

            x.merge(x1 + 1, new P(1, false), this::m);
            x.merge(x2, new P(-1, true), this::m);

            y.merge(y1 + 1, new P(1, false), this::m);
            y.merge(y2, new P(-1, true), this::m);
        }

        return v(x, n) || v(y, n);
    }

    private P m(P o, P n) {
        o.c += n.c;
        o.e |= n.e;
        return o;
    }

    public boolean v(TreeMap<Integer, P> m, int n) {
        int a = 0, b = 0, c = 0;

        for (Map.Entry<Integer, P> e : m.entrySet()) {
            int v = e.getKey();
            P p = e.getValue();

            a += p.c;

            if (p.e) {
                b = v;
            }

            if (b != 0 && a == 0) {
                c++;
            }
        }

        return c >= 3;
    }
}
