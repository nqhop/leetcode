import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuSolver_37 {

    List[] subBoxEmptyDigits;
    public void solveSudoku(char[][] board) {

        subBoxEmptyDigits = IntStream.range(0, 9)
                .mapToObj(i -> new ArrayList<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9')))
                .toArray(List[]::new);

        countEmptyCells(board);


        System.out.println(2 / 3);
        System.out.println(6 / 3);
    }

    public void countEmptyCells(char[][] board) {
        int rowBox, colBox;
        for(int i = 0; i < board.length; i++) {
            rowBox = (i / 3) * 3;
            for(int j = 0; j < board[0].length; j++) {
                colBox = j / 3;
                if(board[i][j] != '.') {
                    subBoxEmptyDigits[rowBox + colBox].remove((Character) board[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver_37 solver = new SudokuSolver_37();
        solver.solveSudoku(board);
    }
}
