class Solution {
    List<String> happyStrings = new ArrayList<>();
    
    public String getHappyString(int n, int k) {
        char[] letters = {'a', 'b', 'c'};
        generateStrings("", n, letters);
        return k > happyStrings.size() ? "" : happyStrings.get(k - 1);
    }

    private void generateStrings(String current, int n, char[] letters) {
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }
        for (char letter : letters) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != letter) {
                generateStrings(current + letter, n, letters);
            }
        }
    }
}