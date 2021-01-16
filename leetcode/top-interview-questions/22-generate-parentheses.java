import java.util.List;
import java.util.ArrayList;

class Solution {
    
    public List<String> generateParenthesis(int n) {
        assert 1 <= n && n <= 8;
        List<String> list = new ArrayList<String>();
        this.generateAux(list, "", n, n);
        return list;
    }
    
    private void generateAux(List<String> list, String current, int remaining_open, int remaining_close) {
        if (current.equals("") && remaining_open > 0) {
            this.generateAux(list, "(", remaining_open - 1, remaining_close);
            return;
        }
        if (remaining_open == 1 && remaining_close == 1) {
            list.add(current + "()");
            return;
        }
        if (remaining_open == 0) {
            list.add(current + ")".repeat(remaining_close));
            return;
        }
        if (remaining_open == remaining_close) {
            this.generateAux(list, current + "(", remaining_open - 1, remaining_close);
            return;
        }
        this.generateAux(list, current + "(", remaining_open - 1, remaining_close);
        this.generateAux(list, current + ")", remaining_open, remaining_close - 1);
    }
    
}