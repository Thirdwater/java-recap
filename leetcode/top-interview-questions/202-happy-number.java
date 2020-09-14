import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {

    private static Map<Integer, Integer> square = new HashMap<>();

    static {
        square.put(0, 0);
        square.put(1, 1);
        square.put(2, 4);
        square.put(3, 9);
        square.put(4, 16);
        square.put(5, 25);
        square.put(6, 36);
        square.put(7, 49);
        square.put(8, 64);
        square.put(9, 81);
    };

    public boolean isHappy(int n) {
        Set<Integer> sumHistory = new HashSet<>();
        int result = sumOfDigitsSquared(n);
        while (result != 1 && !sumHistory.contains(result)) {
            sumHistory.add(result);
            result = sumOfDigitsSquared(result);
        }
        return result == 1;
    }

    private int sumOfDigitsSquared(int n) {
        int sum = 0;
        while (n != 0) {
            sum += square.get(n % 10);
            n /= 10;
        }
        return sum;
    }
}
