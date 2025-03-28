import java.util.*;

class Solution {
    public int[] maxPoints(int[][] matrix, int[] requests) {
        int rows = matrix.length, cols = matrix[0].length, reqLen = requests.length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] reqIndex = new int[reqLen][2];
        for (int i = 0; i < reqLen; i++) {
            reqIndex[i] = new int[]{requests[i], i};
        }
        Arrays.sort(reqIndex, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{matrix[0][0], 0, 0});

        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        int[] response = new int[reqLen];
        int count = 0;

        for (int[] req : reqIndex) {
            int value = req[0], index = req[1];

            while (!minHeap.isEmpty() && minHeap.peek()[0] < value) {
                int[] cell = minHeap.poll();
                int r = cell[1], c = cell[2];
                count++;

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                        minHeap.offer(new int[]{matrix[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            response[index] = count;
        }

        return response;
    }
}
