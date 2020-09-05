import java.util.Scanner;

public class Solution {

    public static int B;  // breadth
    public static int H;  // height
    public static boolean flag;  // is a valid parallelogram

    static {
        try (Scanner scanner = new Scanner(System.in)) {
            B = scanner.nextInt();
            scanner.nextLine();
            H = scanner.nextInt();
            assert -100 <= B && B <= 100;
            assert -100 <= H && H <= 100;

            flag = B > 0 && H > 0;
            if (!flag) {
                /*
                 * Very awkward; specification is weird.
                 */
                System.out.println("java.lang.Exception: Breadth and height must be positive");
            }
        }
    }

    /*
     * Fixed by problem specification.
     */
    public static void main (String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }

}
