import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>(numRows);
        if (numRows == 0) {
            return pascalTriangle;
        }
        List<Integer> firstRow = new ArrayList<>(1);
        firstRow.add(1);
        pascalTriangle.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(0, 1);
            List<Integer> prevRow = pascalTriangle.get(i - 1);
            for (int j = 1; j < prevRow.size(); j++) {
                row.add(j, prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(i, 1);
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }
}
