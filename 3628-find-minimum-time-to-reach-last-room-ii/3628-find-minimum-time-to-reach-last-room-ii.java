import java.util.*;

class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Node implements Comparable<Node> {
        int time, r, c;

        Node(int time, int r, int c) {
            this.time = time;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public int minTimeToReach(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] minTime = new int[rows][cols];
        for (int[] row : minTime) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        minTime[0][0] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.r == rows - 1 && curr.c == cols - 1) return curr.time;

            for (int[] d : DIRS) {
                int nr = curr.r + d[0], nc = curr.c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int move = (nr + nc) % 2 == 0 ? 2 : 1;
                    int wait = Math.max(grid[nr][nc] - curr.time, 0);
                    int nextTime = curr.time + wait + move;

                    if (nextTime < minTime[nr][nc]) {
                        minTime[nr][nc] = nextTime;
                        pq.offer(new Node(nextTime, nr, nc));
                    }
                }
            }
        }

        return -1;
    }
}
