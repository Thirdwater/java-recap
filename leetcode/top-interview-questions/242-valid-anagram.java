import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> frequency1 = new HashMap<>();
        Map<Character, Integer> frequency2 = new HashMap<>();
        int max = Math.max(s.length(), t.length());
        for (int i = 0; i < max; i++) {
            if (i < s.length()) {
                char c = s.charAt(i);
                if (frequency1.containsKey(c)) {
                    int incrementCount = frequency1.get(c) + 1;
                    frequency1.put(c, incrementCount);
                } else {
                    frequency1.put(c, 1);
                }
            }
            if (i < t.length()) {
                char c = t.charAt(i);
                if (frequency2.containsKey(c)) {
                    int incrementCount = frequency2.get(c) + 1;
                    frequency2.put(c, incrementCount);
                } else {
                    frequency2.put(c, 1);
                }
            }
        }
        return frequency1.equals(frequency2);
    }
}
