import java.util.Deque;
import java.util.ArrayDeque;

class Solution {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        // Length is at least 2
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.addFirst(current);
            } else {
                // Closing parentheses
                if (stack.size() == 0) {
                    return false;
                }
                // Have at least 1 in the stack
                char previous = stack.peekFirst();
                if ((previous == '(' && current == ')') ||
                    (previous == '[' && current == ']') ||
                    (previous == '{' && current == '}')) {
                    stack.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

}
