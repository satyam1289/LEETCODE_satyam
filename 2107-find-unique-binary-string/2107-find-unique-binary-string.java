import java.util.HashSet;
import java.util.Arrays;

public class Solution { // Class name changed to Solution
    public String findDifferentBinaryString(String[] arr) {
        HashSet<String> set = new HashSet<>(Arrays.asList(arr));
        int length = arr[0].length();
        
        for (int i = 0; i < Math.pow(2, length); i++) {
            String binaryStr = convertToBinary(i);
            while (binaryStr.length() != length) {
                binaryStr = "0" + binaryStr;
            }

            if (!set.contains(binaryStr)) {
                return binaryStr;
            }
        }
        return "";
    }

    private String convertToBinary(int num) { 
        if (num == 0) {
            return "0";
        }
        String binaryStr = "";
        while (num > 0) {
            binaryStr = (num % 2 == 0 ? "0" : "1") + binaryStr;
            num /= 2;
        }
        return binaryStr;
    }
}
