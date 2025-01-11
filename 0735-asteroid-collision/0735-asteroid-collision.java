class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.addLast(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peekLast() > 0 && Math.abs(asteroid) > stack.peekLast()) {
                    stack.removeLast();
                }

                if (!stack.isEmpty() && stack.peekLast() == Math.abs(asteroid)) {
                    stack.removeLast();
                } else if (stack.isEmpty() || stack.peekLast() < 0) {
                    stack.addLast(asteroid);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.removeFirst();
        }
        return result;
    }
}
