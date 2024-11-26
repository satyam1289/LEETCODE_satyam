class Solution {
    public int findChampion(int n, int[][] matches) {
        boolean[] canBeChampion = new boolean[n];
        Arrays.fill(canBeChampion, true);
        
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            canBeChampion[loser] = false;
        }
        
        int potentialChampion = -1;
        int potentialChampionCount = 0;
        
        for (int team = 0; team < n; team++) {
            if (canBeChampion[team]) {
                potentialChampion = team;
                potentialChampionCount++;
            }
        }
        
        return potentialChampionCount == 1 ? potentialChampion : -1;
    }
}
