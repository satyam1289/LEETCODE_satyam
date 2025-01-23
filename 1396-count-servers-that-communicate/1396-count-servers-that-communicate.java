class Solution {
    public int countServers(int[][] networkGrid) {

        int rows = networkGrid.length, cols = networkGrid[0].length;

        int rowCount[] = new int[rows];
        int colCount[] = new int[cols];

        int totalServers = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (networkGrid[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                    totalServers++;
                }
            }
        }

        int isolatedServers = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (networkGrid[row][col] == 1 && rowCount[row] == 1 && colCount[col] == 1) {
                    isolatedServers++;
                }
            }
        }

        return totalServers - isolatedServers;
    }
}
