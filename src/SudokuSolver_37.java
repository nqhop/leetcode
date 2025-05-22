import java.util.ArrayList;
import java.util.List;

public class SudokuSolver_37 {

    public void solveSudoku(char[][] board) {
        int emptyCells = getEmptyCells(board);
        dfs(0, 0, board, emptyCells);
    }

    private int getEmptyCells(char[][] board) {
        int emptyCells = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') emptyCells++;
            }
        }
        return emptyCells;
    }


    public void dfs(int row, int col, char[][] board, int emptyCells) {

        if(row == 8 && col == 9 && emptyCells == 0) {
            printBoard(board);
            return;
        };
        if(col == 9) {
            dfs(row + 1, 0, board, emptyCells);
            return;
        }
        if(board[row][col] != '.') {
            dfs(row, col + 1, board, emptyCells);
            return;
        }
        List<Character> listDigits = getDigitsSubBox(row, col, board);
        listDigits = checkDigitsVertical(col, listDigits, board);
        listDigits = checkDigitHorizontal(row, listDigits, board);
        for(Character digit : listDigits){
            board[row][col] = digit;
            dfs(row, col + 1, board, emptyCells - 1);
            board[row][col] = '.';
        }
    }

    public List<Character> getDigitsSubBox(int row, int col, char[][] board) {
        int baseRow = (row / 3) * 3, baseCol = (col / 3) * 3;
        List<Character> digits = new ArrayList<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        for(int i = baseRow; i < baseRow + 3; i++) {
            for(int j = baseCol; j < baseCol + 3; j++) {
                if(board[i][j] != '.') digits.remove((Character) board[i][j]);
            }
        }
        return digits;
    }

    public List<Character> checkDigitsVertical(int col, List<Character> digits, char[][] board) {
        for(int row = 0; row < 9; row++) {
            if(board[row][col] != '.') digits.remove((Character) board[row][col]);
        }
        return digits;
    }

    public List<Character> checkDigitHorizontal(int row, List<Character> digits, char[][] board) {
        for(int col = 0; col < 9; col++) {
            if(board[row][col] != '.') digits.remove((Character) board[row][col]);
        }
        return digits;
    }

    public void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver_37 solver = new SudokuSolver_37();
        solver.solveSudoku(board);
    }
}
