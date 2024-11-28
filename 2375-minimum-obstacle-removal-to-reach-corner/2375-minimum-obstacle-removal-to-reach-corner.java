class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] distance = new int[rows][cols];
        
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        distance[0][0] = 0;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0, 0});
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currX = current[0], currY = current[1];
            
            for (int[] dir : directions) {
                int nextX = currX + dir[0], nextY = currY + dir[1];
                
                if (nextX >= 0 && nextY >= 0 && nextX < rows && nextY < cols) {
                    int newCost = distance[currX][currY] + grid[nextX][nextY];
                    
                    if (newCost < distance[nextX][nextY]) {
                        distance[nextX][nextY] = newCost;
                        
                        if (grid[nextX][nextY] == 0) {
                            deque.addFirst(new int[]{nextX, nextY});
                        } else {
                            deque.addLast(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
        return distance[rows - 1][cols - 1];
    }
}
