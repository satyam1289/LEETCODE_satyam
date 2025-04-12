class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> set = new HashSet<>();

        int half = (n + 1) / 2;
        int low = (int) Math.pow(10, half - 1);
        int high = (int) Math.pow(10, half) - 1;

        for (int i = low; i <= high; i++) {
            String left = Integer.toString(i);
            String full;

            if (n % 2 == 0) {
                StringBuilder right = new StringBuilder(left).reverse();
                full = left + right.toString();
            } else {
                StringBuilder right = new StringBuilder(left.substring(0, half - 1)).reverse();
                full = left + right.toString();
            }

            long num = Long.parseLong(full);
            if (num % k != 0) continue;

            char[] arr = full.toCharArray();
            Arrays.sort(arr);
            set.add(new String(arr));
        }

        long[] fact = new long[11];
        fact[0] = 1;
        for (int i = 1; i < 11; i++) {
            fact[i] = fact[i - 1] * i;
        }

        long res = 0;
        for (String s : set) {
            int[] cnt = new int[10];
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }

            int total = s.length();
            int zero = cnt[0];
            int nonZero = total - zero;

            long perm = nonZero * fact[total - 1];
            for (int i = 0; i < 10; i++) {
                perm /= fact[cnt[i]];
            }

            res += perm;
        }

        return res;
    }
}
