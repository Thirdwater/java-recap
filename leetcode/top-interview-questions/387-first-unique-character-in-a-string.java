import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        List<Integer> uniqueIndices = new LinkedList<>();
        // Only stores the index of first occurences
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charIndexMap.containsKey(currentChar)) {
                int nonUniqueIndex = charIndexMap.get(currentChar);
                uniqueIndices.remove(Integer.valueOf(nonUniqueIndex));
            } else {
                charIndexMap.put(currentChar, i);
                uniqueIndices.add(i);
            }
        }
        if (uniqueIndices.size() > 0) {
            return uniqueIndices.get(0);
        }
        return -1;
    }
}
