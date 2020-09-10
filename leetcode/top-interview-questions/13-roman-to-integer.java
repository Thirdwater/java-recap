class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean hasNext = i < s.length() - 1;
            char nextChar = hasNext? s.charAt(i + 1): ' ';
            switch (s.charAt(i)) {
                case 'I':
                    if (hasNext && nextChar == 'V') {
                        sum += 4;
                        i++;
                    } else if (hasNext && nextChar == 'X') {
                        sum += 9;
                        i++;
                    } else {
                        sum += 1;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if (hasNext && nextChar == 'L') {
                        sum += 40;
                        i++;
                    } else if (hasNext && nextChar == 'C') {
                        sum += 90;
                        i++;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (hasNext && nextChar == 'D') {
                        sum += 400;
                        i++;
                    } else if (hasNext && nextChar == 'M') {
                        sum += 900;
                        i++;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }
}
