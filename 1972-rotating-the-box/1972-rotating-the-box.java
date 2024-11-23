class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        char[][] rotatedBox = new char[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                rotatedBox[i][j] = box[rows - 1 - j][i];
            }
        }

        for (int j = 0; j < rows; j++) {
            int bottom = cols - 1, top = cols - 1;
            while (bottom >= top && top >= 0) {
                if (rotatedBox[bottom][j] == '#') {
                    bottom--;
                } else if (rotatedBox[bottom][j] == '.' && rotatedBox[top][j] == '#') {
                    rotatedBox[bottom][j] = rotatedBox[top][j];
                    rotatedBox[top][j] = '.';
                    bottom--;
                } else if (rotatedBox[top][j] == '*') {
                    bottom = top - 1;
                }
                top--;
            }
        }

        return rotatedBox;
    }
}
