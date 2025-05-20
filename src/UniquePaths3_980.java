import java.util.Arrays;

public class UniquePaths3_980 {
    int n, m;
    int[][] grid;
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        int numberOfEmptySquare = 0, startRow = 0, startCol = 0;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    numberOfEmptySquare++;
                }else if(grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                    numberOfEmptySquare++;
                }
            }
        }
        int numberOfWalk = dfs(startRow, startCol, numberOfEmptySquare, visited);
        return numberOfWalk;
    }

    private int dfs(int r, int c, int remainingEmptySquare ,int[][] visited){
        if(r < 0 || c < 0 || r == n || c == m || grid[r][c] == -1 || visited[r][c] == 1) return 0;

        if(grid[r][c] == 2 && remainingEmptySquare == 0) return 1;
        if(grid[r][c] == 2) return 0;
        visited[r][c] = 1;
        remainingEmptySquare--;
        int goTop = dfs(r-1, c, remainingEmptySquare, visited);
        int goRight = dfs(r, c+1, remainingEmptySquare, visited);
        int goBottom = dfs(r+1, c, remainingEmptySquare, visited);
        int goLeft = dfs(r, c-1, remainingEmptySquare, visited);
        visited[r][c] = 0;
        return goTop + goRight + goBottom + goLeft;
    }

    public static void main(String[] args) {
        UniquePaths3_980 uniquePaths3 = new UniquePaths3_980();
        System.out.println("\n"+uniquePaths3.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
    }
}
