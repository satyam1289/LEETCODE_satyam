class BIT {
    private int[] bit;

    public BIT(int size) {
        bit = new int[size + 1];
    }

    public void add(int idx, int val) {
        idx++;
        while (idx < bit.length) {
            bit[idx] += val;
            idx += idx & -idx;
        }
    }

    public int sum(int idx) {
        idx++;
        int total = 0;
        while (idx > 0) {
            total += bit[idx];
            idx -= idx & -idx;
        }
        return total;
    }
}

class Solution {
    public long goodTriplets(int[] a, int[] b) {
        int n = a.length;
        int[] map = new int[n];
        int[] reordered = new int[n];

        for (int i = 0; i < n; i++) {
            map[b[i]] = i;
        }

        for (int i = 0; i < n; i++) {
            reordered[map[a[i]]] = i;
        }

        BIT bit = new BIT(n);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int pos = reordered[i];
            int left = bit.sum(pos);
            bit.add(pos, 1);
            int right = (n - 1 - pos) - (i - left);
            ans += (long) left * right;
        }

        return ans;
    }
}
