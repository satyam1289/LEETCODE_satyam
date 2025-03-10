class Solution {
    static String vowelSet = "aeiou";

    public long countOfSubstrings(String str, int limit) {
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        long totalCount = 0;
        int consonantCount = 0;
        int left = 0;
        int[] vowelArray = new int[5];
        int tempLeft = left;
        int addCount = 0;

        for (int right = 0; right < str.length(); right++) {
            char currentChar = str.charAt(right);

            if (isVowel(currentChar)) {
                vowelMap.put(currentChar, vowelMap.getOrDefault(currentChar, 0) + 1);
            } else {
                consonantCount++;
            }

            while (consonantCount > limit) {
                char removedChar = str.charAt(left++);

                if (isVowel(removedChar)) {
                    int remaining = vowelMap.get(removedChar) - 1;

                    if (remaining == 0) {
                        vowelMap.remove(removedChar);
                    } else {
                        vowelMap.put(removedChar, remaining);
                    }
                } else {
                    consonantCount--;
                }

                vowelArray = new int[5];
                tempLeft = left;
                addCount = 0;
            }

            if (consonantCount == limit && vowelMap.size() == 5) {
                while (true) {
                    char tempChar = str.charAt(tempLeft);
                    int charIndex = vowelSet.indexOf(tempChar);

                    if (charIndex == -1) {
                        totalCount++;
                        break;
                    }

                    addCount++;
                    vowelArray[charIndex]++;

                    if (vowelMap.get(tempChar) == vowelArray[charIndex]) {
                        addCount--;
                        vowelArray[charIndex]--;
                        totalCount++;
                        break;
                    }

                    tempLeft++;
                }

                totalCount += addCount;
            }
        }

        return totalCount;
    }

    private boolean isVowel(Character ch) {
        return vowelSet.indexOf(ch) > -1;
    }
}
