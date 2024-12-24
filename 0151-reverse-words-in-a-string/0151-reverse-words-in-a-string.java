public class Solution {

    public String reverseWords(String str) {
        if (str == null) return null;

        char[] chars = str.toCharArray();
        int length = chars.length;

        reverse(chars, 0, length - 1);
        reverseEachWord(chars, length);
        return cleanSpaces(chars, length);
    }

    void reverseEachWord(char[] chars, int length) {
        int start = 0, end = 0;

        while (start < length) {
            while (start < end || (start < length && chars[start] == ' ')) start++;
            while (end < start || (end < length && chars[end] != ' ')) end++;
            reverse(chars, start, end - 1);
        }
    }

    String cleanSpaces(char[] chars, int length) {
        int index = 0, pointer = 0;

        while (pointer < length) {
            while (pointer < length && chars[pointer] == ' ') pointer++;
            while (pointer < length && chars[pointer] != ' ') chars[index++] = chars[pointer++];
            while (pointer < length && chars[pointer] == ' ') pointer++;
            if (pointer < length) chars[index++] = ' ';
        }

        return new String(chars).substring(0, index);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
