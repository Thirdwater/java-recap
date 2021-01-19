class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        assert nums.length > 1;
        
        int[] products_before = new int[nums.length];
        int[] products_after = new int[nums.length];
        int[] products_except = new int[nums.length];
        
        products_before[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            products_before[i] = products_before[i - 1] * nums[i - 1];
        }
        
        products_after[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            products_after[i] = products_after[i + 1] * nums[i + 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            products_except[i] = products_before[i] * products_after[i];
        }
        
        return products_except;
    }
    
}