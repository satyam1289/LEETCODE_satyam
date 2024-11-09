class Solution {
    public int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return 0;
        if (grid[x][y] == 0 || visited[x][y]) return 0;
        
        visited[x][y] = true;
        int perimeter = 4;

        if (x > 0 && grid[x - 1][y] == 1) perimeter--;
        if (y + 1 < grid[0].length && grid[x][y + 1] == 1) perimeter--;
        if (y > 0 && grid[x][y - 1] == 1) perimeter--;
        if (x + 1 < grid.length && grid[x + 1][y] == 1) perimeter--;

        perimeter += dfs(grid, visited, x + 1, y);
        perimeter += dfs(grid, visited, x, y + 1);
        perimeter += dfs(grid, visited, x - 1, y);
        perimeter += dfs(grid, visited, x, y - 1);

        return perimeter;
    }

    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxPerimeter = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1 && !visited[x][y]) {
                    maxPerimeter = Math.max(maxPerimeter, dfs(grid, visited, x, y));
                }
            }
        }

        return maxPerimeter;
    }
}
