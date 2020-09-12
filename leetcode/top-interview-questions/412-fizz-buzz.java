import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(15);
        for (int i = 0; i < n; i++) {
            int num = i + 1;
            String numString = String.valueOf(num);
            boolean divBy3 = num % 3 == 0;
            boolean divBy5 = num % 5 == 0;
            if (divBy3 || divBy5) {
                if (divBy3 && divBy5) {
                    numString = "FizzBuzz";
                } else if (divBy3) {
                    numString = "Fizz";
                } else {
                    numString = "Buzz";
                }
            }
            list.add(numString);
        }
        return list;
    }
}
