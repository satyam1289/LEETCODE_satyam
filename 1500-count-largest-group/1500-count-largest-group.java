class Solution {

    public int ds(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> m = new HashMap<>();
        int max = 0, c = 0;

        for (int i = 1; i <= n; i++) {
            int sum = ds(i);
            m.put(sum, m.getOrDefault(sum, 0) + 1);
            if (m.get(sum) == max) {
                c++;
            } else if (m.get(sum) > max) {
                max = m.get(sum);
                c = 1;
            }
        }

        return c;
    }
}
