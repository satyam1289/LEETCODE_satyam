class Solution {  

    public String repeatLimitedString(String s, int repeatLimit) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();

        // Step 1: Frequency count for each character
        int[] arr=new int[26];
        for(int i=0; i<n; i++){
            arr[s.charAt(i)-'a']++;
        }

        // Step 2: Iterate from larger characters to smaller characters
        for(int i=25; i>=0; i--){ // i: One pointer
            if(arr[i]==0) continue;
            
            int curr=Math.min(arr[i], repeatLimit);
            arr[i]-=curr;
            while(curr>0){ 
                sb.append( (char)('a'+i) );
                curr--;
            }                        

            // Step 3: Handle remaining occurrences by inserting smaller character
            if(arr[i]!=0){
                for(int j=i-1; j>=0; j--){ // j: Another pointer
                    if(arr[j]==0) continue;
                    sb.append( (char)('a'+j) ); // Adding only one character                   
                    arr[j]--;
                    i++;
                    break;
                }                
            }            
        }
       
        return sb.toString();  
    }


}