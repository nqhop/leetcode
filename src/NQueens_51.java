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

    public static void main(String[] args) {
        new NQueens_51().solveNQueens(5);
    }
}
