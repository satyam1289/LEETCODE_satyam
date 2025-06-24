class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> found = new ArrayList<>();

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]== key){
                found.add(i);
            }
        }
        for(int i=0;i<nums.length ; i++){
            for(int j=0 ;j<found.size() ; j++){
                if(Math.abs(i-found.get(j))<= k){
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }
}