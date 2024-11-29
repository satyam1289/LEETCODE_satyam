class Pair {
    int row, col, time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        priorityQueue.offer(new int[]{grid[0][0], 0, 0});

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentTime = current[0];
            int currentRow = current[1];
            int currentCol = current[2];

            if (currentRow == rows - 1 && currentCol == cols - 1) return currentTime;
            if (visited[currentRow][currentCol]) continue;
            visited[currentRow][currentCol] = true;

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]) continue;

                int waitTime = (grid[newRow][newCol] - currentTime) % 2 == 0 ? 1 : 0;
                int nextTime = Math.max(grid[newRow][newCol] + waitTime, currentTime + 1);
                priorityQueue.offer(new int[]{nextTime, newRow, newCol});
            }
        }
        return -1;
    }
}
