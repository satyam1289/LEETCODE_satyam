class Solution {
    public long countSubarrays(int[] nums, long k) {
        long r=0;
        long t=0;
        for(int i=0,j=0;j<nums.length;j++){
            t+=nums[j];
            while(i<=j && t*(j-i+1)>=k){
                t-=nums[i];
                i++;
            }
            r+=(j-i+1);
        }
        return r;
    }
}