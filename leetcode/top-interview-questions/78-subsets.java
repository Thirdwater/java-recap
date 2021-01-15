import java.util.List;
import java.util.ArrayList;

class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        assert 1 <= size && size <= 10;
        int power_size = (int) Math.pow(2, size);
        List<List<Integer>> powerset = new ArrayList<List<Integer>>(power_size);
        
        String flag_format = "%" + size + "s";
        for (int i = 0; i < power_size; i++) {
            String flag = Integer.toString(i, 2);
            flag = String.format(flag_format, flag);
            List<Integer> set = new ArrayList<Integer>();
            for (int j = flag.length() - 1; j >= 0; j--) {
                char element_flag = flag.charAt(j);
                boolean pick_element = element_flag == '1';
                int element_index = size - j - 1;
                if (pick_element) {
                    set.add(nums[element_index]);
                }
            }
            powerset.add(set);
        }
        
        return powerset;
    }
    
}