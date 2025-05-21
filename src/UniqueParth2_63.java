public class UniqueParth2_63 {

    static int[][] obstacleGrid;
    public static int uniquePathsWithObstacles(int[][] obstacleGrid0) {
        obstacleGrid = obstacleGrid0;
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        return dfs(row - 1, col - 1, dp);
    }

    private static int dfs(int r, int c, int[][] dp){
        if(r < 0 || c < 0 || obstacleGrid[r][c] == 1) return 0;
        if(r == 0 && c == 0) return 1;
        if(dp[r][c] != 0) return dp[r][c];
        return dfs(r - 1, c, dp) + dfs(r, c - 1, dp);
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
