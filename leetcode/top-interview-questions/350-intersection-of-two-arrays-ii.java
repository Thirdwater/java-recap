import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int newNum = nums1[i];
            if (!numCount.containsKey(newNum)) {
                numCount.put(newNum, 1);
            } else {
                int count = numCount.get(newNum);
                numCount.put(newNum, count + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            int checkNum = nums2[i];
            if (numCount.containsKey(checkNum)) {
                int count = numCount.get(checkNum);
                list.add(checkNum);
                if (count == 1) {
                    numCount.remove(checkNum);
                } else {
                    numCount.put(checkNum, count - 1);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
