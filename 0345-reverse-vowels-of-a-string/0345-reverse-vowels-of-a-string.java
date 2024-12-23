class Solution {
    public String reverseVowels(String inputString) {
        int length = inputString.length();
        char[] charArray = inputString.toCharArray();
        int forwardIndex = 0, backwardIndex = length;

        for (int x = 0; x < length; x++) {
            if (charArray[x] == 'A' || charArray[x] == 'E' || charArray[x] == 'I' || charArray[x] == 'O' || charArray[x] == 'U' || 
                charArray[x] == 'a' || charArray[x] == 'e' || charArray[x] == 'i' || charArray[x] == 'o' || charArray[x] == 'u') {
                forwardIndex = x;

                while (forwardIndex < backwardIndex) {
                    backwardIndex--;

                    if (charArray[backwardIndex] == 'A' || charArray[backwardIndex] == 'E' || charArray[backwardIndex] == 'I' || 
                        charArray[backwardIndex] == 'O' || charArray[backwardIndex] == 'U' || charArray[backwardIndex] == 'a' || 
                        charArray[backwardIndex] == 'e' || charArray[backwardIndex] == 'i' || charArray[backwardIndex] == 'o' || 
                        charArray[backwardIndex] == 'u') {
                        char temp = charArray[backwardIndex];
                        charArray[backwardIndex] = charArray[x];
                        charArray[x] = temp;
                        break;
                    }
                }
            }
        }

        String result = "";
        for (int y = 0; y < length; y++) {
            result += charArray[y];
        }
        return result;
    }
}
