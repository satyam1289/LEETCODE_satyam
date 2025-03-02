class Solution {
    public int[][] mergeArrays(int[][] arr1, int[][] arr2) {
        int x = 0, y = 0;
        List<int[]> mergedList = new ArrayList<>();
        
        while (x < arr1.length && y < arr2.length) {
            if (arr1[x][0] == arr2[y][0]) {
                mergedList.add(new int[]{arr1[x][0], arr1[x][1] + arr2[y][1]});
                x++;
                y++;
            } else if (arr1[x][0] < arr2[y][0]) {
                mergedList.add(arr1[x]);
                x++;
            } else {
                mergedList.add(arr2[y]);
                y++;
            }
        }
        
        while (x < arr1.length) {
            mergedList.add(arr1[x]);
            x++;
        }
        
        while (y < arr2.length) {
            mergedList.add(arr2[y]);
            y++;
        }
        
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
