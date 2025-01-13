import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                    grid[r][c] = 3;
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;

        if (freshCount == 0) return 0;
        if (queue.isEmpty()) return -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                if (row + 1 < rows && grid[row + 1][col] == 1) {
                    queue.add(new int[]{row + 1, col});
                    grid[row + 1][col] = 3;
                }

                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    queue.add(new int[]{row - 1, col});
                    grid[row - 1][col] = 3;
                }

                if (col + 1 < cols && grid[row][col + 1] == 1) {
                    queue.add(new int[]{row, col + 1});
                    grid[row][col + 1] = 3;
                }

                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    queue.add(new int[]{row, col - 1});
                    grid[row][col - 1] = 3;
                }
            }
            minutes++;
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) return -1;
            }
        }
        return minutes - 1;
    }
}
