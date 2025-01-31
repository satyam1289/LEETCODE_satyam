public class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] matrix) {
        int size = matrix.length;
        List<Integer> islandSizes = new ArrayList<>();
        int marker = 2;

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (matrix[x][y] == 1) {
                    int regionSize = explore(matrix, x, y, marker);
                    islandSizes.add(regionSize);
                    marker++;
                }
            }
        }

        if (islandSizes.isEmpty()) return 1;

        int maxSize = 0;

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (matrix[x][y] == 0) {
                    Set<Integer> seenIslands = new HashSet<>();
                    int potentialSize = 1;
                    for (int[] direction : directions) {
                        int newX = x + direction[0];
                        int newY = y + direction[1];
                        if (newX >= 0 && newX < size && newY >= 0 && newY < size && matrix[newX][newY] >= 2) {
                            int islandId = matrix[newX][newY];
                            if (!seenIslands.contains(islandId)) {
                                potentialSize += islandSizes.get(islandId - 2);
                                seenIslands.add(islandId);
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, potentialSize);
                }
            }
        }

        return maxSize == 0 ? size * size : maxSize;
    }

    private int explore(int[][] matrix, int x, int y, int marker) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] != 1) {
            return 0;
        }
        matrix[x][y] = marker;
        int count = 1;
        for (int[] direction : directions) {
            count += explore(matrix, x + direction[0], y + direction[1], marker);
        }
        return count;
    }
}
