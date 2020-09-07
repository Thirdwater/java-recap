import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String input = scanner.nextLine();
                System.out.println(Solution.isBalanced(input));
            }
        }
    }

    private static boolean isBalanced (String parentheses) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < parentheses.length(); i++) {
            char current = parentheses.charAt(i);
            if (Solution.isOpenParenthesis(current)) {
                stack.addFirst(current);
            } else if (Solution.isClosingParenthesis(current)) {
                if (stack.size() == 0) {
                    return false;
                }
                char previous = stack.peekFirst();
                if (Solution.isMatchingParentheses(previous, current)) {
                    stack.removeFirst();
                } else {
                    return false;
                }
            } else {
                // Invalid character
                return false;
            }
        }
        return stack.size() == 0;
    }

    private static boolean isOpenParenthesis (char parenthesis) {
        return (parenthesis == '(' ||
                parenthesis == '[' ||
                parenthesis == '{');
    }

    private static boolean isClosingParenthesis (char parenthesis) {
        return (parenthesis == ')' ||
                parenthesis == ']' ||
                parenthesis == '}');
    }

    private static boolean isMatchingParentheses (char left, char right) {
        return ((left == '(' && right == ')') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}'));
    }

}
