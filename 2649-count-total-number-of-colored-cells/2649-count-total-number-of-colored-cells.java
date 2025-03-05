class Solution {  
    public long coloredCells(int n) {  
        long totalCells = 0;  

        for (int i = 1; i <= n; i++) {  
            if (i == 1) {  
                totalCells = 1;  
            } else {  
                totalCells += (4 * (i - 1));  
            }  
        }  

        return totalCells;  
    }  
}  