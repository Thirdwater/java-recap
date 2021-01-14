class Solution {
    
    public int uniquePaths(int m, int n) {
        assert 1 <= m && m <= 100;
        assert 1 <= n && n <= 100;
        
        int[] row_paths = new int[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) {
                    row_paths[col] = 1;
                } else if (row == 0 || col == 0) {
                    row_paths[col] = 1;
                } else {
                    row_paths[col] += row_paths[col - 1];
                }
            }
        }
        int num_paths = row_paths[n - 1];
        assert num_paths <= 2_000_000_000;
        return num_paths;
    }
    
}