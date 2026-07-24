class Solution {
    private int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Remove all land connected to the boundary
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        // Count remaining land cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0) {
            return;
        }

        // Mark boundary-connected land as water
        grid[r][c] = 0;

        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
