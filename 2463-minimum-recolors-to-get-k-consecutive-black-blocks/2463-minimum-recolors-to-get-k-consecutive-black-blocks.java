class Solution {
    public int minimumRecolors(String str, int size) {
        int length = str.length();
        int whiteCount = 0;

        for(int left = 0; left < size; left++){
            if(str.charAt(left) == 'W'){
                whiteCount++;
            }
        }
        
        int start = 1, end = size;
        int minCount = whiteCount;

        while(start < length && end < length){       
            if(str.charAt(start - 1) == 'W'){
                whiteCount -= 1;
            }
            if(str.charAt(end) == 'W'){
                whiteCount += 1;
            }
            minCount = whiteCount < minCount ? whiteCount : minCount;
            start++; end++;
        }      

        return minCount;
    }
}
