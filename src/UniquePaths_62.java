public class UniquePaths_62 {
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return dfs(m - 1, n - 1, dp);
    }

    private static int dfs(int r, int c, int[][] dp){
        if(r < 0 || c < 0) return 0;
        if(r == 0 && c == 0) return 1;
        if(dp[r][c] != 0) return dp[r][c];
        return dp[r][c] = dfs(r -1, c, dp) + dfs(r, c -1, dp);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
