class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       int p=0,e=arr.length-1;
       while(p<e){
        int mid=p+(e-p)/2;
        if(arr[mid]<arr[mid+1]) p=mid+1;
        else e=mid;
       }
       return p;
    }
}