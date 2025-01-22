class Solution {
    class Cell {
        int height;
        int row;
        int col;

        public Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;

        boolean[][] isVisited = new boolean[rows][cols];
        int[][] result = new int[rows][cols];

        PriorityQueue<Cell> priorityQueue = new PriorityQueue<>((a, b) -> a.height - b.height);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isWater[row][col] == 1) {
                    priorityQueue.offer(new Cell(0, row, col));
                    isVisited[row][col] = true;
                }
            }
        }
        if (priorityQueue.isEmpty()) {
            priorityQueue.offer(new Cell(1, 0, 0));
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!priorityQueue.isEmpty()) {
            Cell currentCell = priorityQueue.poll();
            int row = currentCell.row;
            int col = currentCell.col;
            int height = currentCell.height;
            result[row][col] = height;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || isVisited[newRow][newCol]) {
                    continue;
                } else {
                    isVisited[newRow][newCol] = true;
                    priorityQueue.offer(new Cell(height + 1, newRow, newCol));
                }
            }
        }

        return result;
    }
}
