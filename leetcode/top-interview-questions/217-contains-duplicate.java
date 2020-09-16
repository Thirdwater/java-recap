import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num: nums) {
            if (elements.contains(num)) {
                return true;
            }
            elements.add(num);
        }
        return false;
    }
}
