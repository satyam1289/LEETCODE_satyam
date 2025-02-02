class Solution {
    public boolean check(int[] nums) {
        int ct=0;
        int ne=nums.length;
        for(int i=0;i<ne;i++)
            if(nums[i]>nums[(i+1)%ne]&& ++ct>1)
                return false;
                return ct<=1;
       
    }
}