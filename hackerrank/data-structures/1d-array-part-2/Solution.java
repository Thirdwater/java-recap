import java.util.Scanner;

public class Solution {

    public static boolean canWin (int[] gameBoard, int leap) {
        return Solution.recursiveCanWin(gameBoard, leap, 0);
    }

    private static boolean recursiveCanWin (int[] gameBoard, int leap, int position) {
        // Base Case
        boolean isAtEnd = position == gameBoard.length - 1;
        boolean canLeapToEnd = position + leap >= gameBoard.length;
        if (isAtEnd || canLeapToEnd) {
            return true;
        }

        boolean canMoveForward = gameBoard[position + 1] == 0;
        boolean canMoveBackward = position != 0 && gameBoard[position - 1] == 0;
        boolean canLeap = gameBoard[position + leap] == 0;

        // This marks the position as "visited" to prevent infinite recursion
        // from chains of moving backward.
        // Check this against some cases where we have to move backward
        // fully, then again?
        gameBoard[position] = 1;
        boolean winByForward = false;
        boolean winByBackward = false;
        boolean winByLeap = false;
        if (canMoveForward) {
            winByForward = Solution.recursiveCanWin(gameBoard, leap, position + 1);
        }
        if (canMoveBackward) {
            winByBackward = Solution.recursiveCanWin(gameBoard, leap, position - 1);
        }
        if (canLeap) {
            winByLeap = Solution.recursiveCanWin(gameBoard, leap, position + leap);
        }
        return winByForward || winByBackward || winByLeap;
    }

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numQueries = scanner.nextInt();
            assert 1 <= numQueries && numQueries <= 5_000;

            for (int query = 0; query < numQueries; query++) {
                int gameSize = scanner.nextInt();
                int leap = scanner.nextInt();
                assert 2 <= gameSize && gameSize <= 100;
                assert 0 <= leap && leap <= 100;

                int[] gameBoard = new int[gameSize];
                for (int cell = 0; cell < gameSize; cell++) {
                    gameBoard[cell] = scanner.nextInt();
                }
                assert gameBoard[0] == 0;

                boolean isWinnable = Solution.canWin(gameBoard, leap);
                System.out.println(isWinnable? "YES": "NO");
            }
        }
    }

}
