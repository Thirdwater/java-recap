class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            boolean[] digitFlag = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char cell = board[row][j];
                if (cell == '.') {
                    continue;
                }
                int digit = Character.getNumericValue(cell) - 1;
                if (digitFlag[digit]) {
                    return false;
                }
                digitFlag[digit] = true;
            }
        }
        for (int col = 0; col < 9; col++) {
            boolean[] digitFlag = new boolean[9];
            for (int i = 0; i < 9; i++) {
                char cell = board[i][col];
                if (cell == '.') {
                    continue;
                }
                int digit = Character.getNumericValue(cell) - 1;
                if (digitFlag[digit]) {
                    return false;
                }
                digitFlag[digit] = true;
            }
        }
        for (int box = 0; box < 9; box++) {
            boolean[] digitFlag = new boolean[9];
            for (int k = 0; k < 9; k++) {
                int baseI = 3 * (box / 3);
                int baseJ = 3 * (box % 3);
                int i = baseI + (k / 3);
                int j = baseJ + (k % 3);
                char cell = board[i][j];
                if (cell == '.') {
                    continue;
                }
                int digit = Character.getNumericValue(cell) - 1;
                if (digitFlag[digit]) {
                    return false;
                }
                digitFlag[digit] = true;
            }
        }
        return true;
    }
}
