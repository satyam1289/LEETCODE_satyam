class Solution {
    public String removeOccurrences(String inputStr, String target) {
        while (inputStr.contains(target)) {
            inputStr = inputStr.replaceFirst(target, "");
        }
        return inputStr;
    }
}
