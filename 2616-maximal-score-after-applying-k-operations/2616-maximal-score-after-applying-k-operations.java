class Solution {
    public long maxKelements(int[] nums, int k) {
     PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
      for(int i :nums) pq.offer(i);
    
      long score=0;
      while(k-->0){
        int f=pq.poll();
        score=score+f;
        f=(int)Math.ceil(f/3.0);
        pq.offer(f);
      } 
      return score;
    }
}