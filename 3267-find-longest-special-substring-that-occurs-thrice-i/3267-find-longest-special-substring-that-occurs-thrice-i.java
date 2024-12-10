class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer> hm=new HashMap<>();
        int j=0;
        for(int i=0;i<s.length();){
            while(j<s.length() && s.charAt(i)==s.charAt(j)){
                j++;
            }
            hm.put(s.substring(i,j),hm.getOrDefault(s.substring(i,j),0)+1);
            i=j;
        }
        int ans=-1;
        for(String it : hm.keySet()){
            int len = it.length();
            int value = hm.get(it);
            if(len==1 && value>=3){
                ans=Math.max(ans,1);
            }
            else if(len>=2){
                if(value>=3){
                    ans=Math.max(ans,len);
                }
                else if(value==2){
                    ans=Math.max(ans,len-1);
                }
                else if(value==1 && hm.containsKey(it.substring(0,len-1))){
                    ans=Math.max(ans,len-1);
                }

                else if (len >= 3) {
                    ans = Math.max(ans, len - 2);
                }

            }
        }
        return ans;
    }
}