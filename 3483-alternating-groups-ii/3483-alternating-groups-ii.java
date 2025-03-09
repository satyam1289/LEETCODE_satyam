class Solution {
    public int numberOfAlternatingGroups(int[] arr, int size) {
        int count = 0;
        int start = 0;
        int length = arr.length;

        for(int end = 1; end < (length + size - 1); end++){
            if(arr[end % length] == arr[(end - 1) % length]){
                start = end;
            }
            if(end - start + 1 == size){
                count++;
                start++;
            }
        }
        return count;
    }
}
