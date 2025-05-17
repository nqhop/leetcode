import java.util.Arrays;

public class CherryPickup_741 {
    private int[][] grid;
    private int n;
    private int cherries = 0;
    private int[][] trackingRoad;


    // error in finding 2 optimal path
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        int[][] visited = new int[n][n];
        trackingRoad = new int[n][n];

        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }

        dfs(0, 0, 0, visited);
        if(cherries == 0) return 0;
        int result = cherries;
        cherries = 0;
        getCherriesFromGrid();

        System.out.println("=======" + result);
        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }
        dfs(0, 0, 0, visited);
        result += cherries;
        return result;
    }

    private void dfs(int row, int col, int collected, int[][] visited) {
        if(grid[row][col] == 1) collected++;
        visited[row][col] = 1;

//        System.out.println();
//        for(int[] r: visited){
//            System.out.println(Arrays.toString(r));
//        }
//        System.out.println();

        if(row == n - 1 && col == n - 1) {
            if(cherries < collected) {
                cherries = collected;
                for(int i = 0; i < n; i++)
                    trackingRoad[i] = visited[i].clone();
            }
            visited[row][col] = 0;
        };

        // go right
        if(col < n - 1 && grid[row][col + 1] != -1) dfs(row, col + 1, collected, visited);
        // go down
        if(row < n - 1 && grid[row + 1][col] != -1) dfs(row + 1, col, collected, visited);
        visited[row][col] = 0;
    }

    private void getCherriesFromGrid() {
        int row = 0, col = 0;
        while(row < n && col < n) {
            grid[row][col] = 0;
            if(row < n - 1 && trackingRoad[row + 1][col] == 1) row++;
            else col++;
        }
    }

    // Correct but Time Limit Exceeded
    public int cherryPickup2(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }
        dfs2(0, 0, 0, 0, 0);
        return cherries;
    }

    private void dfs2(int row1, int col1, int row2, int col2, int collected) {

        boolean isDiffrentLocation = row1 != row2 || col1 != col2;
        if(grid[row1][col1] == 1) collected++;
        if(isDiffrentLocation && grid[row2][col2] == 1) collected++;

        if(row1 == n - 1 && col1 == n - 1) {
            if(cherries < collected) {
                cherries = collected;
            }
        };

        int nextRow1 = findNextRow(row1, col1);
        int nextRow2 = findNextRow(row2, col2);
        int nextCol1 = findNextCol(row1, col1);
        int nextCol2 = findNextCol(row2, col2);

        if(nextRow1 != -1){
            if(nextRow2 != -1) dfs2(nextRow1, col1, nextRow2, col2, collected);
            if(nextCol2 != -1) dfs2(nextRow1, col1, row2, nextCol2, collected);
        }

        if(nextCol1 != -1){
            if(nextRow2 != -1) dfs2(row1, nextCol1, nextRow2, col2, collected);
            if(nextCol2 != -1) dfs2(row1, nextCol1, row2, nextCol2, collected);
        }
    }

    private int findNextRow(int row, int col) {
        if(row == n - 1 || grid[row + 1][col] == -1) return -1;
        return row + 1;
    }

    private int findNextCol(int row, int col) {
        if(col == n - 1 || grid[row][col + 1] == -1) return -1;
        return col + 1;
    }



    Integer[][][] dp;
    private int cherryPickup3(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.dp = new Integer[n][n][n];
        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }

        int result = Math.max(0, dfs3(0, 0, 0));
                printDP(dp);
        return result;
    }

    private int dfs3(int r1, int c1, int r2){
        // r1 + c1 = r2 + c2
        int c2 = r1 + c1 - r2;
        if(r1 == n || c1 == n || r2 == n || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;

        if(r1 == n - 1 && c1 == n - 1) return grid[r1][c1];

        if(dp[r1][c1][c2] != null) return dp[r1][c1][c2];

        int cherries = grid[r1][c1];
        if(r1 != r2 || c1 != c2) cherries += grid[r2][c2];

        int max = Math.max(
                Math.max(dfs3(r1 + 1, c1, r2 + 1), dfs3(r1, c1 + 1, r2)),
                Math.max(dfs3(r1 + 1, c1, r2), dfs3(r1, c1 + 1, r2 + 1))
        );

        cherries += max;
        dp[r1][c1][c2] = cherries;
        return cherries;
    }

    public void printDP(Integer[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    System.out.print((dp[i][j][k] != null ? dp[i][j][k] : "null") + " ");
                }
                System.out.println();
            }
            System.out.println(); // Separate layers
        }
    }


    public static void main(String[] args) {
        CherryPickup_741 cp = new CherryPickup_741();
//        System.out.println(cp.cherryPickup(new int[][]{{0,1,-1},{1,0,-1},{1,1,1}}));
//        System.out.println(cp.cherryPickup2(new int[][]{{1,1,-1},{1,-1,1},{-1,1,1}}));
//        System.out.println(cp.cherryPickup(new int[][]{{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}}));
//        System.out.println(cp.cherryPickup2(new int[][]{{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}}));
//        System.out.println(cp.cherryPickup2(new int[][]{{1, 1, 0, 0},{0, 1, 0, 1},{1, 1, 0, 0},{0, 1, 1, 1}}));
//        System.out.println(cp.cherryPickup2(new int[][]{{0,0},{-1,1}}));
//        System.out.println(cp.cherryPickup2(new int[][]{{1,1,1,1,-1,-1,-1,1,0,0},{1,0,0,0,1,0,0,0,1,0},{0,0,1,1,1,1,0,1,1,1},{1,1,0,1,1,1,0,-1,1,1},{0,0,0,0,1,-1,0,0,1,-1},{1,0,1,1,1,0,0,-1,1,0},{1,1,0,1,0,0,1,0,1,-1},{1,-1,0,1,0,0,0,1,-1,1},{1,0,-1,0,-1,0,0,1,0,0},{0,0,-1,0,1,0,1,0,0,1}}));

        System.out.println(cp.cherryPickup3(new int[][]{{1, 1, 0, 0},{0, 1, 0, 1},{1, 1, 0, 0},{0, 1, 1, 1}}));
    }
}

/*
[1, 1, 1, 1, 0, 0, 0]
[0, 0, 0, 1, 0, 0, 0]
[0, 0, 0, 1, 0, 0, 1]
[1, 0, 0, 1, 0, 0, 0]
[0, 0, 0, 1, 0, 0, 0]
[0, 0, 0, 1, 0, 0, 0]
[0, 0, 0, 1, 1, 1, 1]


[1, 1, 0, 0]
[0, 1, 0, 1]
[1, 1, 0, 0]
[0, 1, 1, 1]

[0, 0]
[-1, 1]

[ 1,  1,  1,  1, -1, -1, -1,  1,  0,  0]
[ 1,  0,  0,  0,  1,  0,  0,  0,  1,  0]
[ 0,  0,  1,  1,  1,  1,  0,  1,  1,  1]
[ 1,  1,  0,  1,  1,  1,  0, -1,  1,  1]
[ 0,  0,  0,  0,  1, -1,  0,  0,  1, -1]
[ 1,  0,  1,  1,  1,  0,  0, -1,  1,  0]
[ 1,  1,  0,  1,  0,  0,  1,  0,  1, -1]
[ 1, -1,  0,  1,  0,  0,  0,  1, -1,  1]
[ 1,  0, -1,  0, -1,  0,  0,  1,  0,  0]
[ 0,  0, -1,  0,  1,  0,  1,  0,  0,  1]

 */