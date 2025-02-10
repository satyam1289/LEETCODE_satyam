class Solution {
    public String clearDigits(String input) {
        Stack<Character> charStack = new Stack<>();
        
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch) && !charStack.isEmpty()) {
                charStack.pop();
            } else {
                charStack.push(ch);
            }
        }

        StringBuilder output = new StringBuilder();
        while (!charStack.isEmpty()) {
            output.append(charStack.pop());
        }
        
        return output.reverse().toString();
    }
}
