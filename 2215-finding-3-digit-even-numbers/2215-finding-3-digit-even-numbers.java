class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits)
            freq[digit]++;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            if (freq[i] == 0)
                continue;
            freq[i]--;
            for (int j = 0; j <= 9; j++){
                if (freq[j] == 0)
                    continue;
                freq[j]--;
                for (int k = 0; k <= 8; k += 2){
                    if (freq[k] == 0)
                        continue;
                    list.add(i * 100 + j * 10 + k);
                }
                freq[j]++;
            }
            freq[i]++;
        }
        int n = list.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = list.get(i);
        return res;
    }
}