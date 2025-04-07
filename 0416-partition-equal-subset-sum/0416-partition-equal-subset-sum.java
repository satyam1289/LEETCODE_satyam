class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum=0;
        for(int num:nums){
            totalsum +=num;
        }
        if((totalsum & 1)==1){
            return false;
        }

        int target=totalsum/2;
        boolean[]dpp=new boolean[target+1];
        dpp[0]=true;
        
        for(int num:nums){
            for (int i=target;i>=num;i--){
                dpp[i]=dpp[i]||dpp[i-num];
            }
        }
        return dpp[target];
        
            }
}