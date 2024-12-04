class Solution {
    public int fib(int n) {
        if(n == 1){
            return 1;
        }
        int fir = 0;
        int sec = 1;
        int sum = 0;
        for(int i = 1;i<n;i++){
            sum = fir + sec;
            fir = sec;
            sec = sum;
        }
        return sum;
    }
}