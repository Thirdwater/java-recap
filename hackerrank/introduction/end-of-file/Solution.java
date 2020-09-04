import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int currentLine = 1;
            while (scanner.hasNext()) {
                String currentText = scanner.nextLine();
                System.out.format("%d %s%n", currentLine, currentText);
                currentLine++;
            }
        }
    }

}
