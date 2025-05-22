import java.util.ArrayList;
import java.util.List;

public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                if(!checkDigitsSubBox(i * 3, j * 3, board))
                    return false;
            }

//        for(int i = 0 ; i < 9; i++){
//            if(!checkDigitHorizontal(i, board) || !checkDigitsVertical(i, board)) return false;
//        }
//
        for(int i = 0 ; i < 9; i++){
            if(!checkDigitHorizontalandVertical(i, board)) return false;
        }

        return true;
    }

    public boolean checkDigitsSubBox(int baseRow, int baseCol, char[][] board) {
//        int baseRow = (row / 3) * 3,  = (col / 3) * 3;
        List<Character> digits = new ArrayList<>();
        for(int i = baseRow; i < baseRow + 3; i++) {
            for(int j = baseCol; j < baseCol + 3; j++) {
                if(board[i][j] != '.' && digits.contains((Character) board[i][j])) return false;
                if(board[i][j] != '.') digits.add((Character) board[i][j]);
            }
        }
        return true;
    }

    public boolean checkDigitsVertical(int col, char[][] board) {
        List<Character> digits = new ArrayList<>();
        for(int row = 0; row < 9; row++) {
            if(board[row][col] != '.' && digits.contains((Character) board[row][col])) return false;
            if(board[row][col] != '.') digits.add((Character) board[row][col]);
        }
        return true;
    }

    public boolean checkDigitHorizontal(int row, char[][] board) {
        List<Character> digits = new ArrayList<>();
        for(int col = 0; col < 9; col++) {
            if(board[row][col] != '.' && digits.contains((Character) board[row][col])) return false;
            if(board[row][col] != '.') digits.add((Character) board[row][col]);
        }
        return true;
    }

    public boolean checkDigitHorizontalandVertical(int i, char[][] board) {
        List<Character> digitHorizontal = new ArrayList<>();
        List<Character> digitVertical = new ArrayList<>();
        for(int j = 0; j < 9; j++) {
            if(board[i][j] != '.' && digitHorizontal.contains((Character) board[i][j])) return false;
            if(board[j][i] != '.' && digitVertical.contains((Character) board[j][i])) return false;
            if(board[i][j] != '.') digitHorizontal.add((Character) board[i][j]);
            if(board[j][i] != '.') digitVertical.add((Character) board[j][i]);
        }
        return true;
    }
}
