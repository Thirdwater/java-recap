import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        int carry = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] + carry;
            if (i == digits.length - 1) {
                digit++;
            }
            list.add(0, digit % 10);
            carry = digit > 9? 1: 0;
        }
        if (carry != 0) {
            list.add(0, carry);
        }
        int[] array = new int[list.size()];
        int i = 0;
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            array[i] = iter.next();
            i++;
        }
        return array;
    }
}
