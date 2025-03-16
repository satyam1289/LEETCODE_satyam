class Solution {
    private boolean canRepair(int[] efficiency, long timeLimit, int totalCars) {
        long repairedCars = 0;
        for (int rate : efficiency) {
            repairedCars += Math.sqrt(1.0 * timeLimit / rate);
        }
        return repairedCars >= totalCars;
    }

    public long repairCars(int[] efficiency, int totalCars) {
        long left = 1;
        long right = 1L * totalCars * totalCars * Arrays.stream(efficiency).max().orElse(Integer.MIN_VALUE);
        
        while (left < right) {
            long midTime = left + (right - left) / 2;
            if (canRepair(efficiency, midTime, totalCars))
                right = midTime;
            else
                left = midTime + 1;
        }

        return left;
    }
}
