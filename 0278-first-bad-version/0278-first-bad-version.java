/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n==1){
            return 1;
     }
        int start=0;
        int end=n;
        int bad=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isBadVersion(mid)){
                bad=mid;
                end=mid-1;

            }else{
                start=mid+1;

            }
        }
        return bad;
    }
}