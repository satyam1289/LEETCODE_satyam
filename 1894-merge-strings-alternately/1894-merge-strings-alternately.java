class Solution {
    public String mergeAlternately(String firstWord, String secondWord) {
        StringBuilder mergedString = new StringBuilder();
        int firstIndex = 0, secondIndex = 0;

        while (firstIndex < firstWord.length() && secondIndex < secondWord.length()) {
            mergedString.append(firstWord.charAt(firstIndex));
            mergedString.append(secondWord.charAt(secondIndex));
            firstIndex++;
            secondIndex++;
        }

        while (secondIndex < secondWord.length()) {
            mergedString.append(secondWord.charAt(secondIndex));
            secondIndex++;
        }

        while (firstIndex < firstWord.length()) {
            mergedString.append(firstWord.charAt(firstIndex));
            firstIndex++;
        }

        return mergedString.toString();
    }
}
