import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {

    private enum Step {MOVE_HEAD, MOVE_TAIL};

    public int lengthOfLongestSubstring(String s) {
        // O(n)
        // Worst-case head and tail go through the whole array once each.
        /*
         * Sliding start and end windows:
         *  a Whenever the head or tail moves, update the (char, index) pairs
         *    in the current substring
         *  b Whenever there's a duplicate, move the head to 1 + the index of
         *    the earlier duplicate
         *  c Whenever the head moves, move the tail to 1 + head index +
         *    longestLength
         *  d Whenever the tail moves, check or longestLength update
         *  e Stop when the head is too far down for the longestLength
         *
         *  first d
         *  while (e):
         *      a
         *      if (b):
         *          c
         *      else:
         *          d
         */
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int head = 0;
        int tail = 0;
        charIndexMap.put(s.charAt(head), head);
        int longestLength = 1;
        int firstDuplicateIndex = 0;
        Step nextStep = Step.MOVE_TAIL;
        while (head < s.length() - longestLength && tail <= s.length()) {
            switch (nextStep) {
                case MOVE_TAIL:
                    tail++;
                    char tailChar = s.charAt(tail);
                    boolean duplicated = charIndexMap.containsKey(tailChar);
                    if (duplicated) {
                        firstDuplicateIndex = charIndexMap.get(tailChar);
                    }
                    charIndexMap.put(tailChar, tail);
                    if (duplicated) {
                        nextStep = Step.MOVE_HEAD;
                    } else {
                        int length = tail - head + 1;
                        longestLength = Math.max(length, longestLength);
                        nextStep = Step.MOVE_TAIL;
                    }
                    break;
                case MOVE_HEAD:
                    char headChar = s.charAt(head);
                    charIndexMap.remove(headChar, head);
                    head++;
                    if (head <= firstDuplicateIndex) {
                        nextStep = Step.MOVE_HEAD;
                    } else {
                        nextStep = Step.MOVE_TAIL;
                    }
                    break;
            }
        }
        return longestLength;
    }

    public int bruteForcelengthOfLongestSubstring(String s) {
        // O(n^3)
        int longestLength = 0;
        for (int start = 0; start < s.length() - longestLength; start++) {
            for (int end = start + 1 + longestLength; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                Set<Character> characters = new HashSet<Character>();
                boolean hasDuplicates = false;
                for (int i = 0; i < substring.length(); i++) {
                    char c = substring.charAt(i);
                    if (characters.contains(c)) {
                        hasDuplicates = true;
                        break;
                    }
                    characters.add(c);
                }
                if (hasDuplicates) {
                    continue;
                } else {
                    longestLength = Math.max(longestLength, substring.length());
                }
            }
        }
        return longestLength;
    }

}
