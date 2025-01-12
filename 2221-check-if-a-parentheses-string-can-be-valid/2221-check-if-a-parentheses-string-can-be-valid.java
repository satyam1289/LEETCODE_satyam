class Solution {
    public boolean canBeValid(String brackets, String isLocked) {
        int length = brackets.length();
        if (length % 2 != 0)
            return false;

        int minOpen = 0, maxOpen = 0;

        for (int i = 0; i < length; i++) {
            if (isLocked.charAt(i) == '1') {
                if (brackets.charAt(i) == '(') {
                    minOpen++;
                    maxOpen++;
                } else {
                    minOpen--;
                    maxOpen--;
                }
            } else {
                maxOpen++;
                minOpen--;
            }

            if (minOpen < 0) {
                minOpen += 2;
            }

            if (maxOpen < 0) {
                return false;
            }
        }

        return minOpen == 0;
    }
}
