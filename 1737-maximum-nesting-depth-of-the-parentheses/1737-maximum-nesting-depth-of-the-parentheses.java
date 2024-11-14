class Solution {
    public int maxDepth(String str) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push('(');
            } else if(str.charAt(i) == ')'){
                stack.pop();
            }
            maxDepth = Math.max(maxDepth, stack.size());
        }
        return maxDepth;
    }
}
