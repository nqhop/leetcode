import java.util.ArrayList;
import java.util.List;

public class WordSearch2_212 {
    char[][] board;
    public List<String> findWords(char[][] board, String[] w) {
        List<String> words = new ArrayList<>(List.of(w));
        this.board = board;
        List<String> res = new ArrayList<>();
        int[][] visited = new int[board.length][board[0].length];

        // for test
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(words.isEmpty()) return res;
                List<Integer> indexs = getIndexFirstLetter(board[i][j], words);
                List<Integer> removeIndexes = new ArrayList<>();
                for (Integer index : indexs) {
                    if(findRoadOfWord(i, j, 0, words.get(index), visited)) {
                        res.add(words.get(index));
                        removeIndexes.add(index);
                    }
                }

                removeIndexes.forEach(index -> words.remove(words.get(index)));
            }
        }

        return res;
    }

    public List<Integer> getIndexFirstLetter(char letter, List<String> words) {
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if(words.get(i).charAt(0) == letter) indexs.add(i);
        }
        return indexs;
    }

    public boolean findRoadOfWord(int row, int col, int position, String word, int[][] visited) {
        if(row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(position) || visited[row][col] == 1) return false;
        visited[row][col] = 1;
        if(board[row][col] == word.charAt(position) && position == word.length() - 1) return true;
        boolean res =
                findRoadOfWord(row + 1, col, position + 1, word, visited) ||
                findRoadOfWord(row - 1, col, position + 1, word, visited) ||
                findRoadOfWord(row , col + 1, position + 1, word, visited) ||
                findRoadOfWord(row, col - 1, position + 1, word, visited);
        visited[row][col] = 0;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain", "hklf", "hf"};

//        char[][] board = {{'a', 'a'}};
//        String[] words = {"aaa"};

        System.out.println(new WordSearch2_212().findWords(board, words));
    }
}


/*
[
["o","a","a","n"],
["e","t","a","e"],
["i","h","k","r"],
["i","f","l","v"]]
 */