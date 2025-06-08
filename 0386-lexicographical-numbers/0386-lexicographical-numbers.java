class Solution {

    public void solve(List<Integer> ans, int n, int curr) {
        if (curr > n) return;
        ans.add(curr);
        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            int nextNum = curr * 10 + nextDigit;
            if (nextNum > n) return;
            solve(ans, n, nextNum);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            solve(ans, n, i);
        }
        return ans;
    }
}
