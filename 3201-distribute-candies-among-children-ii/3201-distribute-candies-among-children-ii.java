class Solution {
    public static long countWays(long candies) {
        if (candies < 0) {
            return 0;
        }
        return (candies + 2) * (candies + 1) / 2;
    }

    public long distributeCandies(long total, long limit) {
        long allWays = countWays(total);
        long oneLimit = 3 * countWays(total - (limit + 1));
        long twoLimit = 3 * countWays(total - 2 * (limit + 1));
        long threeLimit = countWays(total - 3 * (limit + 1));
        return allWays - oneLimit + twoLimit - threeLimit;
    }
}
