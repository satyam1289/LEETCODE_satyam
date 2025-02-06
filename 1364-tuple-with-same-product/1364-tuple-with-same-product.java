class Solution {

    public int tupleSameProduct(int[] vals) {
        int len = vals.length;
        Arrays.sort(vals);

        int total = 0;

        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= i + 1; j--) {
                int prod = vals[i] * vals[j];

                Set<Integer> set = new HashSet<>();

                for (int k = i + 1; k < j; k++) {
                    if (prod % vals[k] == 0) {
                        int d = prod / vals[k];

                        if (set.contains(d)) {
                            total += 8;
                        }

                        set.add(vals[k]);
                    }
                }
            }
        }

        return total;
    }
}
