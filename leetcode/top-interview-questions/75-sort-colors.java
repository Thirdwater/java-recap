class Solution {
    
    public void sortColors(int[] nums) {
        assert 1 <= nums.length && nums.length <= 300;
        int[] num_colours = new int[3];
        for (int colour = 0; colour < 3; colour++) {
            num_colours[colour] = 0;
        }
        
        for (int num : nums) {
            num_colours[num] += 1;
        }
        
        int head = 0;
        for (int colour = 0; colour < 3; colour++) {
            for (int i = 0; i < num_colours[colour]; i++) {
                nums[head] = colour;
                head += 1;
            }
        }
    }
    
}