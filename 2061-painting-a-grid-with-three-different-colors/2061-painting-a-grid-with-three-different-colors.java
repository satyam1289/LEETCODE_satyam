public class Solution {
    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<int[]> list = new ArrayList<>();
        generateStates(m, new int[m], 0, list);

        Map<String, List<String>> map = new HashMap<>();
        for (int[] a : list) {
            String sa = Arrays.toString(a);
            map.putIfAbsent(sa, new ArrayList<>());
            for (int[] b : list) {
                if (isCompatible(a, b)) {
                    map.get(sa).add(Arrays.toString(b));
                }
            }
        }

        Map<String, Integer> dp = new HashMap<>();
        for (int[] arr : list) {
            dp.put(Arrays.toString(arr), 1);
        }

        for (int i = 1; i < n; i++) {
            Map<String, Integer> next = new HashMap<>();
            for (String prev : dp.keySet()) {
                int cnt = dp.get(prev);
                for (String cur : map.get(prev)) {
                    next.put(cur, (next.getOrDefault(cur, 0) + cnt) % MOD);
                }
            }
            dp = next;
        }

        int ans = 0;
        for (int x : dp.values()) {
            ans = (ans + x) % MOD;
        }

        return ans;
    }

    private void generateStates(int m, int[] arr, int idx, List<int[]> list) {
        if (idx == m) {
            list.add(Arrays.copyOf(arr, m));
            return;
        }

        for (int c = 1; c <= 3; c++) {
            if (idx > 0 && arr[idx - 1] == c) continue;
            arr[idx] = c;
            generateStates(m, arr, idx + 1, list);
        }
    }

    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}
