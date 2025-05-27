import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, new StringBuilder(), res);
        return res;
    }

    private void dfs(int open, int close, StringBuilder sb, List<String> res) {
        if(open == 0 && close == 0) {
            res.add(sb.toString());
        }
        if(open > 0){
            sb.append('(');
            dfs(open - 1, close, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close > open){
            sb.append(')');
            dfs(open, close - 1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses_22().generateParenthesis(3));
    }
}
