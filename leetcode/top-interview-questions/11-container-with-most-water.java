class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int startHeight = height[start];
            int endHeight = height[end];
            int w = end - start;
            int h = Math.min(startHeight, endHeight);
            int newArea = w * h;
            area = Math.max(area, newArea);

            if (startHeight <= endHeight) {
                start++;
            } else {
                end--;
            }
        }
        return area;
    }
}
