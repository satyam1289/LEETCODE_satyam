class Node {
    int number;
    int position;

    public Node(int number, int position) {
        this.number = number;
        this.position = position;
    }
}

class Solution {
    public long findScore(int[] nums) {
        if (nums.length == 0) return 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a.number != b.number) {
                return Integer.compare(a.number, b.number);
            }
            return Integer.compare(a.position, b.position);
        });

        int[] visited = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(new Node(nums[i], i));
        }

        long totalScore = 0;

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.remove();

            if (visited[current.position] == 0) {
                totalScore += current.number;

                if (current.position > 0) visited[current.position - 1] = 1;
                if (current.position < nums.length - 1) visited[current.position + 1] = 1;
            }
        }

        return totalScore;
    }
}
