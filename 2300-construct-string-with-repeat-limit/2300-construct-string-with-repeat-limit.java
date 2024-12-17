class Solution {  

    public String repeatLimitedString(String s, int repeatLimit) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();

       
        int[] arr=new int[26];
        for(int i=0; i<n; i++){
            arr[s.charAt(i)-'a']++;
        }

        
        for(int i=25; i>=0; i--){ 
            if(arr[i]==0) continue;
            
            int curr=Math.min(arr[i], repeatLimit);
            arr[i]-=curr;
            while(curr>0){ 
                sb.append( (char)('a'+i) );
                curr--;
            }                        

          
            if(arr[i]!=0){
                for(int j=i-1; j>=0; j--){ 
                    if(arr[j]==0) continue;
                    sb.append( (char)('a'+j) );                  
                    arr[j]--;
                    i++;
                    break;
                }                
            }            
        }
       
        return sb.toString();  
    }


}