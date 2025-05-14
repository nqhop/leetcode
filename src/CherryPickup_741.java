import java.util.Arrays;

public class CherryPickup_741 {
    private int[][] grid;
    private int n;
    private int cherries = 0;
    private int[][] trackingRoad;

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

    public static void main(String[] args) {
        CherryPickup_741 cp = new CherryPickup_741();
//        System.out.println(cp.cherryPickup(new int[][]{{0,1,-1},{1,0,-1},{1,1,1}}));
//        System.out.println(cp.cherryPickup(new int[][]{{1,1,-1},{1,-1,1},{-1,1,1}}));
        System.out.println(cp.cherryPickup(new int[][]{{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}}));
    }
}
