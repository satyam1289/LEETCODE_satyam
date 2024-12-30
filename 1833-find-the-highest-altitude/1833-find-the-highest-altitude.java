class Solution {
    public int largestAltitude(int[] gain) {
        int su=0, max=0;
        for(int i=0; i<gain.length; i++){
            su += gain[i];
            max = su>=max ? su:max;
        }
        return max;
    }
}