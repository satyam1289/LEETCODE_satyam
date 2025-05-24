class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
       List<Integer>list=new ArrayList<>();
       int m=0;
       for(String p:words){
        if(p.contains(Character.toString(x))){
            list.add(m);
        }m++;
       } return list;
    }
}