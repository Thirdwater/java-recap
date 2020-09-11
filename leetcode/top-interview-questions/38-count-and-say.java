class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder builder = new StringBuilder();
        String prevCount = this.countAndSay(n - 1);
        int currentNum = Character.getNumericValue(prevCount.charAt(0));
        int currentCount = 1;
        for (int i = 1; i < prevCount.length(); i++) {
            int nextNum = Character.getNumericValue(prevCount.charAt(i));
            if (nextNum == currentNum) {
                currentCount++;
            } else {
                builder.append(currentCount);
                builder.append(currentNum);
                currentNum = nextNum;
                currentCount = 1;
            }
        }
        builder.append(currentCount);
        builder.append(currentNum);
        return builder.toString();
    }
}
