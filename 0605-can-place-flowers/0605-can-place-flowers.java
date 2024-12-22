class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowersPlanted = 0;
        int bedLength = flowerbed.length;

        for (int i = 0; i < bedLength; i++) {
            if (flowerbed[i] == 0) {
                int prevPlot = (i == 0) ? 0 : flowerbed[i - 1];
                int nextPlot = (i == bedLength - 1) ? 0 : flowerbed[i + 1];

                if (prevPlot == 0 && nextPlot == 0) {
                    flowerbed[i] = 1;
                    flowersPlanted++;
                    i++;
                }
            }

            if (flowersPlanted >= n) {
                return true;
            }
        }

        return flowersPlanted >= n;
    }
}
