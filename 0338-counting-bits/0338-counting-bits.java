class Solution {
    public int[] countBits(int n) {
        int [] dppp=new int[n+1];
        for(int i=1;i<=n;i++){
            dppp[i]=dppp[i>>1]+(i&1);
        }
        return dppp;

    }
}