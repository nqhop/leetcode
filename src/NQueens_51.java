import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        for(int x = 0; x < n; x++){
            boolean newStart = false;
            List<char[]> temp = IntStream.range(0, n)
                            .mapToObj(i -> {
                                char[] row = new char[n];
                                Arrays.fill(row,'.');
                                return row;
                            })
                                    .collect(Collectors.toList());
            temp.getFirst()[x] = 'Q';
            for(int i = 1; i < n; i++){
                boolean placeQueen = false;
                for(int j = 0; j < n; j++){
                    if(checkQueen(temp, i, j)){
                        temp.get(i)[j] = 'Q';
                        placeQueen = true;
                        break;
                    }
                }
                if(!placeQueen) {
                    newStart = true;
                    break;
                };
            }
            if(newStart) continue;
            result.add(temp.stream()
                    .map(String::new)
                    .toList());
        }
        return result;
    }

    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> result = new ArrayList<>();
        List<char[]> matrix = IntStream.range(0, n)
                .mapToObj(i -> {
                    char[] row = new char[n];
                    Arrays.fill(row, '.');
                    return row;
                })
                .collect(Collectors.toList());
        findQueensMatrix(matrix, 0, 0, 0, result);
        return result;
    }

    private void findQueensMatrix(List<char[]> matrix, int i, int j, int queen, List<List<String>> result){
        if(queen == matrix.size()){
            result.add(matrix.stream()
                    .map(String::new)
                    .toList());
        }
        if(i >= matrix.size() || j >= matrix.size()) return;
        if(checkQueen(matrix, i, j)) {
            matrix.get(i)[j] = 'Q';
            findQueensMatrix(matrix, i + 1, 0, queen + 1, result);
            matrix.get(i)[j] = '.';
        }
        findQueensMatrix(matrix, i, j + 1, queen, result);
    }

    private static void print2DArray(List<char[]> matrix){
        for(char[] c : matrix){
            System.out.println(c);
        }
    }
    private static boolean checkQueen(List<char[]> matrix, int i, int j){
        int n = matrix.size();
        for(int k = 0; k < n; k++){
            if(k != j && matrix.get(i)[k] == 'Q') return false;
            if(k != i && matrix.get(k)[j] == 'Q') return false;
        }
        int k = i + 1, l = j + 1;

        while (k < n && l < n){
            if(matrix.get(k)[l] == 'Q') return false;
            k += 1; l += 1;
        }
        k = i - 1; l = j - 1;
        while (k >= 0 && l >= 0){
            if(matrix.get(k)[l] == 'Q') return false;
            k -= 1; l -= 1;
        }
        k = i - 1; l = j + 1;
        while (k >= 0 && l < n){
            if(matrix.get(k)[l] == 'Q') return false;
            k -= 1; l += 1;
        }
        k = i + 1; l = j - 1;
        while (k < n && l >= 0){
            if(matrix.get(k)[l] == 'Q') return false;
            k += 1; l -= 1;
        }
        return true;
    }





    private List<List<String>> ans = new ArrayList<>();
    private int[] col;
    private int[] dg;
    private int[] udg;
    private String[][] g;
    private int n;

    public List<List<String>> solveNQueens3(int n) {
        this.n = n;
        col = new int[n];
        dg = new int[n << 1];
        udg = new int[n << 1];
        g = new String[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], ".");
        }
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == n) {
            List<String> t = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                t.add(String.join("", g[j]));
            }
            ans.add(t);
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (col[j] + dg[i + j] + udg[n - i + j] == 0) {
                g[i][j] = "Q";
                col[j] = dg[i + j] = udg[n - i + j] = 1;
                dfs(i + 1);
                col[j] = dg[i + j] = udg[n - i + j] = 0;
                g[i][j] = ".";
            }
        }
    }
    public static void main(String[] args) {
        new NQueens_51().solveNQueens3(4);
    }
}
