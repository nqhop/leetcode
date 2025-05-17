import java.util.Arrays;

public class MinimumPathSum_64 {
    private int[][] grid;
    private int n, m, sum;

    // Time Limit Exceeded
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.sum = Integer.MAX_VALUE;
        dfs(0, 0, grid[0][0]);
        return sum;
    }

    private void dfs(int r, int c, int s) {
        if(r == m - 1 && c == n - 1) {
            sum = Math.min(sum, s);
            return;
        }
        if(r + 1 < m) dfs(r + 1, c, s + grid[r + 1][c]);
        if(c + 1 < n) dfs(r, c + 1, s + grid[r][c + 1]);
    }

    static int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return minSumPathUtil(m - 1, n - 1, grid, dp);
    }

    static int minSumPathUtil(int i, int j, int[][] matrix, int[][] dp){
        if(i == 0 && j == 0) return matrix[0][0];

        //(int)1e9  ==  (int)(1 * 10^9)  ==  1000000000
        if(i < 0 || j < 0) return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + minSumPathUtil(i - 1, j, matrix, dp);
        int left = matrix[i][j] + minSumPathUtil(i, j - 1, matrix, dp);

        return dp[i][j] = Math.min(up, left);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum_64().minPathSum(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}}));
        System.out.println(minPathSum2(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}}));
    }
}
